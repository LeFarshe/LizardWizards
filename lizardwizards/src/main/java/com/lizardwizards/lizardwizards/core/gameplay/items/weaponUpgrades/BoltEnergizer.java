package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.*;

public class BoltEnergizer extends WeaponUpgrade{

    BoltEnergizerVisitor visitor = new BoltEnergizerVisitor();

    BoltEnergizer(){
        super(new ImageSprite("images/items/BoltEnergizer.png"));
    }

    @Override
    public IWeapon applyUpgrade(IWeapon weapon) {
        weapon.getBaseWeapon().accept(visitor);
        return weapon;
    }
}
