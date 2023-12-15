package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.IStateChanger;

public class CompoundStateStrategy extends EnemyStrategyState {
    IStateChanger stateChanger;
    public CompoundStateStrategy(Enemy enemy, IStateChanger stateChanger) {
        super(enemy);
        this.stateChanger = stateChanger;
    }

    @Override
    public Vector2 getMovementDirection(double delta) {
        parent.switchStateSwitcher(stateChanger);
        return super.getMovementDirection(delta);
    }
}
