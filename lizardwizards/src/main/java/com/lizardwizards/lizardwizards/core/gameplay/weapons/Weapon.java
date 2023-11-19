package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import java.io.Serializable;
import java.util.List;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.*;

public abstract class Weapon implements Serializable, IWeapon {
    double damage;
    double fireRate;
    double fireTimer = 0;
    IProjectile shotProjectile;

    final ImageSprite hudIcon;

    Weapon(double fireRate, IProjectile shotProjectile, ImageSprite hudIcon)
    {
        this.fireRate = fireRate;
        this.shotProjectile = shotProjectile;
        this.hudIcon = hudIcon;
    }
    @Override
    public ImageSprite getHudIcon() {
        return hudIcon.clone();
    }
    @Override
    public double getDamage(){ return damage; }
    @Override
    public double getFireRate() { return fireRate; }
    @Override
    public void setFireRate(double fireRate) { this.fireRate = fireRate;}
    @Override
    public List<IProjectile> ContinueShooting(double delta, Vector2 direction, Vector2 position)
    {
        fireTimer += delta;
        if (fireTimer >= 1.0/fireRate)
        {
            fireTimer -= (1.0/fireRate);
            // position has to be cloned within the overloaded function
            return Shoot(direction.Copy(), position);
        }
        return null;
    }

    @Override
    public List<IProjectile> AddTimeWithoutShoot(double delta)
    {
        if (fireTimer != 1.0/fireRate){
            fireTimer += delta;
            if (fireTimer > 1.0/fireRate) { fireTimer = 1.0/fireRate; }
        }
        return null;
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
