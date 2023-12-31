package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

public class DoubleCaliber extends WeaponUpgrade{
    double damageMultiplier = 2.5;
    double sizeMultiplier = 2.5;
    double fireRateMultiplier = 2.0/3.0;

    public DoubleCaliber() {
        super(new ImageSprite("images/items/DoubleCaliber.png"));
    }

    @Override
    protected IWeapon applyUpgrade(IWeapon weapon) {
        weapon.setDamage(weapon.getDamage() * damageMultiplier);
        weapon.setProjectileSize(weapon.getProjectileSize().Multiply(sizeMultiplier));
        weapon.setFireRate(weapon.getFireRate() * fireRateMultiplier);
        return weapon;
    }
}
