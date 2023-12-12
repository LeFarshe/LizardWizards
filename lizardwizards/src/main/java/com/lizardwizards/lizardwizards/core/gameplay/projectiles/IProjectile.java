package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

import java.io.Serializable;

public abstract class IProjectile extends Entity implements Serializable, Cloneable {
    public abstract IProjectile shoot(Vector2 direction, Vector2 position);

    public abstract EntitySprite GetSprite();

    public abstract Collider GetCollider(CollisionLayer layer);

    public abstract double getDamage();
    public abstract double getDuration();
    public abstract double getSpeed();
    abstract void setDuration(double duration);
    abstract void setSpeed(double speed);
    public abstract void setDirection(Vector2 direction);
    public abstract Vector2 getDirection();

    public abstract IProjectile clone();

}
