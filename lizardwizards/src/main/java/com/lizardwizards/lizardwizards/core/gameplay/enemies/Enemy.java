package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.DefaultEnemyState;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.server.Scoreboard;

public abstract class Enemy extends Entity {
    protected double health;
    public final double speed;
    protected boolean isDestroyed;

    protected Vector2 position;
    int scoreReward = 5;

    EnemyStrategyState state;
    public Enemy(double health, double speed, Vector2 position) {
        this.SetPosition(position);
        this.health = health;
        this.speed = speed;
        this.position = position;
        isDestroyed = false;
        state = new DefaultEnemyState(this);
    }

    abstract public EntitySprite getSprite();

    @Override
    public void MoveByDelta(double delta) {
        Move(state.getMovementDirection(delta));
    }

    public void nextState() {
        state = state.nextState();
    }

    protected void setState(EnemyStrategyState state) {
        this.state = state;
    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
        final CollisionLayer PLAYER_PROJECTILE_LAYER = CollisionLayer.PlayerProjectile;
        if(layer == PLAYER_PROJECTILE_LAYER) {
            boolean isDead = takeDamage(((IProjectile)collider).getDamage());
            if (isDead && !isDestroyed) {
                HandleDeath();
            }
        }
    }

    protected boolean takeDamage(double damage) {
        health -= damage;
        return health <= 0;
    }

    protected void HandleDeath() {
        isDestroyed = true;
        Scoreboard.getInstance().addScore(scoreReward);
    }

    @Override
    public boolean IsDestroyed() {
        return isDestroyed;
    }
}