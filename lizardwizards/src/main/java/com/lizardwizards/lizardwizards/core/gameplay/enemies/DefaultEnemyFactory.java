package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;

public class DefaultEnemyFactory implements IEnemyFactory {
    @Override
    public IEnemy createEnemy(IEnemyImplementor implementor, int health) {
        return new StandardEnemy(implementor, health, null);
    }

    public IEnemy createEnemy(Vector2 position, int health) {
        EnemyEntity enemyEntity = new EnemyEntity();
        enemyEntity.SetPosition(position);
        IEnemyImplementor implementor = new StandardEnemyImplementor(enemyEntity, position, 100, health);
        return new StandardEnemy(implementor, health, position);
    }
}
