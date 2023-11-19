package com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

import java.util.ArrayList;
import java.util.List;

public class DoubleShots extends WeaponDecorator {
    final double spread = 0.1;
    final double fireRateMultiplier = 2.0/3.0;
    public DoubleShots(IWeapon weapon){
        super(weapon);
        wrappedWeapon.setFireRate(wrappedWeapon.getFireRate() * fireRateMultiplier);
    }

    @Override
    public List<IProjectile> ContinueShooting(double delta, Vector2 direction, Vector2 position) {
        List<IProjectile> temp = wrappedWeapon.ContinueShooting(delta, direction, position);

        if (temp == null) { return null; }
        else {
            List<IProjectile> ans = new ArrayList<>();
            IProjectile tempProjectile;
            for (IProjectile projectile : temp){
                tempProjectile = projectile.clone();
                tempProjectile.setDirection(projectile.getDirection().Copy().Rotate(-spread));
                ans.add(tempProjectile);

                tempProjectile = projectile.clone();
                tempProjectile.setDirection(projectile.getDirection().Copy().Rotate(spread));
                ans.add(tempProjectile);
            }
            return ans;
        }
    }

    public DoubleShots clone() {
        return (DoubleShots) super.clone();
    }
}
