package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.client.sprites.SpriteSheet;
import com.lizardwizards.lizardwizards.core.gameplay.Utils;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.chain.Handler;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.server.ServerTimer;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

public class TurretProjectile extends Projectile implements Handler {
    IWeapon turretWeapon;
    Handler next = null;
    static double maxDistance = 200;
    double deceleration = 1000;
    boolean isFirst = false;
    int turretState = 0;
    final EntitySprite spriteDefault;
    final EntitySprite spriteShooting;
    final EntitySprite spriteNotShooting;
    double seenTimeout = 0.5;
    double seenTimer = seenTimeout;

    public TurretProjectile(double damage, double shotSpeed, double shotDuration, Vector2 position, Vector2 direction, IWeapon weapon) {
        super(damage, shotSpeed, shotDuration, position, direction, new Vector2(0, 0));
        spriteDefault = new ImageSprite("images/projectiles/TurretClosed.png");
        spriteShooting = new ImageSprite("images/projectiles/TurretShooting.png");
        spriteNotShooting = new ImageSprite("images/projectiles/TurretNotShooting.png");
        entitySprite = new SpriteSheet((Supplier<EntitySprite> & Serializable)this::getTurretSprite);
        spriteSize = new Vector2(entitySprite.getWidth(), entitySprite.getHeight());
        ((SpriteSheet)entitySprite).updateSupplier((Supplier<EntitySprite> & Serializable)() ->
                ((TurretProjectile)Utils.getEntityList().get(uuid).entity).getTurretSprite());
        turretWeapon = weapon;
    }

    public EntitySprite getTurretSprite() {
        EntitySprite result;
        if (seenTimer < 0 && !Utils.isServer()){
            turretState = 0;
        }
        switch (turretState){
            case 0 -> {
                result = spriteDefault;
            }
            case 1 -> {
                result = spriteShooting;
            }
            default -> {
                result = spriteNotShooting;
            }
        }
        return result;
    }

    public void shootTurret(List<IProjectile> projectiles){

        for (IProjectile projectile: projectiles){
            EntityWrapper entity = new EntityWrapper(projectile, projectile.GetSprite(), projectile.GetCollider(CollisionLayer.PlayerProjectile));
            ServerTimer.addNewEntity(entity, projectile.uuid);
        }

    }

    public EntityWrapper getNearbyEnemy(){
        double currentMaxDistance = maxDistance;
        EntityWrapper nearbyEnemy = null;
        for (Map.Entry<UUID, EntityWrapper> entry : Utils.getEntityList().entrySet()) {
            EntityWrapper entity = entry.getValue();
            if (entity.collider != null && entity.collider.layer == CollisionLayer.Enemy) {
                double distanceTo = position.DistanceTo(entity.entity.GetPosition());
                if (distanceTo < currentMaxDistance) {
                    currentMaxDistance = distanceTo;
                    nearbyEnemy = entity;
                }
            }
        }
        return nearbyEnemy;
    }

    @Override
    public void MoveByDelta(double delta){
        duration -= delta;
        seenTimer -= delta;
        Move(direction.Copy().Multiply(speed * delta));
        speed -= deceleration * delta;
        if (speed < 0) { speed = 0; }
        if (isFirst){
            turretWeapon.AddTimeWithoutShoot(delta);
        }
    }

    @Override
    public Collider GetCollider(CollisionLayer layer){
        return null;
    }

    @Override
    public void setNext(Handler handler) {
        next = handler;
    }
    public void setFirst(){isFirst = true;}

    @Override
    public void handle() {
        seenTimer = seenTimeout;
        EntityWrapper nearbyEnemy = getNearbyEnemy();
        if (nearbyEnemy != null){
            turretState = 1;
            Vector2 newDirection = nearbyEnemy.entity.GetPosition().AddVector(position.Copy().Multiply(-1)).Normalize();
            List<IProjectile> projectiles = turretWeapon.ContinueShooting(0, newDirection, position);
            if (projectiles != null){
                shootTurret(projectiles);
            }
        }
        else{
            turretState = 2;
            if (next != null){
                next.handle();
            }
        }
    }

    @Override
    public boolean toBeRemoved() {
        return IsDestroyed();
    }

    @Override
    public TurretProjectile clone() {
        TurretProjectile clone = new TurretProjectile(damage, speed, duration, position.Copy(), direction.Copy(), turretWeapon.clone());
        clone.uuid = uuid;
        clone.turretState = turretState;
        clone.seenTimer = seenTimer;
        return clone;
    }
}
