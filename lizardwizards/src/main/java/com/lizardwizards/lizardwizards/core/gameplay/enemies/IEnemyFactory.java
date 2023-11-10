package com.lizardwizards.lizardwizards.core.gameplay.enemies;


import com.lizardwizards.lizardwizards.core.Vector2;

public interface IEnemyFactory {
    IEnemy createEnemy(IEnemyImplementor implementor, int health);
    IEnemy createEnemy(Vector2 position, int health);
}

