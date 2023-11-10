package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.core.Vector2;

public class ItmAggravator extends ProjectileDecorator {
    public ItmAggravator(Projectile projectile) {
        super(projectile);
    }

    @Override
    public Projectile shoot(Vector2 direction) {
        var projectile = wrappedProjectile.shoot(direction);
        projectile.speed *= 2;
        projectile.duration *= 0.7;
        return projectile;
    }
}
