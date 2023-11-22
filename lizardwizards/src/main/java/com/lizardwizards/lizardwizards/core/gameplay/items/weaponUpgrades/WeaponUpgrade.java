package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

import java.io.Serializable;

public abstract class WeaponUpgrade implements Serializable {
    EntitySprite sprite;
    public static int size = 50;
    public WeaponUpgrade(EntitySprite sprite){
        this.sprite = sprite;
    }
    public abstract IWeapon upgrade(IWeapon weapon);
    public EntitySprite getSprite() { return sprite; }
}
