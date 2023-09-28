package com.lizardwizards.lizardwizards;

public class Player {
    Vector2 position;
    Vector2 moveDirection = new Vector2(0,0);
    EntitySprite sprite;
    double speed;
    boolean isMoving = false;

    Player (Vector2 position, double speed)
    {
        this.position = position;
        this.speed = speed;
    }

    //Delta in seconds
    public void Move(double delta)
    {
        if (isMoving)
        {
            Vector2 directionTemp = moveDirection.Copy();
            position.AddVector(directionTemp.Multiply(speed * delta));
            sprite.Move(position);
        }
    }

    public void StartMoving(Vector2 direction)
    {
        if (direction.x == 0 && direction.y == 0)
        {
            StopMoving();
            return;
        }
        direction.Normalize();
        isMoving = true;
        moveDirection = direction;
    }

    public void StopMoving()
    {
        isMoving = false;
    }
}
