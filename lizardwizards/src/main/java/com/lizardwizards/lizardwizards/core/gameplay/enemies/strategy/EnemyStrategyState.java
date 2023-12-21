package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;

import java.io.Serializable;

public abstract class EnemyStrategyState implements Serializable {
    Enemy parent;

    public EnemyStrategyState(Enemy enemy) {
        parent = enemy;
    }

    public Vector2 getMovementDirection(double delta) {
        return new Vector2(0, 0);
    }
}