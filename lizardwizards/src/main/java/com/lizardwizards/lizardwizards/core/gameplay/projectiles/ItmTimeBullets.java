package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.core.Vector2;

public class ItmTimeBullets extends ProjectileDecorator {
    private Vector2 initialRelativePosition;
    private boolean warped = false;

    public ItmTimeBullets(IProjectile projectile) {
        super(projectile);
    }

    @Override
    public IProjectile shoot(Vector2 direction) {
        var dir = direction.Copy();
        var projectile = wrappedProjectile.shoot(dir.Multiply(-1));
        initialRelativePosition = dir.Multiply(projectile.getDuration()*-projectile.getSpeed());
        var shotProjectile = new ItmTimeBullets(projectile);
        shotProjectile.initialRelativePosition = initialRelativePosition;
        return shotProjectile;
    }

    @Override
    public void SetPosition(Vector2 position) {
        if (!warped) {
            wrappedProjectile.SetPosition(position.AddVector(initialRelativePosition));
            warped = true;
        }
        else {
            wrappedProjectile.SetPosition(position);
        }
    }

    @Override
    public IProjectile clone() {
        return new ItmTimeBullets(wrappedProjectile.clone());
    }
}
