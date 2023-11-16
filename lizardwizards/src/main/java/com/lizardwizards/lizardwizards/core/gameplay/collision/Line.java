package com.lizardwizards.lizardwizards.core.gameplay.collision;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Line implements Cloneable {
    Vector2 start;
    Vector2 end;

    public Line(Vector2 start, Vector2 end){
        this.start = start.Copy();
        this.end = end.Copy();
    }

    public Line(Vector2 start, Vector2 direction, double length){
        this.start = start.Copy();
        this.end = start.Copy().AddVector(direction.Copy().Normalize().Multiply(length));
    }

    public Vector2 getDirection(){
        return end.Copy().AddVector(start.Copy().Multiply(-1)).Normalize();
    }

    public double getLength(){
        return start.DistanceTo(end);
    }

    /**
     * Returns the slope (0) and intercept (1) of this line.
     * If the slope is infinite, then it will return null and the X value
     */
    public List<Double> getSlopeAndIntercept(){
        List<Double> ans = new ArrayList<>();
        if (start.x == end.x) {
            ans.add(null);
            ans.add(start.x);
        }
        else {
            if (start.y == end.y) {
                ans.add((double)0);
                ans.add(start.y);
            }
            else {
                ans.add((end.y - start.y) / (end.x - start.x));
                ans.add(start.y - (start.x * ans.get(0)));
            }
        }
        return ans;
    }

    /**
     * Checks if a point exists in this finite line when this point exists in an infinite version of this line
     */
    public boolean pointIsInFiniteLine(Vector2 point){
        if (start.x != end.x){
            double xMin, xMax;
            if (start.x < end.x){
                xMin = start.x;
                xMax = end.x;
            }
            else {
                xMin = end.x;
                xMax = start.x;
            }

            return point.x >= xMin && point.x <= xMax;
        }
        else {
            double yMin, yMax;
            if (start.y < end.y){
                yMin = start.y;
                yMax = end.y;
            }
            else {
                yMin = end.y;
                yMax = start.y;
            }

            return point.y >= yMin && point.y <= yMax;
        }
    }

    @Override
    public Line clone() {
        try {
            Line clone = (Line) super.clone();
            clone.start = start.Copy();
            clone.end = end.Copy();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
