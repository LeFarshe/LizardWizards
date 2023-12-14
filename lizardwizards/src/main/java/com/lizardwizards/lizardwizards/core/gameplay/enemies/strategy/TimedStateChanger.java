package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import java.util.List;

public class TimedStateChanger implements IStateChanger {
    double switchDelay;
    double switchTimer = switchDelay;
    int currentState = 0;
    List<EnemyStrategyState> enemyStates;

    public TimedStateChanger(double switchDelay, List<EnemyStrategyState> strategyStates) {
        this.switchDelay = switchDelay;
        enemyStates = strategyStates;
    }

    @Override
    public EnemyStrategyState processDelta(double timeDelta) {
        switchTimer -= timeDelta;
        if (shouldSwitch()) {
            return switchState();
        }
        return getState();
    }

    @Override
    public boolean shouldSwitch() {
        return switchTimer <= 0;
    }

    @Override
    public EnemyStrategyState getState() {
        return enemyStates.get(currentState);
    }

    @Override
    public EnemyStrategyState switchState() {
        switchTimer = switchDelay;
        currentState = (currentState+1) % enemyStates.size();
        return enemyStates.get(currentState);
    }
}
