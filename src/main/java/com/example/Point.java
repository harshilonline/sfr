package com.example;
// Point class definition
public class Point {
    public double x;
    public double y;
    boolean visited;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.visited = false;
    }

    // Calculate Euclidean distance between this point and another point
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }
}
