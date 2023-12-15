package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators.DoubleShotsDecorator;

public class DoubleShots extends WeaponUpgrade {
    public DoubleShots() {
        super(new ImageSprite("images/items/DoubleShot.png"));
    }

    protected void applyUpgrade(IWeapon weapon) {
        weapon = new DoubleShotsDecorator(weapon);
    }
}
