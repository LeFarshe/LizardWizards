package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;

public class MoveTowardsState extends EnemyStrategyState {
    double returnDelay = 5;
    double returnTimer = returnDelay;
    Vector2 target;

    public MoveTowardsState(Enemy enemy, Vector2 position) {
        super(enemy);
        target = position.Copy();
    }

    @Override
    public Vector2 getMovementDirection(double delta) {
        returnTimer -= delta;
        if (returnTimer <= 0 || parent.GetPosition().DistanceTo(target) < 0.5) {
            parent.nextState();
            returnTimer = returnDelay;
        }
        return parent.GetPosition().Multiply(-1).AddVector(target).Normalize();
    }
}
