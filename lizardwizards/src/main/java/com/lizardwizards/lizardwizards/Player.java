package com.lizardwizards.lizardwizards;

import java.util.List;

public class Player {
    Vector2 position;
    Vector2 moveDirection = new Vector2(0,0);
    Vector2 shootDirection = new Vector2(0,0);
    EntitySprite sprite;
    List<Weapon> weapons;
    int currentWeapon = 0;
    double speed;
    boolean isMoving = false;
    boolean isShooting = false;

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
        isMoving = true;
        moveDirection = direction;
    }

    public void StopMoving()
    {
        isMoving = false;
    }

    public List<Projectile> Shoot(double delta)
    {
        if (isShooting)
        {
            return weapons.get(currentWeapon).ContinueShooting(delta, shootDirection);
        }
        else { weapons.get(currentWeapon).AddTimeWithoutShoot(delta); };
        return null;
    }

    public void StartShooting(Vector2 direction)
    {
        if (direction.x == 0 && direction.y == 0)
        {
            StopShooting();
            return;
        }
        isShooting = true;
        shootDirection = direction;
    }

    public void StopShooting()
    {
        isShooting = false;
    }
}
