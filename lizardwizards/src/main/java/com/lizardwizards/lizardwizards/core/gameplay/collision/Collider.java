package com.lizardwizards.lizardwizards.core.gameplay.collision;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Collider implements Serializable, Cloneable {
    // Center of shape
    public Vector2 position;

    // Circle only has radius, rectangle has width and height
    List<Double> shapeDetails;
    private CollisionShape shape;

    // 0 - player, 1 - entity, 2 - projectiles, 3 - obstacles
    public CollisionLayer layer;

    Collider(Vector2 position, List<Double> shapeDetails, CollisionShape shape, CollisionLayer colLayer){
        this.position = position;
        this.shapeDetails = shapeDetails;
        this.shape = shape;
        this.layer = colLayer;
    }

    public static Collider NewRectangle(Vector2 centerPosition, double width, double height, CollisionLayer colLayer){
        List<Double> shapeDetails = new ArrayList<>();
        shapeDetails.add(width);
        shapeDetails.add(height);
        return new Collider(centerPosition, shapeDetails, CollisionShape.Rectangle, colLayer);
    }

    public static Collider NewCircle(Vector2 centerPosition, double radius, CollisionLayer colLayer){
        List<Double> shapeDetails = new ArrayList<>();
        shapeDetails.add(radius);
        return new Collider(centerPosition, shapeDetails, CollisionShape.Circle, colLayer);
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
    private static boolean CollideCircles(Collider circle1, Collider circle2){
        double radiusSum = circle1.shapeDetails.get(0) + circle2.shapeDetails.get(0);
        return circle1.position.DistanceTo(circle2.position) <= radiusSum;
    }
    private static boolean CollideRectangles(Collider rect1, Collider rect2){
        return !(rect1.position.x + rect1.shapeDetails.get(0) / 2 < rect2.position.x - rect2.shapeDetails.get(0) / 2 ||
                rect1.position.x - rect1.shapeDetails.get(0) / 2 > rect2.position.x + rect2.shapeDetails.get(0) / 2 ||
                rect1.position.y + rect1.shapeDetails.get(1) / 2 < rect2.position.y - rect2.shapeDetails.get(1) / 2 ||
                rect1.position.y - rect1.shapeDetails.get(1) / 2 > rect2.position.y + rect2.shapeDetails.get(1) / 2);
    }
    private static boolean CollideCircleRectangle(Collider circle, Collider rectangle){
        double x = rectangle.position.x - rectangle.shapeDetails.get(0) / 2;
        double y = rectangle.position.y - rectangle.shapeDetails.get(1) / 2;
        double closestX = Clamp(circle.position.x, x, x + rectangle.shapeDetails.get(0));
        double closestY = Clamp(circle.position.y, y, y + rectangle.shapeDetails.get(1));

        return circle.position.DistanceTo(new Vector2(closestX, closestY)) <= circle.shapeDetails.get(0);
    }

    public List<Vector2> IntersectLine(Line line){
        if (shape == CollisionShape.Rectangle) {
            return IntersectInSquare(this, line);
        }
        return null;
    }

    private static List<Vector2> IntersectInSquare(Collider square, Line line){
        ArrayList<Vector2> allIntersections = new ArrayList<>();

        Vector2 topLeft = square.position.Copy().AddVector(new Vector2(-square.shapeDetails.get(0) / 2, -square.shapeDetails.get(1) / 2));
        Vector2 bottomLeft = topLeft.Copy().AddVector(new Vector2(0,square.shapeDetails.get(1)));
        Vector2 bottomRight = bottomLeft.Copy().AddVector(new Vector2(square.shapeDetails.get(0), 0));
        Vector2 topRight = topLeft.Copy().AddVector(new Vector2(square.shapeDetails.get(0), 0));


        Line newLine = new Line(topLeft, bottomLeft);
        Vector2 intersection = IntersectLines(line, newLine);
        if (intersection != null) {
            allIntersections.add(intersection); }

        newLine = new Line(bottomLeft, bottomRight);
        intersection = IntersectLines(line, newLine);
        if (intersection != null) {
            allIntersections.add(intersection); }

        newLine = new Line(bottomRight, topRight);
        intersection = IntersectLines(line, newLine);
        if (intersection != null) {
            allIntersections.add(intersection); }

        newLine = new Line(topRight, topLeft);
        intersection = IntersectLines(line, newLine);
        if (intersection != null) {
            allIntersections.add(intersection); }

        ArrayList<Vector2> allIntersectionsCleaned = new ArrayList<>();
        boolean alreadyExists;
        for (Vector2 collision : allIntersections){
            alreadyExists = false;
            for (Vector2 savedCollision: allIntersectionsCleaned) {
                if (collision.x == savedCollision.x && collision.y == savedCollision.y) {
                    alreadyExists = true;
                    break;
                }
            }
            if (!alreadyExists) {
                if (!allIntersectionsCleaned.isEmpty()){
                    if (line.start.DistanceTo(collision) < line.start.DistanceTo(allIntersectionsCleaned.get(0))){
                        allIntersectionsCleaned.add(0, collision);
                    }
                    else {
                        allIntersectionsCleaned.add(collision);
                    }
                }
                else {
                    allIntersectionsCleaned.add(collision);
                }
            }
        }

        return allIntersectionsCleaned;
    }

    private static Vector2 IntersectLines(Line line1, Line line2){
        List<Double> line1SI = line1.getSlopeAndIntercept();
        List<Double> line2SI = line2.getSlopeAndIntercept();

        if (line1SI.get(0) == null) {
            if (line2SI.get(0) == null) {
                if (!line1SI.get(1).equals(line2SI.get(1))) { return null; }
                if (line2.pointIsInFiniteLine(line1.start)) { return line1.start.Copy(); }
                else {
                    Vector2 resultVector;
                    if (line1.start.DistanceTo(line2.start) < line1.start.DistanceTo(line2.end)) {resultVector = line2.start; }
                    else { resultVector = line2.end; }

                    if (line1.pointIsInFiniteLine(resultVector)) { return resultVector.Copy(); }
                    else { return null; }
                }
            }

            else {
                Vector2 collision = new Vector2(line1SI.get(1), line2SI.get(0) * line1SI.get(1) + line2SI.get(1));
                if (line1.pointIsInFiniteLine(collision)) { return collision; }
                return null;
            }
        }
        else if (line2SI.get(0) == null) {
            Vector2 collision = new Vector2(line2SI.get(1), line1SI.get(0) * line2SI.get(1) + line1SI.get(1));
            if (line2.pointIsInFiniteLine(collision)) { return collision; }
            return null;
        }
        else {
            double slopeDiff = line1SI.get(0) - line2SI.get(0);
            double interceptDiff = line2SI.get(1) - line1SI.get(1);

            if (slopeDiff == 0) {
                if (interceptDiff != 0) { return null; }
                if (line2.pointIsInFiniteLine(line1.start)) { return line1.start.Copy(); }
                else {
                    Vector2 resultVector;
                    if (line1.start.DistanceTo(line2.start) < line1.start.DistanceTo(line2.end)) { resultVector = line2.start; }
                    else { resultVector = line2.end; }

                    if (line1.pointIsInFiniteLine(resultVector)) { return resultVector.Copy(); }
                    else { return null; }
                }
            }
            else {
                double x = interceptDiff / slopeDiff;
                Vector2 resultVector = new Vector2(x, line1SI.get(0) * x + line1SI.get(1));
                if (line1.pointIsInFiniteLine(resultVector)) { return resultVector; }
                else { return null; }
            }
        }

    }

    public static double Clamp(double value, double min, double max){
        if (value < min){ return min;}
        if (value > max){ return max;}
        return value;
    }

    @Override
    public Collider clone() {
        try {
            Collider clone = (Collider) super.clone();
            if (position != null) { clone.position = position.Copy(); }

            if (shapeDetails != null) {
                clone.shapeDetails = new ArrayList<>();
                for (Double detail: shapeDetails){
                    clone.shapeDetails.add(detail.doubleValue());
                }
            }

            clone.shape = shape;
            clone.layer = layer;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
