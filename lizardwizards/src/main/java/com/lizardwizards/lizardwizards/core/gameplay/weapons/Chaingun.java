package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.BoltEnergizerVisitor;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;

import java.util.ArrayList;
import java.util.List;

public class Chaingun extends Weapon{
    int projectiles = 10;
    double spread = 0.5;
    int projectilesShot  = 0;
    public Chaingun() {
        super(1,300, 2, 10, new Vector2(4,4),
        new ImageSprite("images/weapons/Chaingun.png"));
    }

    @Override
    public List<IProjectile> Shoot(Vector2 direction, Vector2 position) {
        List<IProjectile> projectileList = new ArrayList<>();

        double startSpread = spread / 2;
        double spreadPerIteration = spread / (projectiles - 1);
        direction.Rotate(-startSpread);

        if (projectilesShot / projectiles == 0){
            direction.Rotate(spreadPerIteration * (projectilesShot % projectiles));
        }
        else {
            direction.Rotate(spread);
            direction.Rotate(-spreadPerIteration * (projectilesShot % projectiles));
        }
        projectileList.add(new Projectile(damage, shotSpeed, shotDuration, position, direction, projectileSize));

        projectilesShot = (projectilesShot + 1) % (projectiles * 2);
        return projectileList;
    }

    @Override
    public Chaingun clone(){
        Chaingun clone = (Chaingun)super.clone();
        clone.projectiles = projectiles;
        clone.spread = spread;
        clone.projectilesShot = projectilesShot;
        return clone;
    }

    @Override
    public Weapon accept(BoltEnergizerVisitor visitor){
        return visitor.visit(this);
    }
}
