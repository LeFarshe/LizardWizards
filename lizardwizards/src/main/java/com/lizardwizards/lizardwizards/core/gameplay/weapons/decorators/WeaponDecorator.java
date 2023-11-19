package com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

import java.util.List;

public abstract class WeaponDecorator implements IWeapon {
    protected IWeapon wrappedWeapon;
    public WeaponDecorator(IWeapon weapon){
        wrappedWeapon = weapon;
    }
    @Override
    public double getDamage() {
        return wrappedWeapon.getDamage();
    }
    @Override
    public void setDamage(double damage) { wrappedWeapon.setDamage(damage);}
    @Override
    public double getShotSpeed() { return wrappedWeapon.getShotSpeed();}
    @Override
    public void setShotSpeed(double shotSpeed) { wrappedWeapon.setShotSpeed(shotSpeed);}

    @Override
    public double getFireRate() {
        return wrappedWeapon.getFireRate();
    }
    @Override
    public void setFireRate(double fireRate) {wrappedWeapon.setFireRate(fireRate);}
    @Override
    public double getShotDuration() { return wrappedWeapon.getShotDuration();}
    @Override
    public void setShotDuration(double duration) { wrappedWeapon.setShotDuration(duration);}

    @Override
    public ImageSprite getHudIcon() {
        return wrappedWeapon.getHudIcon();
    }

    @Override
    public List<IProjectile> Shoot(Vector2 direction, Vector2 position) {
        return wrappedWeapon.Shoot(direction, position);
    }

    @Override
    public List<IProjectile> ContinueShooting(double delta, Vector2 direction, Vector2 position) {
        return wrappedWeapon.ContinueShooting(delta, direction, position);
    }

    @Override
    public List<IProjectile> AddTimeWithoutShoot(double delta) {
        return wrappedWeapon.AddTimeWithoutShoot(delta);
    }
    public WeaponDecorator clone(){
        try {
            WeaponDecorator clone = (WeaponDecorator) super.clone();
            clone.wrappedWeapon = wrappedWeapon.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
