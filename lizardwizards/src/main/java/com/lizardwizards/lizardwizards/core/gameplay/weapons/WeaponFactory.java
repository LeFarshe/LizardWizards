package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.core.gameplay.projectiles.ProjectileDecorators;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WeaponFactory {
    public Weapon getWeapon(WeaponTypes weapon) {
        switch (weapon) {
            case Pistol -> {
                return new Gun();
            }
            case Shotgun -> {
                return new Shotgun();
            }
            case Chaingun -> {
                return new Chaingun();
            }
            case ViolentWand -> {
                return new ViolentWand();
            }
            case WardWand -> {
                return new WardWand();
            }
            default -> {
                return null;
            }
        }
    }
}
