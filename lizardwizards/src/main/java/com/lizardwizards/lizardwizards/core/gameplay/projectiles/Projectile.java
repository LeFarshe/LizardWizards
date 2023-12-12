package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import java.util.Dictionary;
import java.util.UUID;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public class Projectile extends IProjectile {
    protected Vector2 direction;
    protected double speed;
    protected double duration;
    protected double damage;
    protected boolean erase = false;
    protected EntitySprite entitySprite;
    protected Vector2 spriteSize;


    public Projectile(double damage, double speed, double duration, Vector2 position, Vector2 direction, Vector2 spriteSize)
    {
        this.speed = speed;
        this.duration = duration;
        this.damage = damage;
        this.spriteSize = spriteSize.Copy();
        this.entitySprite = new RectangleSprite(spriteSize);
        this.position = position.Copy();
        this.direction = direction.Copy();
    }

    public Projectile(double damage, double speed, double duration, Vector2 position, Vector2 direction, EntitySprite entitySprite)
    {
        this.speed = speed;
        this.duration = duration;
        this.damage = damage;
        this.entitySprite = entitySprite;
        this.spriteSize = new Vector2(entitySprite.getWidth(), entitySprite.getHeight());
        this.position = position.Copy();
        this.direction = direction.Copy();
    }

    public Projectile(Projectile projectile) {
        if (projectile.position != null) {
            this.position = projectile.position.Copy();
        }
        this.uuid = UUID.randomUUID();
        this.direction = projectile.direction;
        this.speed = projectile.speed;
        this.duration = projectile.duration;
        this.damage = projectile.damage;
        this.entitySprite = projectile.entitySprite;
        this.spriteSize = projectile.spriteSize;
        this.erase = projectile.erase;
    }

    @Override
    public Projectile shoot(Vector2 direction, Vector2 position){
        var newProjectile = new Projectile(this);
        newProjectile.direction = direction.Copy();
        newProjectile.SetPosition(position);
        return newProjectile;
    }

    @Override
    public void MoveByDelta(double delta)
    {
        duration -= delta;
        Move(direction.Copy().Multiply(speed * delta));
    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
        if (layer == CollisionLayer.Obstacle || layer == CollisionLayer.Enemy){
            erase = true;
        }
    }

    @Override
    public boolean IsDestroyed() {
        return duration <= 0 || erase;
    }

    @Override
    public EntitySprite GetSprite() {
        return entitySprite;
    }

    @Override
    public Collider GetCollider(CollisionLayer layer) {
        return Collider.NewRectangle(position.Copy(), spriteSize.x, spriteSize.y, layer);
    }

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public double getDuration() {
        return duration;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void setDirection(Vector2 direction) {
        this.direction = direction.Copy();
    }

    @Override
    public Vector2 getDirection() {
        return direction.Copy();
    }

    @Override
    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public Projectile clone() {

        Projectile clone = new Projectile(this);
        clone.uuid = uuid;
        if (direction != null) {
            clone.direction = direction.Copy();
        }
        if (spriteSize != null) {
            clone.spriteSize = spriteSize.Copy();
            clone.entitySprite = entitySprite.clone();
        }
        return clone;
    }
}
