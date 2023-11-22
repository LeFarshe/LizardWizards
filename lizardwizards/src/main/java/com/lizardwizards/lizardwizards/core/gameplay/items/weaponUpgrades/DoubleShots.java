package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators.DoubleShotsDecorator;

public class DoubleShots extends WeaponUpgrade {
    public DoubleShots() {
        super(new RectangleSprite(new Vector2(0,0), new Vector2(50,50)));
    }

    @Override
    public IWeapon upgrade(IWeapon weapon) {
        return new DoubleShotsDecorator(weapon);
    }
}
