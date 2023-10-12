package com.lizardwizards.lizardwizards.core;

import java.io.Serializable;

public class Vector2 implements Serializable {
    public double x, y;

    public Vector2(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2 Normalize(){
        double sum = x * x + y * y;
        if (sum == 0) { return this; }
        this.SetAll(this.x / Math.sqrt(sum), this.y / Math.sqrt(sum));
        return this;
    }

    public Vector2 AddVector(Vector2 vector)
    {
        x += vector.x;
        y += vector.y;
        return this;
    }

    public Vector2 Multiply(double multiplier)
    {
        x *= multiplier;
        y *= multiplier;
        return this;
    }

    public void SetAll(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public Vector2 Copy()
    {
        return new Vector2(this.x, this.y);
    }

    public double DistanceTo(Vector2 secondPoint){
        return Math.sqrt(Math.pow(x - secondPoint.x, 2) + Math.pow(y - secondPoint.y, 2));
    }
    public Vector2 Rotate(double rad){
        double newX = Math.cos(rad) * x - Math.sin(rad) * y;
        double newY = Math.sin(rad) * x + Math.cos(rad) * y;
        x = newX;
        y = newY;
        return this;
    }
}
