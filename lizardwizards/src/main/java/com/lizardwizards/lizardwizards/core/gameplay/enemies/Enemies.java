package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public enum Enemies {
    // Normal enemies
    Fly {
        @Override
        public Enemy spawn(Vector2 position) {
            return new StandardEnemy(position);
        }
    },
    FlyWithGun {
        @Override
        public Enemy spawn(Vector2 position) {
            return new FlyWithAGun(position);
        }
    },

    // Bosses
    BigBug {
        @Override
        public Enemy spawn(Vector2 position) {
            return new BigBugEnemy(position);
        }
    };

    public Enemy spawn(Vector2 position) {
        return null;
    }

    public EntityWrapper getEntityWrapper(Vector2 position) {
        Enemy enemy = spawn(position);
        if (enemy == null) {
            return null;
        }
        EntitySprite sprite = enemy.getSprite();
        var w = sprite.getWidth();
        var h = sprite.getHeight();
        Collider collider = Collider.NewRectangle(position, w, h, CollisionLayer.Enemy);
        return new EntityWrapper(enemy, sprite, collider);
    }
}
