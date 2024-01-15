package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathMaximumProbabilityDijkstraTest {

    private PathMaximumProbability_dijkstra p;

    @Before
    public void setUp() throws Exception {
        p = new PathMaximumProbability_dijkstra();
    }

    @Test
    public void maxProbability() {
        int n = 3, start = 0, end = 2;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        double expected = 0.25000;
        double res = p.maxProbability(n, edges, succProb, start, end);
        assertEquals(expected, res, 0.00);
    }
}