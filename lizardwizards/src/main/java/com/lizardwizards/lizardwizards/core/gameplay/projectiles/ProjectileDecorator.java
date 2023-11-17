package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

import java.util.Dictionary;

public abstract class ProjectileDecorator extends IProjectile {
    protected final IProjectile wrappedProjectile;

    public ProjectileDecorator(IProjectile projectile) {
        wrappedProjectile = projectile;
    }

    @Override
    public void MoveByDelta(double delta) {
        wrappedProjectile.MoveByDelta(delta);
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
    public double getDuration() {
        return wrappedProjectile.getDuration();
    }

    @Override
    public double getSpeed() {
        return wrappedProjectile.getSpeed();
    }

    @Override
    public void setDuration(double duration) {
        wrappedProjectile.setDuration(duration);
    }

    @Override
    public void setSpeed(double speed) {
        wrappedProjectile.setSpeed(speed);
    }

    @Override
    public void setColor(SpriteColor color) {
        wrappedProjectile.setColor(color);
    }

    @Override
    public abstract IProjectile shoot(Vector2 direction, Vector2 position);

    @Override
    public void SetPosition(Vector2 position) {
        wrappedProjectile.SetPosition(position);
    }

    @Override
    public Vector2 GetPosition() {
        return wrappedProjectile.GetPosition();
    }

    @Override
    public void Move(Vector2 amount) {
        wrappedProjectile.Move(amount);
    }
}