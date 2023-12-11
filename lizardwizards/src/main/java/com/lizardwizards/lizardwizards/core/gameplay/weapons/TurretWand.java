package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;

import java.util.ArrayList;
import java.util.List;

public class TurretWand extends TurretWeapon{
    int projectiles = 4;
    double spread = 0.5;

    TurretWand() {
        super(1, 50, 5, 0.5, new Vector2(16,16)
                , new ImageSprite("images/weapons/Gun.png"), new Gun());
    }

    @Override
    public List<IProjectile> Shoot(Vector2 direction, Vector2 position) {
        List<IProjectile> projectileList = new ArrayList<>();
        double startSpread = spread / 2;
        double spreadPerIteration = spread / (projectiles - 1);
        direction.Rotate(-startSpread);
        for (int i = 0; i < projectiles; i++){
            projectileList.add(new Projectile(damage, shotSpeed, shotDuration, position, direction, projectileSize));
            direction.Rotate(spreadPerIteration);
        }
        return projectileList;
    }
}
