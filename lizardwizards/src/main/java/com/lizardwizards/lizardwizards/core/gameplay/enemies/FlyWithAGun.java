package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.mediator.EnemyMediator;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.DefaultStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.ShootRandomPlayerState;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.Shotgun;

public class FlyWithAGun extends Enemy {

    public FlyWithAGun(Vector2 position) {
        super(5, 50, position, new EnemyMediator());
        this.position = position;
        scoreReward = 15;
        SetPosition(position);
        stateChanger = new DefaultStateChanger(new ShootRandomPlayerState(this, new Shotgun(), 2));
    }

    @Override
    public EntitySprite getSprite() {
        return new ImageSprite("images/enemies/FlyWithGun.png");
    }
}
