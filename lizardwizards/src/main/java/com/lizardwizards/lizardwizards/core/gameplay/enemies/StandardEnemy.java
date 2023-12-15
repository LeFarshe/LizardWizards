package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.DefaultStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.RandomWanderState;

public class StandardEnemy extends Enemy {

    public StandardEnemy(Vector2 position) {
        super(5, 100, position);
        this.position = position;
        SetPosition(position);
         stateChanger = new DefaultStateChanger(new RandomWanderState(this));
    }

    @Override
    public EntitySprite getSprite() {
        return new ImageSprite("images/enemies/Fly.png");
    }
}