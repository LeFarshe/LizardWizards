package com.lizardwizards.lizardwizards.core.gameplay;

import java.util.Dictionary;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public class Projectile extends Entity{
    Vector2 direction;
    double speed;
    double duration;
    boolean erase = false;
    Vector2 spriteSize;


    public Projectile(Vector2 direction, double speed, double duration, Vector2 spriteSize)
    {
        this.direction = direction;
        this.speed = speed;
        this.duration = duration;
        this.spriteSize = spriteSize;
    }

    @Override
    public void MoveByDelta(double delta)
    {
        duration -= delta;
        Move(direction.Copy().Multiply(speed * delta));
    }

    @Override
    public void Collide(CollisionLayer layer) {
        if (layer == CollisionLayer.Obstacle){
            erase = true;
        }
    }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings() {

        return null;
    }

    @Override
    public boolean IsDestroyed() {
        return duration <= 0 || erase;
    }

    public EntitySprite GetSprite() {
        return new EntitySprite(position.Copy(), spriteSize.Copy());
    }

    public Collider GetCollider(CollisionLayer layer) {
        return Collider.NewRectangle(position.Copy(), spriteSize.x, spriteSize.y, layer);
    }
}
