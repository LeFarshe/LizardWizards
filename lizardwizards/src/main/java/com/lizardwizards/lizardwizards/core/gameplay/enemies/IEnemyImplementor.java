package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public interface IEnemyImplementor {
    void move(double delta);

    void onCollision(CollisionLayer layer);
    boolean isDestroyed();

    void setRandomDirection();

    Vector2 getPosition();
}