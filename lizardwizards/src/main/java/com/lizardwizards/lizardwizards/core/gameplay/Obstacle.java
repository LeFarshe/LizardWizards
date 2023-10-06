package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.Dictionary;

public class Obstacle extends Entity{
    public Obstacle(Vector2 position){
        this.position = position.Copy();
    }
    @Override
    public void MoveByDelta(double delta) {
        return;
    }

    @Override
    public void Collide(CollisionLayer layer) {
        return;
    }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings() {
        return null;
    }

    @Override
    public boolean IsDestroyed(boolean flag) {
        return false;
    }
}
