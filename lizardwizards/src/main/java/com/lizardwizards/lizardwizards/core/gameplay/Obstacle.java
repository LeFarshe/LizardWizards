package com.lizardwizards.lizardwizards.core.gameplay;

import java.util.Dictionary;

public class Obstacle extends Entity{
    @Override
    public void MoveByDelta(double delta) {
        return;
    }

    @Override
    public void Collide(int layer) {
        return;
    }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings() {
        return null;
    }

    @Override
    public boolean IsDestroyed() {
        return false;
    }
}
