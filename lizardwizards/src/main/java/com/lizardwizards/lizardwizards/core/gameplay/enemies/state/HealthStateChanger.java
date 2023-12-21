package com.lizardwizards.lizardwizards.core.gameplay.enemies.state;

import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState;

public class HealthStateChanger extends IStateChanger {
    final double health;
    final Enemy parent;
    EnemyStrategyState currentState;
    EnemyStrategyState endState;

    public HealthStateChanger(Enemy parent, double health, EnemyStrategyState initialState, EnemyStrategyState endState) {
        this.health = health;
        this.parent = parent;
        this.currentState = initialState;
        this.endState = endState;
    }

    @Override
    public boolean shouldSwitch() {
        return parent.getHealth() < health;
    }

    @Override
    public EnemyStrategyState getState() {
        return currentState;
    }

    @Override
    public EnemyStrategyState switchState() {
        return currentState = endState;
    }
}
