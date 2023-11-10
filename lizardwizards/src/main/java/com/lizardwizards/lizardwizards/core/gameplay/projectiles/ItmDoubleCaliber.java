package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;

public class ItmDoubleCaliber extends ProjectileDecorator {
    private final double damageMultiplier = 2;
    private final double sizeMultiplier = 1.5;

    public ItmDoubleCaliber(Projectile projectile) {
        super(projectile);
        spriteSize.Multiply(sizeMultiplier);
    }

    @Override
    public Projectile shoot(Vector2 direction) {
        var projectile = wrappedProjectile.shoot(direction);
        projectile.damage *= damageMultiplier;
        projectile.spriteSize.Multiply(sizeMultiplier);
        return projectile;
    }

    @Override
    public double getDamage() {
        return wrappedProjectile.getDamage() * damageMultiplier;
    }

    @Override
    public EntitySprite GetSprite() {
        var sprite = wrappedProjectile.GetSprite();
        sprite.Resize(sizeMultiplier);
        return sprite;
    }
}
