package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import java.io.Serializable;
import java.util.List;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.BoltEnergizerVisitor;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.*;

public abstract class Weapon implements Serializable, IWeapon {
    double damage;
    double shotSpeed;
    double shotDuration;
    double fireRate;
    double fireTimer = 0;
    Vector2 projectileSize;

    final ImageSprite hudIcon;

    Weapon(double damage, double shotSpeed, double shotDuration, double fireRate, Vector2 projectileSize, ImageSprite hudIcon)
    {
        this.damage = damage;
        this.shotSpeed = shotSpeed;
        this.shotDuration = shotDuration;
        this.fireRate = fireRate;
        this.projectileSize = projectileSize.Copy();
        this.hudIcon = hudIcon;
    }
    @Override
    public ImageSprite getHudIcon() {
        return hudIcon.clone();
    }
    @Override
    public double getDamage(){ return damage; }
    @Override
    public void setDamage(double damage) { this.damage = damage;}
    @Override
    public double getFireRate() { return fireRate; }
    @Override
    public void setFireRate(double fireRate) { this.fireRate = fireRate;}
    @Override
    public double getShotSpeed() { return shotSpeed;}
    @Override
    public void setShotSpeed(double shotSpeed) { this.shotSpeed = shotSpeed;}
    @Override
    public double getShotDuration() { return shotDuration;}
    @Override
    public void setShotDuration(double duration) { shotDuration = duration;}
    @Override
    public Vector2 getProjectileSize() { return projectileSize.Copy(); }
    @Override
    public void setProjectileSize(Vector2 projectileSize) { this.projectileSize = projectileSize.Copy();}

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

    public abstract Weapon accept(BoltEnergizerVisitor visitor);
}
