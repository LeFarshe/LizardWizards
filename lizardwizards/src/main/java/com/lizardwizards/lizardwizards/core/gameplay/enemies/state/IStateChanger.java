package com.lizardwizards.lizardwizards.core.gameplay.enemies.state;

import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState;

import java.io.Serializable;

public abstract class IStateChanger implements Serializable {
    IStateChanger extraChanger;

    public EnemyStrategyState processDelta(double timeDelta){
        if (extraChanger != null) {
            extraChanger.processDelta(timeDelta);
            if (extraChanger.shouldSwitch()){
                return extraChanger.switchState();
            }
        }
        if (shouldSwitch()) {
            return switchState();
        }
        return getState();
    }

    public IStateChanger extraClause(IStateChanger extraChanger) {
        this.extraChanger = extraChanger;
        return this;
    }

    public abstract boolean shouldSwitch();

    public abstract EnemyStrategyState getState();

    public abstract EnemyStrategyState switchState();
}
