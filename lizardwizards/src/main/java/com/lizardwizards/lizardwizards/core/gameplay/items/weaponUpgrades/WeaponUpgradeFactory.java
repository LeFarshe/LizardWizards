package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;

public class WeaponUpgradeFactory {
    public WeaponUpgradeFactory(){};
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
}
