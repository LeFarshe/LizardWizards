package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

import java.util.Dictionary;

public abstract class ProjectileDecorator extends Projectile {
    protected final Projectile wrappedProjectile;
    public ProjectileDecorator(Projectile projectile) {
        super(projectile);
        wrappedProjectile = projectile;
    }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings() {
        return wrappedProjectile.GetSpriteSettings();
    }

    @Override
    public boolean IsDestroyed() {
        return wrappedProjectile.IsDestroyed();
    }

    @Override
    public EntitySprite GetSprite() {
        return wrappedProjectile.GetSprite();
    }

    @Override
    public Collider GetCollider(CollisionLayer layer) {
        return wrappedProjectile.GetCollider(layer);
    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
        wrappedProjectile.Collide(collider, layer);
    }

    @Override
    public double getDamage() {
        return wrappedProjectile.getDamage();
    }

    @Override
    public Projectile shoot(Vector2 direction) {
        return wrappedProjectile.shoot(direction);
    }
}
