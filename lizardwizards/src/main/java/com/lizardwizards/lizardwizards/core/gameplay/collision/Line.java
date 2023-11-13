package com.lizardwizards.lizardwizards.core.gameplay.collision;

import com.lizardwizards.lizardwizards.core.Vector2;

public class Line {
    Vector2 start;
    Vector2 end;

    public Line(Vector2 start, Vector2 end){
        this.start = start;
        this.end = end;
    }

    public Line(Vector2 start, Vector2 direction, double length){
        this.start = start;
        this.end = start.Copy().AddVector(direction.Copy().Normalize().Multiply(length));
    }

    public Vector2 getDirection(){
        return end.Copy().AddVector(start.Copy().Multiply(-1)).Normalize();
    }

    public double getLength(){
        return start.DistanceTo(end);
    }
}
