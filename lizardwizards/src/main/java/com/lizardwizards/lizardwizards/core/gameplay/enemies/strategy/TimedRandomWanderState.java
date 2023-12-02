package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;

import java.util.Random;

public class TimedRandomWanderState extends EnemyStrategyState {
    double switchDelay = 5;
    double switchTimer = switchDelay;
    double directionDelay = 1;
    double directionTimer = directionDelay;
    private Vector2 moveDirection = new Vector2(0, 0);
    public TimedRandomWanderState(Enemy enemy) {
        super(enemy);
    }

    @Override
    public Vector2 getMovementDirection(double delta) {
        directionTimer -= delta;
        switchTimer -= delta;
        if (directionTimer <= 0){

            Random random = new Random();
            moveDirection = new Vector2(random.nextDouble()-0.5, random.nextDouble()-0.5);

            directionTimer = directionDelay;
        }

        if (switchTimer <= 0) {
            switchTimer = switchDelay;
            parent.nextState();
        }
        return moveDirection.Copy().Multiply(parent.speed * delta);
    }
}
