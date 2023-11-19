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
    protected Vector2 spriteSize;
    protected SpriteColor spriteColor;


    public Projectile(double damage, double speed, double duration, Vector2 position, Vector2 direction, Vector2 spriteSize)
    {
        this.speed = speed;
        this.duration = duration;
        this.damage = damage;
        this.spriteSize = spriteSize.Copy();
        this.position = position.Copy();
        this.direction = direction.Copy();
        spriteColor = new SpriteColor(0, 0, 0);
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
        this.spriteSize = projectile.spriteSize;
        this.spriteColor = projectile.spriteColor;
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
    public Dictionary<String, Integer> GetSpriteSettings() {
        return null;
    }

    @Override
    public boolean IsDestroyed() {
        return duration <= 0 || erase;
    }

    @Override
    public EntitySprite GetSprite() {
        return new RectangleSprite(position.Copy(), spriteSize.Copy(), spriteColor);
    }

    @Override
    public Collider GetCollider(CollisionLayer layer) {
        return Collider.NewRectangle(position.Copy(), spriteSize.x, spriteSize.y, layer);
    }

    @Override
    public void setColor(SpriteColor color) {
        spriteColor = color;
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
        if (direction != null) {
            clone.direction = direction.Copy();
        }
        if (spriteSize != null) {
            clone.spriteSize = spriteSize.Copy();
            clone.spriteColor = new SpriteColor(spriteColor.red, spriteColor.green, spriteColor.blue, spriteColor.opacity);
        }
        return clone;
    }
}
