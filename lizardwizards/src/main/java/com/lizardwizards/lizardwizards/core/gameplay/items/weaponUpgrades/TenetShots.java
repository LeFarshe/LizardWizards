package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

import com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators.TenetShotsDecorator;

public class TenetShots extends WeaponUpgrade{
    public TenetShots() {
        super(new ImageSprite("images/items/Tenet.png"));
    }

    @Override
    public IWeapon upgrade(IWeapon weapon) {
        return new TenetShotsDecorator(weapon);
    }
}
