package com.lizardwizards.lizardwizards;

public class Player {
    Vector2 position;
    Vector2 moveDirection = new Vector2(0,0);
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
        Vector2 directionTemp = moveDirection.Copy();
        position.AddVector(directionTemp.Multiply(speed * delta));
    }

    public void StartMoving(Vector2 direction)
    {
        if (direction.x == 0 && direction.x == 0)
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
