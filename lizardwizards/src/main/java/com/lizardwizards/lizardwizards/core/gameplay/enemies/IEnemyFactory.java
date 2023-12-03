package com.lizardwizards.lizardwizards.core.gameplay.enemies;


import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;

public interface IEnemyFactory {
    EntityWrapper createEnemy(Vector2 position);
}

