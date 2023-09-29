package com.lizardwizards.lizardwizards.core;

public class Vector2 {
    double x, y;

    Vector2(double x, double y)
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
}
