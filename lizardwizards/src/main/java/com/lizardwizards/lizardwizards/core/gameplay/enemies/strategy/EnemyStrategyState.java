package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class EnemyStrategyState implements Serializable {
    Enemy parent;
    public List<EnemyStrategyState> nextState;

    public EnemyStrategyState(Enemy enemy) {
        nextState = new ArrayList<>();
        parent = enemy;
    }

    public EnemyStrategyState nextState(){
        return nextState(0);
    }

    public EnemyStrategyState nextState(int state) {
        if (nextState.isEmpty()) {
            return this;
        }
        return nextState.get(state);
    }

    public Vector2 getMovementDirection(double delta) {
        return new Vector2(0, 0);
    }
}