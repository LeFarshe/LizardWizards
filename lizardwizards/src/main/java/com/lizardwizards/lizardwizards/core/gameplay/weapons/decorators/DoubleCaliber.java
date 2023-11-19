package com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators;

import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

public class DoubleCaliber extends WeaponDecorator{
    double damageMultiplier = 2.5;
    double sizeMultiplier = 2.5;
    double fireRateMultiplier = 2.0/3.0;
    public DoubleCaliber(IWeapon weapon) {
        super(weapon);
        wrappedWeapon.setDamage(wrappedWeapon.getDamage() * damageMultiplier);
        wrappedWeapon.setProjectileSize(wrappedWeapon.getProjectileSize().Multiply(sizeMultiplier));
        wrappedWeapon.setFireRate(wrappedWeapon.getFireRate() * fireRateMultiplier);
    }
}
