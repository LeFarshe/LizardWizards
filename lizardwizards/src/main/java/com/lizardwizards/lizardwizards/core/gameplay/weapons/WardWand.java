package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WardWand extends Weapon{
    int projectiles = 9;
    Random random = new Random();
    public WardWand() {
        super(2, 100,2, 1, new Vector2(4,4),
                new ImageSprite(ClientUtils.loadResource("images/weapons/WardWand.png")));
    }

    @Override
    public List<IProjectile> Shoot(Vector2 direction, Vector2 position) {
        List<IProjectile> projectileList = new ArrayList<>();
        var rotation = Math.PI*2 / projectiles;
        for (int i = 0; i < projectiles; i++) {
            projectileList.add(new Projectile(damage, shotSpeed, shotDuration, position, direction, projectileSize));
            direction.Rotate(rotation);
        }
        return projectileList;
    }

    @Override
    public WardWand clone(){
        WardWand clone = (WardWand)super.clone();
        clone.projectiles = projectiles;
        return clone;
    }
}
