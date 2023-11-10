package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ItmSpectral extends ProjectileDecorator {
    public ItmSpectral(Projectile projectile) {
        super(projectile);
        spriteColor = new SpriteColor(0, 0, 0.3, 0.5);
    }

    @Override
    public Projectile shoot(Vector2 direction) {
        var projectile = wrappedProjectile.shoot(direction);
        projectile.spriteColor = spriteColor;
        return projectile;
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

}
