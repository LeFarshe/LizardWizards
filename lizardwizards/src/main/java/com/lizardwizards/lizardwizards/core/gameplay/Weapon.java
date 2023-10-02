package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.List;

public abstract class Weapon {
    double damage;
    double fireRate;
    double fireTimer = 0;

    Weapon(double damage, double fireRate)
    {
        this.damage = damage;
        this.fireRate = fireRate;
    }
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
