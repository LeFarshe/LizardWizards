package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.DefaultStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.ChaseStrategyState;

public class CicadaWizardEnemy extends BossEnemy {
    public CicadaWizardEnemy(Vector2 position) {
        super(200, 250, position);
        stateChanger = new DefaultStateChanger(new ChaseStrategyState(this, 0.01, 1.5));
    }

    @Override
    public EntitySprite getSprite() {
        return new ImageSprite("images/enemies/BigBug.png");
    }
}
