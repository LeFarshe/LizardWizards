package com.lizardwizards.lizardwizards;

public class Player {
    Vector2 position, moveDirection;
    double speed;
    boolean isMoving;

    //Delta in seconds
    public void Move(double delta)
    {
        Vector2 directionTemp = moveDirection.Copy();
        position.AddVector(directionTemp.Multiply(speed * delta));
    }

    public void StartMoving(Vector2 direction)
    {
        isMoving = true;
        moveDirection = direction;
    }

    public void StopMoving()
    {
        isMoving = false;
    }
}
