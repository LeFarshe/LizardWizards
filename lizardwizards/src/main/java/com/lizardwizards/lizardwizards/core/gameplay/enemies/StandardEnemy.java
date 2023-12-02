package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.server.Scoreboard;

import java.util.Random;

public class StandardEnemy extends Enemy {
    double directionDelay = 1;
    double directionTimer = directionDelay;
    private Vector2 moveDirection = new Vector2(0, 0);

    public StandardEnemy(Vector2 position) {
        super(5, 100, position);
        this.position = position;
        SetPosition(position);
    }

    @Override
    public EntitySprite getSprite() {
        var image =new ImageSprite("images/enemies/Fly.png");
        return image;
    }

    @Override
    public void MoveByDelta(double delta) {
        directionTimer -= delta;
        if (directionTimer <= 0){

            Random random = new Random();
            moveDirection = new Vector2(random.nextDouble()-0.5, random.nextDouble()-0.5);

            directionTimer = directionDelay;
        }
        Move(moveDirection.Copy().Multiply(speed * delta));
    }
}