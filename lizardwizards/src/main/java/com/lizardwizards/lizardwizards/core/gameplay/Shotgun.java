package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Shotgun extends Weapon{
    int projectiles = 8;
    double spread = 0.5;
    public Shotgun() {
        super(2, 1);
    }

    @Override
    public List<Projectile> Shoot(Vector2 direction) {
        List<Projectile> projectileList = new ArrayList<>();
        double startSpread = spread / 2;
        double spreadPerIteration = spread / (projectiles - 1);
        direction.Rotate(-startSpread);
        for (int i = 0; i < projectiles; i++){
            projectileList.add(new Projectile(direction.Copy(), 500,0.5, new Vector2(3,3)));
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
