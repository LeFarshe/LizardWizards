package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.TurretProjectile;
import com.lizardwizards.lizardwizards.server.ServerTimer;

import java.util.ArrayList;
import java.util.List;

public class TurretWand extends TurretWeapon{
    int projectiles = 4;
    double spread = Math.PI;

    TurretWand() {
        super(0, 500, 10, 0.5, new Vector2(16,16)
                , new ImageSprite("images/weapons/Gun.png"), new TurretWandGun());
    }

    @Override
    public List<IProjectile> Shoot(Vector2 direction, Vector2 position) {
        List<IProjectile> projectileList = new ArrayList<>();
        double startSpread = spread / 2;
        double spreadPerIteration = spread / (projectiles - 1);
        direction.Rotate(-startSpread);
        TurretProjectile current = null;
        IWeapon chainGun = turretWeapon.clone();
        for (int i = 0; i < projectiles; i++){
            TurretProjectile newProjectile = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, chainGun);
            projectileList.add(newProjectile);
            direction.Rotate(spreadPerIteration);
            newProjectile.setNext(current);
            current = newProjectile;
        }
        if (current != null){
            current.setFirst();
        }
        ServerTimer.addChain(current);
        return projectileList;
    }

}
