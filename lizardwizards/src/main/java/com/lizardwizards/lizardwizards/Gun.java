package com.lizardwizards.lizardwizards;

import java.util.ArrayList;
import java.util.List;

public class Gun extends Weapon{

    double speed = 300;
    double duration = 2;

    @Override
    public List<Projectile> Shoot(Vector2 direction) {
        Projectile projectile = new Projectile(direction, speed, duration, new Vector2(6,6));
        List<Projectile> projectiles = new ArrayList<>();
        projectiles.add(projectile);
        return projectiles;
    }
}
