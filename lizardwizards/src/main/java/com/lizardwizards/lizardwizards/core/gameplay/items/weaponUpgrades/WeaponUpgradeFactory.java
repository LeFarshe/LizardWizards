package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;


import java.util.Random;

public class WeaponUpgradeFactory {
    static Random random = new Random();
    public WeaponUpgradeFactory(){}
    public WeaponUpgrade getUpgrade(WeaponUpgrades upgrade){
        WeaponUpgrade ans = null;
        switch(upgrade){
            case Aggravator -> ans =  new Aggravator();
            case DoubleCaliber -> ans =  new DoubleCaliber();
            case DoubleShots -> ans =  new DoubleShots();
            case Spectral -> ans =  new Spectral();
            case TenetShots-> ans = new TenetShots();
        }
        return ans;
    }

    public WeaponUpgrade getRandomUpgrade(){
        WeaponUpgrades[] upgrades = WeaponUpgrades.values();
        return getUpgrade(upgrades[random.nextInt(upgrades.length)]);
    }
}
