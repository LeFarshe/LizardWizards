package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

public class Aggravator extends WeaponUpgrade{
    double speedMultiplier = 2;
    double durationMultiplier = 0.3;
    public Aggravator(){
        super(new ImageSprite("images/items/Aggravator.png"));
    }
    @Override
    protected void applyUpgrade(IWeapon weapon) {
        weapon.setShotSpeed(weapon.getShotSpeed() * speedMultiplier);
        weapon.setShotDuration(weapon.getShotDuration() * durationMultiplier);
    }
}
