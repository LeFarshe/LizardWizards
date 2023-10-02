package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;

public class SpriteWrapper {
    EntitySprite sprite;
    Entity entity;

    public void Move(Vector2 amount){
        entity.Move(amount);
        sprite.Move(amount);
    }

    public void Teleport(Vector2 position){
        entity.Teleport(position);
        sprite.Teleport(position);
    }
}
