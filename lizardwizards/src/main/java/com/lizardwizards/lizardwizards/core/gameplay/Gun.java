package com.lizardwizards.lizardwizards.core.gameplay;

import java.util.ArrayList;
import java.util.List;

import com.lizardwizards.lizardwizards.core.Vector2;

public class Gun extends Weapon{


    public Gun()
    {
        super(1,10);
    }

    @Override
    public List<Projectile> Shoot(Vector2 direction) {
        Projectile projectile = new Projectile(direction, 300, 2, new Vector2(6,6));
        List<Projectile> projectiles = new ArrayList<>();
        projectiles.add(projectile);
        return projectiles;
    }
}
