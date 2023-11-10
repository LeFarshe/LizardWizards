package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import java.util.Dictionary;
import java.util.Random;
import java.util.UUID;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.server.Scoreboard;
public class Enemy extends Entity implements IEnemy {
    Vector2 moveDirection = new Vector2(0,0);
    int health = 3;
    double speed;
    double directionDelay = 1;
    double directionTimer = directionDelay;
    boolean isDestroyed = false;

    private Random rand = new Random();

    public Enemy(Vector2 position, double speed)
    {
        this.position = position;
        this.speed = speed;
        setRandomDirection();
    }

    public void setRandomDirection() {
        double randX = rand.nextDouble() * 2 - 1;
        double randY = rand.nextDouble() * 2 - 1;
        moveDirection = new Vector2(randX, randY).Normalize();
    }

    @Override
    public void MoveByDelta(double delta){
        directionTimer -= delta;
        if (directionTimer <= 0){
            setRandomDirection();
            directionTimer = directionDelay;
        }
        Move(moveDirection.Copy().Multiply(speed * delta));
    }

    @Override
    public void Collide(CollisionLayer layer){

        final CollisionLayer PLAYER_PROJECTILE_LAYER = CollisionLayer.PlayerProjectile;

        if(layer == PLAYER_PROJECTILE_LAYER) {

            health -= 1;
            if (health <= 0 && !isDestroyed) {
                HandleDeath();
            }
        }

    }

    public void HandleDeath() {
        isDestroyed = true;
        System.out.println("Enemy has died!");
        Scoreboard.getInstance().addScore(5);
    }

    @Override
    public boolean IsDestroyed() {
        return isDestroyed;
    }

    @Override
    public Enemy clone() {
        Enemy clone = (Enemy) super.clone();

        if (moveDirection != null) { clone.moveDirection = moveDirection.Copy(); }
        clone.health = health;
        clone.speed = speed;
        clone.directionDelay = directionDelay;
        clone.directionTimer = directionTimer;
        clone.isDestroyed = isDestroyed;
        clone.rand = new Random();

        return clone;
    }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings(){
        return null;
    }
}