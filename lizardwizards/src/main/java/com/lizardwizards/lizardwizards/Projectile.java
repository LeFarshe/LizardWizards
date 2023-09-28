package com.lizardwizards.lizardwizards;

public class Projectile {
    Vector2 position;
    Vector2 direction;
    double speed;
    double duration;

    EntitySprite sprite;

    Projectile(Vector2 direction, double speed, double duration, Vector2 spriteSize)
    {
        this.direction = direction;
        this.speed = speed;
        this.duration = duration;
        sprite = new EntitySprite(new Vector2(0,0), spriteSize);
    }

    public void UpdateStartPosition(Vector2 position)
    {
        this.position = position;
        sprite.Move(position);
    }

    //Returns true if it needs to be destroyed
    public boolean Move(double delta)
    {
        duration -= delta;
        if (duration <= 0) { return true;}

        position.AddVector(direction.Copy().Multiply(speed * delta));
        sprite.Move(position);

        return false;
    }
}
