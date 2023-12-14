package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

public class DefaultStateChanger implements IStateChanger {
    EnemyStrategyState state;

    public DefaultStateChanger(EnemyStrategyState enemyStrategyState) {
        state = enemyStrategyState;
    }

    @Override
    public EnemyStrategyState processDelta(double timeDelta) {
        return state;
    }

    @Override
    public boolean shouldSwitch() {
        return false;
    }

    @Override
    public EnemyStrategyState getState() {
        return state;
    }

    @Override
    public EnemyStrategyState switchState() {
        return state;
    }
}
