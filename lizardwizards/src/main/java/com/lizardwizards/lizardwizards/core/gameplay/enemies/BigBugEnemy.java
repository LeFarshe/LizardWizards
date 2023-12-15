package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.MoveTowardsState;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.RandomWanderState;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.TimedStateChanger;

import java.util.Arrays;

public class BigBugEnemy extends BossEnemy {
    public BigBugEnemy(Vector2 position) {
        super(100, 300, position);
        stateChanger = new TimedStateChanger(5, Arrays.asList(
                new MoveTowardsState(this, position),
                new RandomWanderState(this)
        ));
    }

    @Override
    public EntitySprite getSprite() {
        return new ImageSprite("images/enemies/BigBug.png");
    }
}
