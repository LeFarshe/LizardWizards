package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.io.Serializable;
import java.util.Random;

public interface EnemyMovementStrategy {

    public Vector2 getDirection();
}

class SimpleMovementStrategy implements EnemyMovementStrategy, Serializable {

    private final Random rand = new Random();

    @Override
    public Vector2 getDirection() {
        double randX = rand.nextDouble() * 2 - 1;
        double randY = rand.nextDouble() * 2 - 1;
        return new Vector2(randX, randY).Normalize();
    }
}

class ZigzagMovementStrategy implements EnemyMovementStrategy, Serializable {
    private Vector2 direction1;
    private Vector2 direction2;
    private int switchCounter = 0;

    public ZigzagMovementStrategy(Vector2 direction1, Vector2 direction2) {
        this.direction1 = direction1.Normalize();
        this.direction2 = direction2.Normalize();
    }

    @Override
    public Vector2 getDirection() {
        switchCounter++;
        if (switchCounter % 10 == 0) {
            return direction2;
        } else {
            return direction1;
        }
    }
}

class LinearMovementStrategy implements EnemyMovementStrategy, Serializable {
    private Vector2 direction;

    public LinearMovementStrategy(Vector2 direction) {
        this.direction = direction.Normalize();
    }

    @Override
    public Vector2 getDirection() {
        return direction;
    }
}

class CircularMovementStrategy implements EnemyMovementStrategy, Serializable {
    private double angle = 0;
    private double radius;
    private double speed; // Radians per tick

    public CircularMovementStrategy(double radius, double speed) {
        this.radius = radius;
        this.speed = speed;
    }

    @Override
    public Vector2 getDirection() {
        angle += speed;
        double x = Math.cos(angle) * radius;
        double y = Math.sin(angle) * radius;
        return new Vector2(x, y);
    }
}