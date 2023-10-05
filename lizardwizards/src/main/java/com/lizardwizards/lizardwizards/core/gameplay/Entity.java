package com.lizardwizards.lizardwizards.core.gameplay;

import java.util.Dictionary;

import com.lizardwizards.lizardwizards.core.Vector2;

public interface Entity {

    void SetPosition(Vector2 position);

    Vector2 GetPosition();

    void Move(Vector2 amount);
    // Delta is in seconds
    void MoveByDelta(double delta);

    void Collide(int layer);

    Dictionary<String, Integer> GetSpriteSettings();
    boolean IsDestroyed();
}
