package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.core.Vector2;

public class DefaultEnemyFactory implements IEnemyFactory {
    @Override
    public IEnemy createEnemy(Vector2 position, double speed) {
        return new Enemy(position, speed);
    }
}
