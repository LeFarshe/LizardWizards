package com.lizardwizards.lizardwizards.core.gameplay;

import java.util.Dictionary;
public interface IEnemy {
    void setRandomDirection();
    void MoveByDelta(double delta);
    void Collide(CollisionLayer layer);
    void HandleDeath();
    boolean IsDestroyed();
    Dictionary<String, Integer> GetSpriteSettings();
}