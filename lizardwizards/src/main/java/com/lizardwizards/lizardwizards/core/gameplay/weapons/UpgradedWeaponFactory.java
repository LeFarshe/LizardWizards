package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators.*;

import java.util.List;
import java.util.Random;

public class UpgradedWeaponFactory extends WeaponFactory {
    int upgradeAmount;
    static Random random = new Random();
    public UpgradedWeaponFactory(int upgradeAmount){
        this.upgradeAmount = upgradeAmount;
    }

    @Override
    public IWeapon getWeapon(WeaponTypes weapon){
        return randomlyDecorate(super.getWeapon(weapon));
    }

    private IWeapon randomlyDecorate(IWeapon weapon) {
        List<WeaponDecorators> weaponDecorators = List.of(WeaponDecorators.Aggravator,
                WeaponDecorators.DoubleCaliber,
                WeaponDecorators.DoubleShots,
                WeaponDecorators.Spectral,
                WeaponDecorators.TenetShots);
        for (int i = 0; i < upgradeAmount; i++){
            switch(weaponDecorators.get(random.nextInt(weaponDecorators.size()))){
                case Aggravator -> weapon = new Aggravator(weapon);
                case DoubleCaliber -> weapon = new DoubleCaliber(weapon);
                case DoubleShots -> weapon = new DoubleShotsDecorator(weapon);
                case Spectral -> weapon = new SpectralDecorator(weapon);
                case TenetShots -> weapon = new TenetShotsDecorator(weapon);
            }
        }
        return weapon;
    }
}
