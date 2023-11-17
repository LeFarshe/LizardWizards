package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import java.util.Dictionary;

import com.lizardwizards.lizardwizards.core.Vector2;

public abstract class Enemy extends IEnemy {
    protected IEnemyImplementor implementor;
    protected double health;
    protected boolean isDestroyed;

    protected Vector2 position;

    double directionDelay = 1;
    double directionTimer = directionDelay;
    public Enemy(IEnemyImplementor implementor, double health, Vector2 position) {
        this.SetPosition(position);
        this.implementor = implementor;
        this.health = health;
        this.position = position;
    }

    @Override
    public void MoveByDelta(double delta) {
        directionTimer -= delta;
        if (directionTimer <= 0){
            directionTimer = directionDelay;
        }
        implementor.move(delta);
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