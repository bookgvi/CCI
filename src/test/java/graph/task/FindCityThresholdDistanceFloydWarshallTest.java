package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindCityThresholdDistanceFloydWarshallTest {

    private FindCityThresholdDistance_FloydWarshall f;

    @Before
    public void setUp() throws Exception {
        f = new FindCityThresholdDistance_FloydWarshall();
    }

    @Test
    public void findTheCity() {
        int n = 4, distanceThreshold = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int expected = 3;
        int res = f.findTheCity(n, edges, distanceThreshold);
        assertEquals(expected, res);
    }
    
    @Test
    public void findTheCity2() {
        int n = 5, distanceThreshold = 2;
        int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int expected = 0;
        int res = f.findTheCity(n, edges, distanceThreshold);
        assertEquals(expected, res);
    }
}