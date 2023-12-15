package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.DefaultStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.HealthStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.TimedStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.*;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.ViolentWand;

public class CicadaWizardEnemy extends BossEnemy {
    final double maxHealth;
    final double maxSpeed;
    public CicadaWizardEnemy(Vector2 position) {
        super(200, 200, position);
        maxHealth = health;
        maxSpeed = speed;
        speed *= 0.5;

        var shootState = new ShootRandomPlayerState(this, new ViolentWand(), 1);
        var chaseState = new ChaseStrategyState(this, 0.007, 1.5);

        stateChanger = new HealthStateChanger(this, 180,
                new KeepDistanceStrategyState(this, 400),
                new CompoundStateStrategy(this, new HealthStateChanger( this, 150,
                    shootState,
            new CompoundStateStrategy(this, new TimedStateChanger(0.5,
                    shootState,
                    chaseState,
                    new RandomWanderState(this)
        ).extraClause(new HealthStateChanger(this, 50, null, chaseState))))));
    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
        var ratio = (1 - health / maxHealth);
        speed = maxSpeed * ( ratio * ratio * 0.5 + 0.5);
        super.Collide(collider, layer);
    }

    @Override
    public EntitySprite getSprite() {
        return new ImageSprite("images/enemies/BigBug.png");
    }
}
