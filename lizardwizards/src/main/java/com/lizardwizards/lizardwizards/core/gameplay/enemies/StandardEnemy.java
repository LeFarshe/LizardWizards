package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.server.Scoreboard;

public class StandardEnemy extends Enemy {

    public StandardEnemy(IEnemyImplementor implementor, double health, Vector2 position) {
        super(implementor, health, position);
        this.position = position;
    }


    @Override
    public void Collide(Entity collidingEntity, CollisionLayer layer) {
        implementor.onCollision(collidingEntity, layer);
        if (layer == CollisionLayer.PlayerProjectile) {
            health -= ((IProjectile)collidingEntity).getDamage();
            if (health <= 0 && !isDestroyed) {
                // isDestroyed = implementor.isDestroyed(); // This could also call a method like `handleDestruction()`
                HandleDeath();
            }
        }
    }

    public void HandleDeath() {
        isDestroyed = true;
        System.out.println("Standard Enemy has died!");
        Scoreboard.getInstance().addScore(5);
    }

    @Override
    public Vector2 GetPosition(){
            return this.implementor.getPosition().Copy();
    }

    @Override
    public boolean IsDestroyed() {
        return isDestroyed;
    }

}