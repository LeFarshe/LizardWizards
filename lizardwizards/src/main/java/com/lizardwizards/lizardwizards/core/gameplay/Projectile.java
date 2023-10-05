package com.lizardwizards.lizardwizards.core.gameplay;

import java.util.Dictionary;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;

public class Projectile implements Entity{
    Vector2 position;
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
    public void Move(Vector2 amount){
        position.AddVector(amount);
    }

    @Override
    public void MoveByDelta(double delta)
    {
        duration -= delta;
        Move(direction.Copy().Multiply(speed * delta));
    }
    @Override
    public Vector2 GetPosition() { return position.Copy(); }
    @Override
    public void SetPosition(Vector2 position) { this.position = position.Copy(); }
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
}
