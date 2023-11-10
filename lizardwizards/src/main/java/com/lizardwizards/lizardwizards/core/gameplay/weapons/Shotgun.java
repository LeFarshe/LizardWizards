package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.ItmAggravator;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.ItmDoubleCaliber;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.ItmSpectral;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;

import java.util.ArrayList;
import java.util.List;

public class Shotgun extends Weapon{
    int projectiles = 8;
    double spread = 0.5;
    public Shotgun() {
        super(1, 1.5, new Projectile(500,0.5, 1, new Vector2(3,3)));
        shotProjectile = new ItmSpectral(shotProjectile);
    }

    @Override
    public List<Projectile> Shoot(Vector2 direction) {
        List<Projectile> projectileList = new ArrayList<>();
        double startSpread = spread / 2;
        double spreadPerIteration = spread / (projectiles - 1);
        direction.Rotate(-startSpread);
        for (int i = 0; i < projectiles; i++){
            projectileList.add(shotProjectile.shoot(direction));
            direction.Rotate(spreadPerIteration);
        }
        return projectileList;
    }

    @Override
    public Shotgun clone(){
        Shotgun clone = (Shotgun)super.clone();
        clone.projectiles = projectiles;
        clone.spread = spread;
        return clone;
    }
}
