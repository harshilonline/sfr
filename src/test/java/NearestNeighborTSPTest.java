
import java.io.IOException;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import com.example.NearestNeighborTSP;
import com.example.Point;

public class NearestNeighborTSPTest {

    // Calculating the Euclidean distance between two points
    @Test
    public void test_calculate_euclidean_distance() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(4.0, 6.0);
    
        double distance = point1.distanceTo(point2);
    
        assertEquals(5.0, distance, 0.001);
    }

    // Finding the nearest unvisited point in the TSP algorithm
    @Test
    public void test_nearest_neighbor_tsp_algorithm() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0.0, 0.0));
        points.add(new Point(1.0, 1.0));
        points.add(new Point(2.0, 2.0));

        List<Point> route = NearestNeighborTSP.nearestNeighborTSP(points);

        assertEquals(4, route.size());
        assertEquals(0.0, route.get(0).x, 0.001);
        assertEquals(0.0, route.get(0).y, 0.001);
        assertEquals(1.0, route.get(1).x, 0.001);
        assertEquals(1.0, route.get(1).y, 0.001);
        assertEquals(2.0, route.get(2).x, 0.001);
        assertEquals(2.0, route.get(2).y, 0.001);
    }

    // Returning to the starting point after visiting all points
    @Test
    public void test_return_to_start_after_visiting_all_points() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0.0, 0.0));
        points.add(new Point(1.0, 0.0));
        points.add(new Point(1.0, 1.0));
        List<Point> route = NearestNeighborTSP.nearestNeighborTSP(points);
        Point start = route.get(0);
        Point end = route.get(route.size() - 1);
        assertEquals(start.x, end.x, 0.001);
        assertEquals(start.y, end.y, 0.001);
    }

    // Calculating the total distance of the route
    @Test
    public void test_calculate_total_distance() {
        List<Point> route = new ArrayList<>();
        route.add(new Point(0, 0));
        route.add(new Point(3, 4));
        route.add(new Point(6, 8));

        double totalDistance = NearestNeighborTSP.calculateTotalDistance(route);

        assertEquals(10.0, totalDistance, 0.001);
    }

    // Outputting the shortest route and total distance
    @Test
    public void test_output_shortest_route_and_distance() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0.0, 0.0));
        points.add(new Point(1.0, 1.0));
        points.add(new Point(2.0, 2.0));

        List<Point> shortestRoute = NearestNeighborTSP.nearestNeighborTSP(points);
        double shortestDistance = NearestNeighborTSP.calculateTotalDistance(shortestRoute);

        assertEquals(4, shortestRoute.size());
        assertEquals(0.0, shortestRoute.get(0).x, 0.001);
        assertEquals(0.0, shortestRoute.get(0).y, 0.001);
        assertEquals(1.0, shortestRoute.get(1).x, 0.001);
        assertEquals(1.0, shortestRoute.get(1).y, 0.001);
        assertEquals(2.0, shortestRoute.get(2).x, 0.001);
        assertEquals(2.0, shortestRoute.get(2).y, 0.001);
        assertEquals(0.0, shortestRoute.get(3).x, 0.001);
        assertEquals(0.0, shortestRoute.get(3).y, 0.001);

        assertEquals(5.656854249492381, shortestDistance, 0.001);
    }
}