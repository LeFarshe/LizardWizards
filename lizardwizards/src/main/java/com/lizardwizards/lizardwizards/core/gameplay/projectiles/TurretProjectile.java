package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.chain.Handler;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.server.ServerTimer;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TurretProjectile extends Projectile implements Handler {
    IWeapon turretWeapon;
    Handler next = null;
    static double maxDistance = 200;
    double deceleration;
    boolean isFirst = false;
    public TurretProjectile(Projectile projectile, double deceleration, IWeapon weapon) {
        super(projectile);
        this.deceleration = deceleration;
        turretWeapon = weapon;
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
        for (Map.Entry<UUID, EntityWrapper> entry : ServerTimer.entities.entrySet()) {
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
        EntityWrapper nearbyEnemy = getNearbyEnemy();
        if (nearbyEnemy != null){
            Vector2 newDirection = nearbyEnemy.entity.GetPosition().AddVector(position.Copy().Multiply(-1)).Normalize();
            List<IProjectile> projectiles = turretWeapon.ContinueShooting(0, newDirection, position);
            if (projectiles != null){
                shootTurret(projectiles);
            }
        }
        else if (next != null){
            next.handle();
        }
    }

    @Override
    public boolean toBeRemoved() {
        return IsDestroyed();
    }
}
