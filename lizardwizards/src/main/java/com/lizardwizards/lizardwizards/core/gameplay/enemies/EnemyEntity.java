package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.server.Scoreboard;

import java.util.Dictionary;
import java.util.Random;

public class EnemyEntity extends Entity {

    EnemyMovementStrategy strategy;
    int health = 3;
    double speed;
    double directionDelay = 1;
    double directionTimer = directionDelay;
    boolean isDestroyed = false;
    @Override
    public void MoveByDelta(double delta) {
        directionTimer -= delta;
        if (directionTimer <= 0){
            directionTimer = directionDelay;
        }
        Move(strategy.getDirection().Copy().Multiply(speed * delta));
    }
    void setMovementStrategy(EnemyMovementStrategy strategy) {
        this.strategy = strategy;
    }
    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
        final CollisionLayer PLAYER_PROJECTILE_LAYER = CollisionLayer.PlayerProjectile;

        if(layer == PLAYER_PROJECTILE_LAYER) {

            health -= 1;
            if (health <= 0 && !isDestroyed) {
                HandleDeath();
            }
        }
    }




    public void HandleDeath() {
        isDestroyed = true;
        System.out.println("Enemy has died!");
        Scoreboard.getInstance().addScore(5);
    }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings() {
        return null;
    }

    @Override
    public boolean IsDestroyed() {
        // Logic to determine if this enemy is destroyed
        return false;
    }
}
