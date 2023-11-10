package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.*;

public abstract class Weapon implements Serializable, Cloneable {
    double damage;
    double fireRate;
    double fireTimer = 0;
    IProjectile shotProjectile;

    Weapon(double damage, double fireRate, IProjectile shotProjectile)
    {
        this.damage = damage;
        this.fireRate = fireRate;
        this.shotProjectile = shotProjectile;
    }
    public abstract List<IProjectile> Shoot(Vector2 direction);
    public List<IProjectile> ContinueShooting(double delta, Vector2 direction)
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

    public void DecorateProjectile(ProjectileDecorators projectileDecorator) {
        switch (projectileDecorator) {
            case Spectral -> shotProjectile = new ItmSpectral(shotProjectile);
            case Aggrevator -> shotProjectile = new ItmAggravator(shotProjectile);
            case TimeBullets -> shotProjectile = new ItmTimeBullets(shotProjectile);
            case DoubleCaliber -> shotProjectile = new ItmDoubleCaliber(shotProjectile);
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
