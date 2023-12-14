package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import java.io.Serializable;

public interface IStateChanger extends Serializable {
    public EnemyStrategyState processDelta(double timeDelta);

    public boolean shouldSwitch();

    public EnemyStrategyState getState();

    public EnemyStrategyState switchState();
}
