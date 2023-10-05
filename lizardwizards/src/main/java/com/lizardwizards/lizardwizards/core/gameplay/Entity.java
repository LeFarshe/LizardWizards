package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.Dictionary;

public abstract class Entity {

    Vector2 position;

    public void SetPosition(Vector2 position){
        this.position = position.Copy();
    };

    public Vector2 GetPosition(){
        return position.Copy();
    };

    public void Move(Vector2 amount){
        this.position.AddVector(amount);
    };
    // Delta is in seconds
    public abstract void MoveByDelta(double delta);

    public abstract void Collide(int layer);

    public abstract Dictionary<String, Integer> GetSpriteSettings();
    public abstract boolean IsDestroyed();
}
