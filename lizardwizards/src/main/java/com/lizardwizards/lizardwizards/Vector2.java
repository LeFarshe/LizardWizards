package com.lizardwizards.lizardwizards;

public class Vector2 {
    float x, y;

    Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void Normalize(){
        float sum = x * x + y * y;
        this.SetAll(this.x / sum, this.y / sum);
    }

    public Vector2 AddVector(Vector2 vector)
    {
        x += vector.GetX();
        y += vector.GetY();
        return this;
    }

    public Vector2 Multiply(float multiplier)
    {
        x *= multiplier;
        y *= multiplier;
        return this;
    }

    public float GetX() { return x; }
    public float GetY() { return y; }
    public void SetAll(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    public Vector2 Copy()
    {
        return new Vector2(this.x, this.y);
    }
}
