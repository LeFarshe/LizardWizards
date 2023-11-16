package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.core.gameplay.projectiles.ProjectileDecorators;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class UpgradedWeaponFactory extends WeaponFactory {
    int upgradeAmount;
    public UpgradedWeaponFactory(int upgradeAmount){
        this.upgradeAmount = upgradeAmount;
    }

    @Override
    public Weapon getWeapon(WeaponTypes weapon){
        return randomlyDecorate(super.getWeapon(weapon));
    }

    private Weapon randomlyDecorate(Weapon weapon) {
        Random rand = new Random();
        LinkedList<ProjectileDecorators> projectileDecorators = new LinkedList<>(List.of(ProjectileDecorators.Spectral,
                ProjectileDecorators.Aggrevator,
                ProjectileDecorators.DoubleCaliber,
                ProjectileDecorators.TimeBullets));
        for (int i =0; i< upgradeAmount; i++){
            weapon.DecorateProjectile(projectileDecorators.get(rand.nextInt(projectileDecorators.size())));
        }
        return weapon;
    }
}
