package com.lizardwizards.lizardwizards.core.gameplay.projectiles;

import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public class ItmSpectral extends ProjectileDecorator {
    public ItmSpectral(Projectile projectile) {
        super(projectile);
    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
    }

}
