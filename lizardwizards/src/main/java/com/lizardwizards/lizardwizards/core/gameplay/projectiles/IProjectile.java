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

    abstract void setColor(SpriteColor spriteColor);
    public abstract double getDamage();
    abstract double getDuration();
    abstract double getSpeed();
    abstract void setDuration(double duration);
    abstract void setSpeed(double speed);

    public abstract IProjectile clone();

}
