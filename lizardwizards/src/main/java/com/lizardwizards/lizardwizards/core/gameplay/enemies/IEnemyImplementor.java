package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;


public interface IEnemyImplementor {
    void move(double delta);

    boolean isDestroyed();

    Vector2 getPosition();
}