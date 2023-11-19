package com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.ItmSpectral;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

import java.util.ArrayList;
import java.util.List;

public class Spectral extends WeaponDecorator{
    public Spectral(IWeapon weapon) {
        super(weapon);
    }

    public List<IProjectile> ContinueShooting(double delta, Vector2 direction, Vector2 position) {
        List<IProjectile> temp = wrappedWeapon.ContinueShooting(delta, direction, position);
        if (temp != null){
            List<IProjectile> ans = new ArrayList<>();
            for(IProjectile projectile: temp){
                ans.add(new ItmSpectral(projectile));
            }
            return ans;
        }
        return null;
    }
}
