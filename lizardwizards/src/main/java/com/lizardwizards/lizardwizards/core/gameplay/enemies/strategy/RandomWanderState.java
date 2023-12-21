package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;

import java.util.Random;

public class RandomWanderState extends EnemyStrategyState {
    double directionDelay = 1;
    double directionTimer = directionDelay;
    private Vector2 moveDirection = new Vector2(0, 0);
    public RandomWanderState(Enemy enemy) {
        super(enemy);
    }

    @Override
    public Vector2 getMovementDirection(double delta) {
        directionTimer -= delta;
        if (directionTimer <= 0){

            Random random = new Random();
            moveDirection = new Vector2(2*(random.nextDouble()-0.5), random.nextDouble()-0.5);

            directionTimer = directionDelay;
        }
        return moveDirection.Copy();
    }
}
