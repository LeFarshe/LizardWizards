package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.BoltEnergizerVisitor;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ViolentWand extends Weapon{
    double spread = 1.5;
    Random random = new Random();
    public ViolentWand() {
        super(1, 500,0.5, 10, new Vector2(5,5),
                new ImageSprite("images/weapons/ViolentWand.png"));
    }

    @Override
    public List<IProjectile> Shoot(Vector2 direction, Vector2 position) {
        List<IProjectile> projectileList = new ArrayList<>();
        var rotation = spread*random.nextDouble() - spread / 2.0;
        var dir = direction.Copy().Rotate(rotation);
        var otherDirection = dir.Copy().Multiply(-200);
        var pos = position.Copy().AddVector(otherDirection).AddVector(direction.Multiply(200));
        projectileList.add(new Projectile(damage, shotSpeed, shotDuration, pos, dir, projectileSize));
        return projectileList;
    }

    @Override
    public ViolentWand clone(){
        ViolentWand clone = (ViolentWand)super.clone();
        clone.spread = spread;
        return clone;
    }

    @Override
    public Weapon accept(BoltEnergizerVisitor visitor){
        return visitor.visit(this);
    }
}
