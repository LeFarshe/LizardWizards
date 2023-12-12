package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;

public abstract class TurretWeapon extends Weapon{
    IWeapon turretWeapon;
    TurretWeapon(double damage, double shotSpeed, double shotDuration, double fireRate, Vector2 projectileSize, ImageSprite hudIcon, IWeapon weapon) {
        super(damage, shotSpeed, shotDuration, fireRate, projectileSize, hudIcon);
        turretWeapon = weapon;
    }

    public IWeapon getWeapon(){
        return turretWeapon;
    }
    public void setWeapon(IWeapon weapon) { turretWeapon = weapon;}

}
