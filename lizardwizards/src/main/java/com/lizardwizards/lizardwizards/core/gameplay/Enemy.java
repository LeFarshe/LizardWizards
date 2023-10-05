package com.lizardwizards.lizardwizards.core.gameplay;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Random;

import com.lizardwizards.lizardwizards.core.Vector2;

public class Enemy implements Entity {
    Vector2 position;
    Vector2 moveDirection = new Vector2(0,0);
    Vector2 shootDirection = new Vector2(0,0);
    public List<Weapon> weapons = new ArrayList<>();
    int currentWeapon = 0;
    int health = 1;
    double speed;
    boolean isMoving = false;
    boolean isShooting = false;

    private Random rand = new Random();
    
    public Enemy(Vector2 position, double speed)
    {
        this.position = position;
        this.speed = speed;
        setRandomDirection();
    }

    private void setRandomDirection() {
        double randX = rand.nextDouble() * 2 - 1;
        double randY = rand.nextDouble() * 2 - 1;
        moveDirection = new Vector2(randX, randY).Normalize();
    }

    
    @Override
    public void Move(Vector2 amount)
    {
    	Vector2 newPos = position.Copy().AddVector(amount);
        if(isCollidingWithWalls(newPos)) {
            setRandomDirection();
        } else {
            position = newPos;
        }
        position.AddVector(amount);
    }
    
    private boolean isCollidingWithWalls(Vector2 newPos) {
        return false;
    }

    @Override
    public void MoveByDelta(double delta){
        if (isMoving) { Move(moveDirection.Copy().Multiply(speed * delta));}
    }

    @Override
    public void SetPosition(Vector2 position)
    {
        this.position = position.Copy();
    }

    @Override
    public Vector2 GetPosition() { return this.position.Copy(); }

    @Override
    public void Collide(int layer){

        final int PLAYER_LAYER = 0; 

        if(layer == PLAYER_LAYER) {

            this.HandleDeath();
            
        }

        return;
    }

    private void HandleDeath() {
        System.out.println("Enemy has died!");
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

}
