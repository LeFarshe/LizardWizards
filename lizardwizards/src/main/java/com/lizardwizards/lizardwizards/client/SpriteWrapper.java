package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;

public class SpriteWrapper {
    public Entity entity;
    public EntitySprite sprite;

    public SpriteWrapper(Entity entity, EntitySprite sprite)
    {
        this.entity = entity;
        this.sprite = sprite;
    }

    public void Move(Vector2 amount){
        entity.Move(amount);
        sprite.Move(amount);
    }

    public void MoveByDelta(double delta){
        entity.MoveByDelta(delta);
        sprite.SetPosition(entity.GetPosition());
    }

    public void SetPosition(Vector2 position){
        entity.SetPosition(position);
        sprite.SetPosition(position);
    }
}
