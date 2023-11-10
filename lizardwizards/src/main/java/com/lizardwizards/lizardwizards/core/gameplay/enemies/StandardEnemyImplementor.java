package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.server.Scoreboard;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.Random;

public class StandardEnemyImplementor implements IEnemyImplementor, Serializable {
    private static final long serialVersionUID = 1L;
    private final Entity enemyEntity;
    int health = 3;
    double speed;
    double directionDelay = 1;
    double directionTimer = directionDelay;
    boolean isDestroyed = false;

    private final Random rand = new Random();

    private Vector2 moveDirection;

    public StandardEnemyImplementor(Entity enemyEntity, Vector2 initialPosition, double speed, int initialHealth) {
        this.enemyEntity = enemyEntity;
        this.speed = speed;
        this.health = initialHealth;
        setRandomDirection();
    }

    @Override
    public void move(double delta) {
        directionTimer -= delta;
        if (directionTimer <= 0){
            setRandomDirection();
            directionTimer = directionDelay;
        }
        enemyEntity.Move(moveDirection.Copy().Multiply(speed * delta));
    }

    @Override
    public void onCollision(CollisionLayer layer) {
        if (layer == CollisionLayer.PlayerProjectile) {
            health -= 1;
            if (health <= 0) {
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

    public Dictionary<String, Integer> GetSpriteSettings(){
        return null;
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }
}