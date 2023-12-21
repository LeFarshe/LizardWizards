package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators.WeaponDecorator;

import java.io.Serializable;

public abstract class WeaponUpgrade implements Serializable {
    EntitySprite sprite;
    public static int size = 50;
    public WeaponUpgrade(EntitySprite sprite){
        this.sprite = sprite;
    }

    // Template Method
    public final IWeapon upgrade(IWeapon weapon) {
        var upgradedWeapon = applyUpgrade(weapon);
        postUpgradeActions(upgradedWeapon);
        return upgradedWeapon;
    }

    protected abstract IWeapon applyUpgrade(IWeapon weapon);

    protected void postUpgradeActions(IWeapon weapon) {
        playUpgradeAnimation(weapon);
    }

    protected void playUpgradeAnimation(IWeapon weapon) {
        // Cia galima gal kokia animacija ideti, bet dbr no clue
    }
    public EntitySprite getSprite() { return sprite; }
}
