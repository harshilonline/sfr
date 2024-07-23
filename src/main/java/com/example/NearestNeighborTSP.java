package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// Main class NearestNeighborTSP
public class NearestNeighborTSP {

    // Read delivery points from file
    public static List<Point> readDeliveryPoints(String filename) throws IOException {
        List<Point> points = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            double x = Double.parseDouble(parts[0].trim());
            double y = Double.parseDouble(parts[1].trim());
            points.add(new Point(x, y));
        }
        reader.close();
        return points;
    }

    // Find shortest route using Nearest Neighbor algorithm
    public static List<Point> nearestNeighborTSP(List<Point> points) {
        List<Point> route = new ArrayList<>();
        Point start = points.get(0); // Start from the first point
        Point current = start;
        route.add(current);
        current.visited = true;

        // Find the nearest unvisited point to the current point
        while (route.size() < points.size()) {
            Point nearest = null;
            double minDistance = Double.POSITIVE_INFINITY;
            for (Point point : points) {
                if (!point.visited) {
                    double distance = current.distanceTo(point);
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearest = point;
                    }
                }
            }
            if (nearest != null) {
                route.add(nearest);
                nearest.visited = true;
                current = nearest;
            }
        }

        // Return to the starting point
        route.add(start);

        return route;
    }

    // Calculate total distance of a route (list of points)
    public static double calculateTotalDistance(List<Point> route) {
        double totalDistance = 0.0;
        for (int i = 0; i < route.size() - 1; i++) {
            totalDistance += route.get(i).distanceTo(route.get(i + 1));
        }
        return totalDistance;
    }

    public static void main(String[] args) {
        try {
            List<Point> points = readDeliveryPoints("delivery_points.txt");
            List<Point> shortestRoute = nearestNeighborTSP(points);
            double shortestDistance = calculateTotalDistance(shortestRoute);

            // Output the shortest route
            System.out.println("Shortest Route:");
            for (Point point : shortestRoute) {
                System.out.println("(" + point.x + ", " + point.y + ")");
            }
            System.out.println("Total Distance: " + shortestDistance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
