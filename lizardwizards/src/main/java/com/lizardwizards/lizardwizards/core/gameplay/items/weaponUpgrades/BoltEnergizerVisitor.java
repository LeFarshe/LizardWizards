package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.core.gameplay.weapons.*;

import java.io.Serializable;

public class BoltEnergizerVisitor implements BoltVisitor, Serializable {
    final double multiplier = 1.5;

    @Override
    public Weapon visit(Gun gun) {
        gun.setShotSpeed(gun.getShotSpeed() * multiplier);
        return gun;
    }

    @Override
    public Weapon visit(Shotgun shotgun) {
        shotgun.setShotSpeed(shotgun.getShotSpeed() * multiplier);
        return shotgun;
    }

    @Override
    public Weapon visit(Chaingun chaingun) {
        chaingun.setShotSpeed(chaingun.getShotSpeed() * multiplier);
        return chaingun;
    }

    @Override
    public Weapon visit(ViolentWand violentWand) {
        violentWand.setShotDuration(violentWand.getShotDuration() * multiplier);
        return violentWand;
    }

    @Override
    public Weapon visit(WardWand wardWand) {
        wardWand.setShotDuration(wardWand.getShotDuration() * multiplier);
        return wardWand;
    }

    @Override
    public Weapon visit(TurretWeapon turretWeapon) {
        turretWeapon.setShotDuration(turretWeapon.getShotDuration() * multiplier);
        return turretWeapon;
    }

    @Override
    public Weapon visit(TestWeapon testWeapon) {
        testWeapon.setShotDuration(testWeapon.getShotDuration() * multiplier);
        return testWeapon;
    }
}
