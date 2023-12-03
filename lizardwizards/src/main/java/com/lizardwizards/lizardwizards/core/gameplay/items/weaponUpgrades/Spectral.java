package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators.SpectralDecorator;

public class Spectral extends WeaponUpgrade{
    public Spectral() {
        super(new ImageSprite("images/items/Spectral.png"));
    }

    @Override
    public IWeapon upgrade(IWeapon weapon) {
        return new SpectralDecorator(weapon);
    }
}