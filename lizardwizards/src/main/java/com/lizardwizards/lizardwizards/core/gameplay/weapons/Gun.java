package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import java.util.ArrayList;
import java.util.List;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.BoltEnergizerVisitor;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;

public class Gun extends Weapon{


    public Gun()
    {
        super(2, 300, 2, 4, new Vector2(6,6),
        new ImageSprite("images/weapons/Gun.png"));
    }

    @Override
    public List<IProjectile> Shoot(Vector2 direction, Vector2 position) {
        IProjectile projectile = new Projectile(damage, shotSpeed, shotDuration, position, direction, projectileSize);
        List<IProjectile> projectiles = new ArrayList<>();
        projectiles.add(projectile);
        return projectiles;
    }

    @Override
    public Gun clone(){
        return (Gun)super.clone();
    }

    @Override
    public Weapon accept(BoltEnergizerVisitor visitor){
        return visitor.visit(this);
    }
}
