package com.lizardwizards.lizardwizards.core.gameplay.enemies;


import com.lizardwizards.lizardwizards.core.Vector2;

public interface IEnemyFactory {
    Enemy createEnemy(Vector2 position);
}

