package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ItmSpectral extends ProjectileDecorator {
    SpriteColor spriteColor;
    public ItmSpectral(IProjectile projectile) {
        super(projectile);
        spriteColor = new SpriteColor(0, 0, 0.5, 0.8);
    }

    @Override
    public IProjectile shoot(Vector2 direction) {
        var projectile = wrappedProjectile.shoot(direction);
        projectile.setColor(spriteColor);
        return new ItmSpectral(projectile);
    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
        if (layer != CollisionLayer.Obstacle) {
            wrappedProjectile.Collide(collider, layer);
        }
    }

    @Override
    public EntitySprite GetSprite() {
        var sprite = wrappedProjectile.GetSprite();
        sprite.SetPaint(spriteColor);
        sprite.ResetSprite();
        return sprite;
    }

    @Override
    public IProjectile clone() {
        return new ItmSpectral(wrappedProjectile.clone());
    }
}