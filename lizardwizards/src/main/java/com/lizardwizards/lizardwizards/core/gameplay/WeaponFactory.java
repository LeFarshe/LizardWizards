package com.lizardwizards.lizardwizards.core.gameplay;

public class WeaponFactory {
    public Weapon getWeapon(String weapon) {
        if (weapon == null){
            return null;
        }
        if (weapon.equalsIgnoreCase("GUN")){
            return new Gun();
        }
        else if (weapon.equalsIgnoreCase("SHOTGUN")){
            return new Shotgun();
        }

        return null;
    }
}
