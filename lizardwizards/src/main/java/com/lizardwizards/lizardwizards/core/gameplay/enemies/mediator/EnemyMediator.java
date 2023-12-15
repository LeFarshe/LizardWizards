package com.lizardwizards.lizardwizards.core.gameplay.enemies.mediator;

import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;

import java.io.Serializable;

public class EnemyMediator implements GameplayMediator, Serializable {
    @Override
    public void handleCollision(Enemy enemy, Entity collider, CollisionLayer layer) {
        final CollisionLayer PLAYER_PROJECTILE_LAYER = CollisionLayer.PlayerProjectile;
        if(layer == PLAYER_PROJECTILE_LAYER) {
            boolean isDead = enemy.takeDamage(((IProjectile)collider).getDamage());
            if (isDead && !enemy.isDestroyed) {
                enemy.HandleDeath();
            }
        }
    }



    @Override
    public void updateEnemyState(Enemy enemy) {
        enemy.nextState();
    }


}