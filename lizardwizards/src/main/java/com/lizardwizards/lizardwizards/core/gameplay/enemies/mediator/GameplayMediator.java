package com.lizardwizards.lizardwizards.core.gameplay.enemies.mediator;

import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;

public interface GameplayMediator {
    void handleCollision(Enemy enemy, Entity collider, CollisionLayer layer);
    void updateEnemyState(Enemy enemy);
}