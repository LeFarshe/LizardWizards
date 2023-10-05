package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.Dictionary;

public class Projectile extends Entity{
    Vector2 direction;
    double speed;
    double duration;


    Projectile(Vector2 direction, double speed, double duration, Vector2 spriteSize)
    {
        this.direction = direction;
        this.speed = speed;
        this.duration = duration;
    }

    @Override
    public void MoveByDelta(double delta)
    {
        duration -= delta;
        Move(direction.Copy().Multiply(speed * delta));
    }

    @Override
    public void Collide(int layer) { return; }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings() {

        return null;
    }

    @Override
    public boolean IsDestroyed() {
        if (duration <= 0) { return true;}
        return false;
    }

    public EntitySprite GetSprite() {
        return new EntitySprite(position.Copy(), new Vector2(5,5));
    }

    public Collider GetCollider() {
        return Collider.NewRectangle(position.Copy(), 5, 5, 2);
    }
}
