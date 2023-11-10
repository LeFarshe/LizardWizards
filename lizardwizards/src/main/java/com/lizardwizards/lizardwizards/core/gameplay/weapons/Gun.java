package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import java.util.ArrayList;
import java.util.List;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;

public class Gun extends Weapon{


    public Gun()
    {
        super(2,4, new Projectile(300, 2, 2, new Vector2(6,6)));
    }

    @Override
    public List<IProjectile> Shoot(Vector2 direction) {
        IProjectile projectile = shotProjectile.shoot(direction);
        List<IProjectile> projectiles = new ArrayList<>();
        projectiles.add(projectile);
        return projectiles;
    }

    @Override
    public Gun clone(){
        return (Gun)super.clone();
    }
}
