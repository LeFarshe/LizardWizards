package com.lizardwizards.lizardwizards;

import java.util.List;

public abstract class Weapon {
    double damage = 1;
    double fireRate = 1;
    double fireTimer = 0;
    public abstract List<Projectile> Shoot(Vector2 direction);
    public List<Projectile> ContinueShooting(double delta, Vector2 direction)
    {
        fireTimer += delta;
        if (fireTimer >= 1.0/fireRate)
        {
            fireTimer -= (1.0/fireRate);
            return Shoot(direction);
        }
        return null;
    }

    public void AddTimeWithoutShoot(double delta)
    {
        if (fireTimer != 1.0/fireRate){
            fireTimer += delta;
            if (fireTimer > 1.0/fireRate) { fireTimer = 1.0/fireRate; }
        }
    }
}
