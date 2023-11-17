package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.core.Vector2;

public class ItmAggravator extends ProjectileDecorator {
    public ItmAggravator(IProjectile projectile) {
        super(projectile);
    }

    @Override
    public IProjectile shoot(Vector2 direction, Vector2 position) {
        var projectile = wrappedProjectile.shoot(direction, position);
        projectile.setSpeed(projectile.getSpeed()*2);
        projectile.setDuration(projectile.getDuration()*0.3);
        return new ItmAggravator(projectile);
    }

    @Override
    public IProjectile clone() {
        return new ItmAggravator(wrappedProjectile.clone());
    }
}
