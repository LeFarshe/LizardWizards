package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import java.io.Serializable;


public class StandardEnemyImplementor implements IEnemyImplementor, Serializable {
    private final Entity enemyEntity;
    EnemyMovementStrategy strategy;
    double health;
    double speed;
    double directionDelay = 1;
    double directionTimer = directionDelay;
    boolean isDestroyed = false;
    private Vector2 moveDirection;

    public StandardEnemyImplementor(Entity enemyEntity, EnemyMovementStrategy strategy, double speed, double initialHealth) {
        this.enemyEntity = enemyEntity;
        this.speed = speed;
        this.health = initialHealth;
        this.strategy = strategy;
        setDirection();
    }

    @Override
    public void move(double delta) {
        directionTimer -= delta;
        if (directionTimer <= 0){
            setDirection();
            directionTimer = directionDelay;
        }
        enemyEntity.Move(moveDirection.Copy().Multiply(speed * delta));
    }


    public void setDirection() {
        moveDirection = strategy.getDirection();
    }

    @Override
    public Vector2 getPosition() {
        return enemyEntity.GetPosition();
    }



    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }
}