package com.lizardwizards.lizardwizards.core.gameplay.enemies.state;

import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState;

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
