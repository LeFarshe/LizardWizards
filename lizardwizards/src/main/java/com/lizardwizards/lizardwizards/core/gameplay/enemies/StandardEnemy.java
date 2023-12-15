package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.client.sprites.Sheet;
import com.lizardwizards.lizardwizards.client.sprites.SpriteSheet;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.DefaultStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.RandomWanderState;

import java.util.ArrayList;
import java.util.List;

public class StandardEnemy extends Enemy {

    public StandardEnemy(Vector2 position) {
        super(5, 100, position);
        this.position = position;
        SetPosition(position);
         stateChanger = new DefaultStateChanger(new RandomWanderState(this));
    }

    @Override
    public EntitySprite getSprite() {
        Sheet sprites = new Sheet();
        sprites.add(new ImageSprite("images/enemies/fly/Fly.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly_2.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly_3.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly_4.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly_5.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly_6.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly_6.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly_5.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly_4.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly_3.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly_2.png"));
        sprites.add(new ImageSprite("images/enemies/fly/Fly.png"));
        return new SpriteSheet(sprites);
    }
}