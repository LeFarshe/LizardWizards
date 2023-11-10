package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.core.gameplay.projectiles.ProjectileDecorators;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WeaponFactory {
    public Weapon getWeapon(WeaponTypes weapon) {
        switch (weapon){
            case Pistol -> {
                var gun = new Gun();
                randomlyDecorate(gun);
                return gun;
            }
            case Shotgun -> {
                var gun = new Shotgun();
                randomlyDecorate(gun);
                return gun;
            }
            default ->
            {
                return null;
            }
        }
    }

    void randomlyDecorate(Weapon weapon) {
        Random rand = new Random();
        int randomUpgradeCount = 1;
        LinkedList<ProjectileDecorators> projectileDecorators = new LinkedList<>(List.of(ProjectileDecorators.Spectral,
                ProjectileDecorators.Aggrevator,
                ProjectileDecorators.DoubleCaliber,
                ProjectileDecorators.TimeBullets));
        for (int i =0; i< randomUpgradeCount; i++){
            weapon.DecorateProjectile(projectileDecorators.get(rand.nextInt(projectileDecorators.size())));
        }
    }
}
