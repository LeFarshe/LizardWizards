package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.core.Vector2;

public interface IEnemyFactory {
    IEnemy createEnemy(Vector2 position, double speed);
}

