package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;

public class ItmDoubleCaliber extends ProjectileDecorator {
    private final double damageMultiplier = 2.5;
    private final double sizeMultiplier = 2.5;

    public ItmDoubleCaliber(IProjectile projectile) {
        super(projectile);
    }

    @Override
    public IProjectile shoot(Vector2 direction, Vector2 position) {
        var projectile = wrappedProjectile.shoot(direction, position);
        return new ItmDoubleCaliber(projectile);
    }

    @Override
    public double getDamage() {
        return wrappedProjectile.getDamage() * damageMultiplier;
    }

    @Override
    public EntitySprite GetSprite() {
        var sprite = wrappedProjectile.GetSprite();
        sprite.scale(sizeMultiplier);
        return sprite;
    }

    @Override
    public IProjectile clone() {
        return new ItmDoubleCaliber(wrappedProjectile.clone());
    }
}
