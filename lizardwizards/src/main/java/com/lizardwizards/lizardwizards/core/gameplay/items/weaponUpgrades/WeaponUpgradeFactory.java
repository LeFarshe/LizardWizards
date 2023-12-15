package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;


import java.util.Random;

public class WeaponUpgradeFactory {
    static Random random = new Random();
    public WeaponUpgradeFactory(){}
    public WeaponUpgrade getUpgrade(WeaponUpgrades upgrade){
        WeaponUpgrade ans = null;
        switch(upgrade){
            case Aggravator -> ans =  new Aggravator();
            case BoltEnergizer -> ans = new BoltEnergizer();
            case DoubleCaliber -> ans =  new DoubleCaliber();
            case DoubleShots -> ans =  new DoubleShots();
            case Spectral -> ans =  new Spectral();
            case TenetShots-> ans = new TenetShots();
            case LaggyShots -> ans = new LaggyShots();
        }
        return ans;
    }

    public WeaponUpgrade getRandomUpgrade(){
        WeaponUpgrades[] upgrades = WeaponUpgrades.values();
        return getUpgrade(upgrades[random.nextInt(upgrades.length)]);
    }
}
