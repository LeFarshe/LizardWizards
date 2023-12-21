package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

import com.lizardwizards.lizardwizards.core.gameplay.weapons.*;

public interface BoltVisitor {
    Weapon visit(Gun gun);
    Weapon visit(Shotgun shotgun);
    Weapon visit(Chaingun chaingun);

    Weapon visit(ViolentWand violentWand);
    Weapon visit(WardWand wardWand);

    Weapon visit(TurretWeapon turretWeapon);
    Weapon visit(TestWeapon testWeapon);
}
