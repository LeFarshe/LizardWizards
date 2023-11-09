package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.IEnemy;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.IEnemyFactory;

public class DefaultEnemyFactory implements IEnemyFactory {
    @Override
    public IEnemy createEnemy(Vector2 position, double speed) {
        return new Enemy(position, speed);
    }
}
