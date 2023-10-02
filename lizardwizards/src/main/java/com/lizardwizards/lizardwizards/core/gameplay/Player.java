package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Player {
    Vector2 position;
    Vector2 moveDirection = new Vector2(0,0);
    Vector2 shootDirection = new Vector2(0,0);
    public EntitySprite sprite;
    public List<Weapon> weapons = new ArrayList<>();
    int currentWeapon = 0;
    double speed;
    boolean isMoving = false;
    boolean isShooting = false;

    public Player(Vector2 position, double speed)
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
        List<Projectile> newProjectiles;
        if (isShooting)
        {
            newProjectiles = weapons.get(currentWeapon).ContinueShooting(delta, shootDirection);
            if (newProjectiles != null) {
                for (Projectile projectile: newProjectiles)
                {
                    projectile.UpdateStartPosition(position.Copy());
                }
            }
            return newProjectiles;
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
