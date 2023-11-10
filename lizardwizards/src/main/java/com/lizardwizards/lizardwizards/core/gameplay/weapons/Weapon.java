package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import java.io.Serializable;
import java.util.List;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Projectile;

public abstract class Weapon implements Serializable, Cloneable {
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
            return Shoot(direction.Copy());
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

    @Override
    public Weapon clone() {
        try {
            Weapon clone = (Weapon) super.clone();
            clone.damage = damage;
            clone.fireRate = fireRate;
            clone.fireTimer = fireTimer;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
