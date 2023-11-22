package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

public class Aggravator extends WeaponUpgrade{
    double speedMultiplier = 2;
    double durationMultiplier = 0.3;
    public Aggravator(){
        super(new RectangleSprite(new Vector2(0,0), new Vector2(50,50)));
    }
    @Override
    public IWeapon upgrade(IWeapon weapon) {
        weapon.setShotSpeed(weapon.getShotSpeed() * speedMultiplier);
        weapon.setShotDuration(weapon.getShotDuration() * durationMultiplier);
        return weapon;
    }
}
