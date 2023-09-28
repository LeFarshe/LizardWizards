package com.lizardwizards.lizardwizards;

public class Vector2 {
    double x, y;

    Vector2(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void Normalize(){
        double sum = x * x + y * y;
        if (sum == 0) { return; }
        this.SetAll(this.x / Math.sqrt(sum), this.y / Math.sqrt(sum));
    }

    public Vector2 AddVector(Vector2 vector)
    {
        x += vector.GetX();
        y += vector.GetY();
        return this;
    }

    public Vector2 Multiply(double multiplier)
    {
        x *= multiplier;
        y *= multiplier;
        return this;
    }

    public double GetX() { return x; }
    public double GetY() { return y; }
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
