package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.client.sprites.SpriteSheet;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.Utils;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.HealthStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.TimedStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.*;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.ViolentWand;

import java.io.Serializable;
import java.util.function.Supplier;

public class CicadaWizardEnemy extends BossEnemy {
    final double maxHealth;
    final double maxSpeed;
    EntitySprite stage1Sprite;
    EntitySprite stage2Sprite;
    EntitySprite stage3Sprite;
    EntitySprite stage4Sprite;
    EntitySprite sprite;
    public CicadaWizardEnemy(Vector2 position) {
        super(200, 200, position);
        stage1Sprite = new ImageSprite("images/enemies/Cicada1.png");
        stage1Sprite.scale(2);
        stage2Sprite = new ImageSprite("images/enemies/Cicada2.png");
        stage2Sprite.scale(2);
        stage3Sprite = new ImageSprite("images/enemies/Cicada3.png");
        stage3Sprite.scale(2);
        stage4Sprite = new ImageSprite("images/enemies/Cicada4.png");
        stage4Sprite.scale(2);
        sprite = new SpriteSheet(()-> stage1Sprite);
        ((SpriteSheet)sprite).updateSupplier((Supplier<EntitySprite> & Serializable)() -> {
            var hp = ((Enemy)Utils.getEntityList().get(uuid).entity).getHealth();
            if (hp < 50) {
                return stage4Sprite;
            }
            if (hp < 150) {
                return stage3Sprite;
            }
            if (hp < 180) {
                return stage2Sprite;
            }
            return stage1Sprite;
        });


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
        return sprite;
    }
}
