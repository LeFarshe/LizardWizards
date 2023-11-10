package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

public class ItmAggravator extends ProjectileDecorator {
    public ItmAggravator(Projectile projectile) {
        super(projectile);
        wrappedProjectile.speed *= 1.5;
        wrappedProjectile.duration *= 0.7;
    }
}
