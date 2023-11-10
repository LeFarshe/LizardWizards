package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.server.Scoreboard;

import java.util.Dictionary;
import java.util.Random;

public class EnemyEntity extends Entity {
    Vector2 moveDirection = new Vector2(0,0);
    double health = 3;
    double speed;
    double directionDelay = 1;
    double directionTimer = directionDelay;
    boolean isDestroyed = false;
    private final Random rand = new Random();
    @Override
    public void MoveByDelta(double delta) {
        directionTimer -= delta;
        if (directionTimer <= 0){
            setRandomDirection();
            directionTimer = directionDelay;
        }
        Move(moveDirection.Copy().Multiply(speed * delta));
    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
        final CollisionLayer PLAYER_PROJECTILE_LAYER = CollisionLayer.PlayerProjectile;

        if(layer == PLAYER_PROJECTILE_LAYER) {

            health -= ((IProjectile)collider).getDamage();
            if (health <= 0 && !isDestroyed) {
                HandleDeath();
            }
        }
    }


    public void setRandomDirection() {
        double randX = rand.nextDouble() * 2 - 1;
        double randY = rand.nextDouble() * 2 - 1;
        moveDirection = new Vector2(randX, randY).Normalize();
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
        return isDestroyed;
    }
}
