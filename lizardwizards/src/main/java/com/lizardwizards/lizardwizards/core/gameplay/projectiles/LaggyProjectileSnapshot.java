package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.core.Vector2;

public class LaggyProjectileSnapshot {
    private final IProjectile projectile;
    private final Vector2 direction, position;
    private final double speed, duration;
    private final boolean erase;

    public LaggyProjectileSnapshot(IProjectile projectile, Vector2 direction, Vector2 position, double speed, double duration, boolean erase) {
        this.projectile = projectile;
        this.direction = direction;
        this.position = position;
        this.speed = speed;
        this.duration = duration;
        this.erase = erase;
    }

    public void restore(){
        projectile.SetPosition(position);
        projectile.setDirection(direction);
        projectile.setSpeed(speed);
        projectile.setDuration(duration);
        projectile.setErase(erase);
    }

}
