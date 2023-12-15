package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators.LaggyShotsDecorator;

public class LaggyShots extends WeaponUpgrade{
    public LaggyShots() {
        super(new ImageSprite("images/items/LaggyShots.png"));
    }

    protected IWeapon applyUpgrade(IWeapon weapon) {
        return new LaggyShotsDecorator(weapon);
    }
}
