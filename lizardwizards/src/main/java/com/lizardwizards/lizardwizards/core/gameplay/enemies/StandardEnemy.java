package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.server.Scoreboard;

public class StandardEnemy extends Enemy {

    public StandardEnemy(IEnemyImplementor implementor, int health) {
        super(implementor, health);
    }

    @Override
    public void setRandomDirection() {
        implementor.setRandomDirection();
    }

    @Override
    public void Collide(CollisionLayer layer) {
        implementor.onCollision(layer);
        if (layer == CollisionLayer.PlayerProjectile) {
            health -= 1;
            if (health <= 0 && !isDestroyed) {
                isDestroyed = implementor.isDestroyed(); // This could also call a method like `handleDestruction()`
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
    public boolean IsDestroyed() {
        return isDestroyed;
    }

}