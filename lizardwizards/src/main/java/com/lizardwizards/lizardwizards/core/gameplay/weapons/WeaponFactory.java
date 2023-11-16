package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.core.gameplay.projectiles.ProjectileDecorators;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WeaponFactory {
    public Weapon getWeapon(WeaponTypes weapon) {
        switch (weapon) {
            case Pistol -> {
                var gun = new Gun();
                return gun;
            }
            case Shotgun -> {
                var gun = new Shotgun();
                return gun;
            }
            case Chaingun -> {
                var gun = new Chaingun();
                return gun;
            }
            default -> {
                return null;
            }
        }
    }
}
