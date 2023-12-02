package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;

public class DefaultEnemyFactory implements IEnemyFactory {

    public Enemy createEnemy(Vector2 position) {
        return new StandardEnemy(position);
    }
}
