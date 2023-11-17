package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.core.Vector2;

public class ItmTimeBullets extends ProjectileDecorator {
    private Vector2 initialRelativePosition;
    private boolean warped = false;

    public ItmTimeBullets(IProjectile projectile) {
        super(projectile);
    }

    @Override
    public IProjectile shoot(Vector2 direction, Vector2 position) {
        var dir = direction.Copy();
        position.AddVector(initialRelativePosition);
        var projectile = wrappedProjectile.shoot(dir.Multiply(-1), position);
        initialRelativePosition = dir.Multiply(projectile.getDuration()*-projectile.getSpeed());
        var shotProjectile = new ItmTimeBullets(projectile);
        shotProjectile.initialRelativePosition = initialRelativePosition;
        return shotProjectile;
    }

    @Override
    public IProjectile clone() {
        return new ItmTimeBullets(wrappedProjectile.clone());
    }
}
