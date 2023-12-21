package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.BoltEnergizerVisitor;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;

import java.util.ArrayList;
import java.util.List;

public class TestWeapon extends Weapon{
    public TestWeapon(double shootDelay,double firerate)
    {
        super(2, 300, 2, firerate, new Vector2(6,6),
                null);
        this.fireTimer = shootDelay;
    }

    @Override
    public List<IProjectile> Shoot(Vector2 direction, Vector2 position) {
        IProjectile projectile = new Projectile(damage, shotSpeed, shotDuration, position, direction, projectileSize);
        List<IProjectile> projectiles = new ArrayList<>();
        projectiles.add(projectile);
        return projectiles;
    }

    @Override
    public TestWeapon clone(){
        return (TestWeapon) super.clone();
    }

    @Override
    public Weapon accept(BoltEnergizerVisitor visitor) {
        return visitor.visit(this);
    }
}
