package com.lizardwizards.lizardwizards.core.gameplay.items.items;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import com.lizardwizards.lizardwizards.core.gameplay.items.Item;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgrade;

public class WeaponUpgradeItem extends Item {

    WeaponUpgrade upgrade;

    public WeaponUpgradeItem(WeaponUpgrade upgrade) {
        super(upgrade.getSprite(), new Vector2(WeaponUpgrade.size, WeaponUpgrade.size));
        this.upgrade = upgrade;
    }

    @Override
    public void collect(Player player) {
        int currentWeapon = player.currentWeapon;
        player.weapons.set(currentWeapon, upgrade.upgrade(player.getCurrentWeapon()));
    }
}
