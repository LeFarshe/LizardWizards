package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import java.util.Dictionary;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public abstract class Enemy extends IEnemy {
    protected IEnemyImplementor implementor;
    protected double health;
    protected boolean isDestroyed;

    protected Vector2 position;
    public Enemy(IEnemyImplementor implementor, double health, Vector2 position) {
        this.SetPosition(position);
        this.implementor = implementor;
        this.health = health;
        this.position = position;
    }

    @Override
    public void MoveByDelta(double delta) {
        implementor.move(delta);
    }


    public void Collide(Entity collidingEntity, CollisionLayer layer) {
        implementor.onCollision(collidingEntity, layer);
    }

    @Override
    public boolean IsDestroyed() {
        return implementor.isDestroyed();
    }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings(){
        return null;
    }
}