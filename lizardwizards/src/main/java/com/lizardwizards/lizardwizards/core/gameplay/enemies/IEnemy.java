package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

import java.util.Dictionary;
public interface IEnemy {
    void setRandomDirection();
    void MoveByDelta(double delta);
    void Collide(CollisionLayer layer);
    void HandleDeath();
    boolean IsDestroyed();
    Dictionary<String, Integer> GetSpriteSettings();
}