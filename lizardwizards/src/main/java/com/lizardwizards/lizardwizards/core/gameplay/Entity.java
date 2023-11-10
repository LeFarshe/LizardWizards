package com.lizardwizards.lizardwizards.core.gameplay;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.UUID;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public abstract class Entity implements Serializable, Cloneable {

    public UUID uuid = UUID.randomUUID();
    protected Vector2 position;

    public void SetPosition(Vector2 position){
        this.position = position.Copy();
    };

    public Vector2 GetPosition(){
            return this.position.Copy();
    };

    public void Move(Vector2 amount){
        this.position.AddVector(amount);
    };
    // Delta is in seconds
    public abstract void MoveByDelta(double delta);

    public abstract void Collide(CollisionLayer layer);

    public abstract Dictionary<String, Integer> GetSpriteSettings();
    public abstract boolean IsDestroyed();

    public Entity clone() {
        try {
            Entity clone = (Entity) super.clone();
            clone.uuid = UUID.randomUUID();
            if (position != null) {
                clone.position = position.Copy();
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
