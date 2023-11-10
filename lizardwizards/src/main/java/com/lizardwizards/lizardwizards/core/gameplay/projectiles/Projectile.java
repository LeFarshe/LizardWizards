package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import java.io.Serializable;
import java.util.Dictionary;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public class Projectile extends Entity implements Serializable {
    protected Vector2 direction;
    protected double speed;
    protected double duration;
    protected double damage;
    protected boolean erase = false;
    protected Vector2 spriteSize;
    protected SpriteColor spriteColor;


    public Projectile(double speed, double duration, double damage, Vector2 spriteSize)
    {
        this.speed = speed;
        this.duration = duration;
        this.damage = damage;
        this.spriteSize = spriteSize;
        spriteColor = new SpriteColor(0, 0, 0);
    }

    public Projectile(double speed, double duration, double damage, Vector2 spriteSize, SpriteColor color)
    {
        this.speed = speed;
        this.duration = duration;
        this.damage = damage;
        this.spriteSize = spriteSize;
        spriteColor = color;
    }

    public Projectile(Projectile projectile) {
        this.direction = projectile.direction;
        this.speed = projectile.speed;
        this.duration = projectile.duration;
        this.damage = projectile.damage;
        this.spriteSize = projectile.spriteSize;
        this.spriteColor = projectile.spriteColor;
        this.erase = projectile.erase;
    }

    public Projectile shoot(Vector2 direction){
        var newProjectile = new Projectile(this);
        newProjectile.direction = direction.Copy();
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
        if (layer == CollisionLayer.Obstacle){
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

    public EntitySprite GetSprite() {
        return new EntitySprite(position.Copy(), spriteSize.Copy(), spriteColor);
    }

    public Collider GetCollider(CollisionLayer layer) {
        return Collider.NewRectangle(position.Copy(), spriteSize.x, spriteSize.y, layer);
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public Projectile clone(){
        Projectile clone = (Projectile)super.clone();
        if (direction != null) { clone.direction = direction.Copy(); }
        clone.speed = speed;
        clone.duration = duration;
        clone.erase = erase;
        if (spriteSize != null) {
            clone.spriteSize = spriteSize.Copy();
            clone.spriteColor = new SpriteColor(spriteColor.red, spriteColor.green, spriteColor.blue, spriteColor.opacity);
        }
        return clone;
    }
}
