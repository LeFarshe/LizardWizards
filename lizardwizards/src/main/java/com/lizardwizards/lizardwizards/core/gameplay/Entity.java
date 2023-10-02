package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.Dictionary;

public interface Entity {

    void Teleport(Vector2 position);

    void Move(Vector2 amount);

    void Collide(int layer);

    Dictionary<String, Integer> GetSpriteSettings();
    boolean IsDestroyed();
}
