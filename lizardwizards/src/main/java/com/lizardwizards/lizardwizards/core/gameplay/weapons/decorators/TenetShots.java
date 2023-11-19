package com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

import java.util.ArrayList;
import java.util.List;

public class TenetShots extends WeaponDecorator{
    public TenetShots(IWeapon weapon) {
        super(weapon);
    }
    @Override
    public List<IProjectile> ContinueShooting(double delta, Vector2 direction, Vector2 position) {
        List<IProjectile> temp = wrappedWeapon.ContinueShooting(delta, direction, position);
        if (temp != null){
            List<IProjectile> ans = new ArrayList<>();
            for (IProjectile projectile: temp){
                Vector2 pos = projectile.GetPosition();
                pos.AddVector(projectile.getDirection().Copy().Multiply(projectile.getDuration() * projectile.getSpeed()));
                projectile.SetPosition(pos);
                projectile.setDirection(projectile.getDirection().Multiply(-1));
                ans.add(projectile);
            }
            return ans;
        }
        return null;
    }

}
