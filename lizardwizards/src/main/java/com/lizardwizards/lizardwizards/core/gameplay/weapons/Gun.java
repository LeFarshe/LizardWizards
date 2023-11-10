package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import java.util.ArrayList;
import java.util.List;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;

public class Gun extends Weapon{


    public Gun()
    {
        super(2,4);
    }

    @Override
    public List<Projectile> Shoot(Vector2 direction) {
        Projectile projectile = new Projectile(direction.Copy(), 300, 2, damage, new Vector2(6,6));
        List<Projectile> projectiles = new ArrayList<>();
        projectiles.add(projectile);
        return projectiles;
    }

    @Override
    public Gun clone(){
        return (Gun)super.clone();
    }
}
