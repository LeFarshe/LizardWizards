package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public class BossEnemyFactory implements IEnemyFactory {
    @Override
    public EntityWrapper createEnemy(Vector2 position) {
        Enemy enemy = new BigBugEnemy(position);
        EntitySprite sprite = enemy.getSprite();
        var w = sprite.getWidth();
        var h = sprite.getHeight();
        Collider collider = Collider.NewRectangle(position, w, h, CollisionLayer.Enemy);
        return new EntityWrapper(enemy, sprite, collider);
    }
}
