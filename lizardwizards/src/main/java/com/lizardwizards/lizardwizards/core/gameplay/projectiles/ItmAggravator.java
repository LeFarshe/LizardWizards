package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.core.Vector2;

public class ItmAggravator extends ProjectileDecorator {
    public ItmAggravator(IProjectile projectile) {
        super(projectile);
    }

    @Override
    public IProjectile shoot(Vector2 direction) {
        var projectile = wrappedProjectile.shoot(direction);
        projectile.setSpeed(projectile.getSpeed()*2);
        projectile.setDuration(projectile.getDuration()*0.3);
        return new ItmAggravator(projectile);
    }

    @Override
    public IProjectile clone() {
        return new ItmAggravator(wrappedProjectile.clone());
    }
}
