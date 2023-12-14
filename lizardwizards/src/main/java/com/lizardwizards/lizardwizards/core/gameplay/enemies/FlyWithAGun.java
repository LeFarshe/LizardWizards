package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.DefaultStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.ShootRandomPlayerState;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.Shotgun;

import java.util.Random;

public class FlyWithAGun extends Enemy {

    public FlyWithAGun(Vector2 position) {
        super(5, 50, position);
        this.position = position;
        SetPosition(position);
        stateChanger = new DefaultStateChanger(new ShootRandomPlayerState(this, new Shotgun(), 2));
    }

    @Override
    public EntitySprite getSprite() {
        return new ImageSprite("images/enemies/Fly.png");
    }
}
