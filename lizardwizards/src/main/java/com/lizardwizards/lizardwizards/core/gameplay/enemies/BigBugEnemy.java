package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.MoveTowardsState;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.TimedRandomWanderState;

public class BigBugEnemy extends Enemy {
    public BigBugEnemy(Vector2 position) {
        super(50, 200, position);
        var returnState = new MoveTowardsState(this, position);
        var wanderState = new TimedRandomWanderState(this);
        wanderState.nextState.add(returnState);
        returnState.nextState.add(wanderState);
        setState(wanderState);
    }

    @Override
    public EntitySprite getSprite() {
        return new ImageSprite("images/enemies/BigBug.png");
    }
}
