package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

import java.util.Dictionary;

public class Obstacle extends Entity{
    public Obstacle(Vector2 position){
        this.position = position.Copy();
    }
    @Override
    public void MoveByDelta(double delta) {
    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
    }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings() {
        return null;
    }

    @Override
    public boolean IsDestroyed() {
        return false;
    }
    @Override
    public Obstacle clone(){
        return (Obstacle)super.clone();
    }
}
