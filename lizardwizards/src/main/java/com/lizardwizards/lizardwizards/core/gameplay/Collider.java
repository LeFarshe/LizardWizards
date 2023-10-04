package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Collider {
    // Center of shape
    Vector2 position;

    // Circle only has radius, rectangle has width and height
    List<Double> shapeDetails;
    private CollisionShape shape;

    Collider(Vector2 position, List<Double> shapeDetails, CollisionShape shape){
        this.position = position;
        this.shapeDetails = shapeDetails;
        this.shape = shape;
    }

    public static Collider NewRectangle(Vector2 centerPosition, double width, double height){
        List<Double> shapeDetails = new ArrayList<>();
        shapeDetails.add(width);
        shapeDetails.add(height);
        return new Collider(centerPosition, shapeDetails, CollisionShape.Rectangle);
    }

    public static Collider NewCircle(Vector2 centerPosition, double radius){
        List<Double> shapeDetails = new ArrayList<>();
        shapeDetails.add(radius);
        return new Collider(centerPosition, shapeDetails, CollisionShape.Circle);
    }

    public boolean Collide(Collider collider){
        if (shape == CollisionShape.Circle){
            if (collider.shape == CollisionShape.Circle) { return CollideCircles(this, collider); }
            else { return CollideCircleRectangle(this, collider); }
        }
        else {
            if (collider.shape == CollisionShape.Circle) { return CollideCircleRectangle(collider, this); }
            else { return CollideRectangles(this, collider); }
        }
    }
    public static boolean CollideCircles(Collider circle1, Collider circle2){
        double radiusSum = circle1.shapeDetails.get(0) + circle2.shapeDetails.get(0);
        return circle1.position.DistanceTo(circle2.position) <= radiusSum;
    }
    public static boolean CollideRectangles(Collider rect1, Collider rect2){
        return !(rect1.position.x + rect1.shapeDetails.get(0) / 2 < rect2.position.x - rect2.shapeDetails.get(0) / 2 ||
                rect1.position.x - rect1.shapeDetails.get(0) / 2 > rect2.position.x + rect2.shapeDetails.get(0) / 2 ||
                rect1.position.y + rect1.shapeDetails.get(1) / 2 < rect2.position.y - rect2.shapeDetails.get(1) / 2 ||
                rect1.position.y - rect1.shapeDetails.get(1) / 2 > rect2.position.y + rect2.shapeDetails.get(1) / 2);
    }
    public static boolean CollideCircleRectangle(Collider circle, Collider rectangle){
        double x = rectangle.position.x - rectangle.shapeDetails.get(0) / 2;
        double y = rectangle.position.y - rectangle.shapeDetails.get(1) / 2;
        double closestX = Clamp(circle.position.x, x, x + rectangle.shapeDetails.get(0));
        double closestY = Clamp(circle.position.y, y, y + rectangle.shapeDetails.get(1));

        return circle.position.DistanceTo(new Vector2(closestX, closestY)) <= circle.shapeDetails.get(0);
    }

    public static double Clamp(double value, double min, double max){
        if (value < min){ return min;}
        if (value > max){ return max;}
        return value;
    }
}
