package com.lizardwizards.lizardwizards;

import java.util.ArrayList;
import java.util.List;

public class Gun extends Weapon{

    @Override
    public List<Projectile> Shoot(Vector2 direction) {
        Projectile projectile = new Projectile(direction, 100, 1, new Vector2(2,2));
        List<Projectile> projectiles = new ArrayList<>();
        projectiles.add(projectile);
        return projectiles;
    }
}
