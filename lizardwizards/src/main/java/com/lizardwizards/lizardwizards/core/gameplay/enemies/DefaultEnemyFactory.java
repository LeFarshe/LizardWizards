package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
public class DefaultEnemyFactory implements IEnemyFactory {

    @Override
    public EntityWrapper createEnemy(Vector2 position) {
        return Enemies.Fly.getEntityWrapper(position);
    }
}
