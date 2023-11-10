package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import java.util.Dictionary;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public abstract class Enemy extends Entity implements IEnemy {
    protected IEnemyImplementor implementor;
    protected int health;
    protected boolean isDestroyed;

    protected Vector2 position;
    public Enemy(IEnemyImplementor implementor, int health, Vector2 position) {
        this.SetPosition(position);
        this.implementor = implementor;
        this.health = health;
        this.position = position;
    }

    @Override
    public void MoveByDelta(double delta) {
        implementor.move(delta);
    }

    @Override
    public void Collide(CollisionLayer layer) {
        implementor.onCollision(layer);
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