package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.mediator.GameplayMediator;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.DefaultEnemyState;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.DefaultStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.IStateChanger;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.server.Scoreboard;

public abstract class Enemy extends Entity {
    protected double health;
    public final double speed;
    public boolean isDestroyed;

    protected Vector2 position;
    int scoreReward = 5;
    IStateChanger stateChanger;
    protected GameplayMediator mediator;
    public Enemy(double health, double speed, Vector2 position, GameplayMediator mediator) {
        this.SetPosition(position);
        this.health = health;
        this.speed = speed;
        this.position = position;
        this.mediator = mediator;
        isDestroyed = false;
        stateChanger = new DefaultStateChanger(new DefaultEnemyState(this));
    }

    abstract public EntitySprite getSprite();

    @Override
    public void MoveByDelta(double delta) {
        Move(stateChanger.processDelta(delta).getMovementDirection(delta));
    }

    public void nextState() {
        stateChanger.switchState();
    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
        mediator.handleCollision(this, collider, layer);
    }

    public boolean takeDamage(double damage) {
        health -= damage;
        return health <= 0;
    }

    public void HandleDeath() {
        isDestroyed = true;
        Scoreboard.getInstance().addScore(scoreReward);
    }

    @Override
    public boolean IsDestroyed() {
        return isDestroyed;
    }
}