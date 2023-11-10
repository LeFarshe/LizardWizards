package com.lizardwizards.lizardwizards.core.gameplay;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.Projectile;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.Weapon;

public class Player extends Entity {
    Vector2 moveDirection = new Vector2(0,0);
    Vector2 shootDirection = new Vector2(0,0);
    public List<Weapon> weapons = new ArrayList<>();
    int currentWeapon = 0;
    int health = 4;
    double speed;
    boolean isMoving = false;
    boolean isShooting = false;
    boolean isImmune = false;
    double immuneTimerMax = 1;
    double currentImmuneTimer = 0;

    public Player(Vector2 position, double speed)
    {
        this.position = position;
        this.speed = speed;
    }

    @Override
    public void MoveByDelta(double delta){
        if (isImmune){
            currentImmuneTimer -= delta;
            if (currentImmuneTimer <= 0) {
                isImmune = false;
            }
        }
        if (isMoving) { Move(moveDirection.Copy().Multiply(speed * delta));
        }
    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer){
        final CollisionLayer ENEMY_LAYER = CollisionLayer.Enemy;
        final CollisionLayer ENEMY_PROJECTILE_LAYER = CollisionLayer.EnemyProjectile;

        if (!isImmune) {
            if (layer == ENEMY_LAYER || layer == ENEMY_PROJECTILE_LAYER) {
                isImmune = true;
                currentImmuneTimer = immuneTimerMax;
                this.health -= 1;

                if (this.health <= 0) {
                    this.HandleDeath();
                }
            }
        }
        return;
    }

    private void HandleDeath() {
        // Here you can handle player death, e.g., 
        // setting a flag, triggering a respawn, or updating the game state.
        // For now, we'll simply print out a message:
        System.out.println("Player has died!");
    }

    @Override
    public boolean IsDestroyed() {
        return false;
    }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings(){
        return null;
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
                    projectile.SetPosition(position.Copy());
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

    public void ChangeWeapon(int change){
        currentWeapon += change;
        if (currentWeapon >= weapons.size()) { currentWeapon -= weapons.size(); }
        else if (currentWeapon < 0) { currentWeapon += weapons.size(); }
    }

    @Override
    public Player clone(){
        Player clone = (Player)super.clone();
        if (moveDirection != null) { clone.moveDirection = moveDirection.Copy(); }
        if (shootDirection != null) { clone.shootDirection = shootDirection.Copy(); }

        clone.weapons = new ArrayList<>();
        for (Weapon weapon: weapons){
            clone.weapons.add(weapon.clone());
        }

        clone.currentWeapon = currentWeapon;
        clone.health = health;
        clone.speed = speed;
        clone.isMoving = isMoving;
        clone.isShooting = isShooting;
        clone.isImmune = isImmune;
        clone.immuneTimerMax = immuneTimerMax;
        clone.currentImmuneTimer = currentImmuneTimer;
        return clone;
    }
}
