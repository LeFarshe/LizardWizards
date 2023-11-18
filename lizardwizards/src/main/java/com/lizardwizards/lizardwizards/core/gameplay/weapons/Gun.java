package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import java.util.ArrayList;
import java.util.List;

import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;

public class Gun extends Weapon{


    public Gun()
    {
        super(4, new Projectile(300, 2, 2, new Vector2(6,6)),
        new ImageSprite(ClientUtils.loadResource("images/weapons/Gun.png")));
    }

    @Override
    public List<IProjectile> Shoot(Vector2 direction, Vector2 position) {
        IProjectile projectile = shotProjectile.shoot(direction, position.Copy());
        List<IProjectile> projectiles = new ArrayList<>();
        projectiles.add(projectile);
        return projectiles;
    }

    @Override
    public Gun clone(){
        return (Gun)super.clone();
    }
}
