package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.*;

import java.util.ArrayList;
import java.util.List;

public class Shotgun extends Weapon{
    int projectiles = 8;
    double spread = 0.5;
    public Shotgun() {
        super(1, 500,0.5, 1.5, new Vector2(3,3),
                new ImageSprite(ClientUtils.loadResource("images/weapons/Shotgun.png")));
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

    @Override
    public Shotgun clone(){
        Shotgun clone = (Shotgun)super.clone();
        clone.projectiles = projectiles;
        clone.spread = spread;
        return clone;
    }
}
