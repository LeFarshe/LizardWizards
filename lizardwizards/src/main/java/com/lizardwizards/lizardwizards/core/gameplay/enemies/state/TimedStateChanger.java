package com.lizardwizards.lizardwizards.core.gameplay.enemies.state;

import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState;

import java.util.Arrays;
import java.util.List;

public class TimedStateChanger extends IStateChanger {
    double switchDelay;
    double switchTimer = switchDelay;
    int currentState = 0;
    List<EnemyStrategyState> enemyStates;

    public TimedStateChanger(double switchDelay, EnemyStrategyState... strategyStates) {
        this.switchDelay = switchDelay;
        enemyStates = Arrays.stream(strategyStates).toList();
    }

    @Override
    public EnemyStrategyState processDelta(double timeDelta) {
        switchTimer -= timeDelta;
        return super.processDelta(timeDelta);
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
