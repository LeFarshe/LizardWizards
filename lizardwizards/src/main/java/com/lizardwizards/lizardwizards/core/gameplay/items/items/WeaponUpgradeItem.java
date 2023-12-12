package com.lizardwizards.lizardwizards.core.gameplay.items.items;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import com.lizardwizards.lizardwizards.core.gameplay.items.Item;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgrade;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.TurretWeapon;

public class WeaponUpgradeItem extends Item {

    WeaponUpgrade upgrade;

    public WeaponUpgradeItem(WeaponUpgrade upgrade) {
        super(upgrade.getSprite(), new Vector2(WeaponUpgrade.size, WeaponUpgrade.size));
        this.upgrade = upgrade;
    }

    @Override
    public void collect(Player player) {
        if (player.getCurrentWeapon() instanceof TurretWeapon){
            TurretWeapon turretWeapon = (TurretWeapon) player.getCurrentWeapon();
            turretWeapon.setWeapon(upgrade.upgrade(turretWeapon.getWeapon()));
        }
        else {
            int currentWeapon = player.currentWeapon;
            player.weapons.set(currentWeapon, upgrade.upgrade(player.getCurrentWeapon()));
        }
    }
}
