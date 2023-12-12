package com.lizardwizards.lizardwizards.core.gameplay.weapons;

public class WeaponFactory {
    public IWeapon getWeapon(WeaponTypes weapon) {
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
            case TurretWand -> {
                return new TurretWand();
            }
            default -> {
                return null;
            }
        }
    }
}
