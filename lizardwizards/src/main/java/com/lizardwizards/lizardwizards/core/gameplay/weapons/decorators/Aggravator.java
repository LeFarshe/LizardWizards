package com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators;

import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

public class Aggravator extends WeaponDecorator {
    double speedMultiplier = 2;
    double durationMultiplier = 0.3;
    public Aggravator(IWeapon weapon) {
        super(weapon);
        wrappedWeapon.setShotSpeed(wrappedWeapon.getShotSpeed() * speedMultiplier);
        wrappedWeapon.setShotDuration(wrappedWeapon.getShotDuration() * durationMultiplier);
    }
}
