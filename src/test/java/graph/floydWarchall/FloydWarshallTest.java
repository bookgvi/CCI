package graph.floydWarchall;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FloydWarshallTest {

    private final int INF = Integer.MAX_VALUE >>> 1;
    private FloydWarshall converter;

    @Before
    public void init() {
         converter = new FloydWarshall();
    }

    @Test
    public void testConvertEdgesToGraph() {
        int v = 4;
        int[][] edges = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}, {3, 0, 5}};

        int[][] expectedGraph = {
                {0, 2, INF, INF},
                {INF, 0, 3, INF},
                {INF, INF, 0, 4},
                {5, INF, INF, 0}
        };

        int[][] actualGraph = converter.convertEdgesToGraph(v, edges);

        assertArrayEquals(expectedGraph, actualGraph);
    }

    @Test
    public void testFloydWarshall() {
        int[][] edges = {{0, 1, 3}, {1, 2, 2}, {2, 0, 7}};
        int[][] expectedDist = {{0, 3, 5}, {9, 0, 2}, {7, 10, 0}};

        int[][] dist = converter.floydWarshall(3, edges);

        assertArrayEquals(expectedDist, dist);
    }

    @Test
    public void testFloydWarshallWithNegativeWeights() {
        int[][] edges = {{0, 1, 3}, {1, 2, -2}, {2, 0, 7}};
        int[][] expectedDist = {{0, 3, 1}, {5, 0, -2}, {7, 10, 0}};

        int[][] dist = converter.floydWarshall(3, edges);

        assertArrayEquals(expectedDist, dist);
    }

    @Test
    public void testFloydWarshallWithDisconnectedGraph() {
        int[][] edges = {{0, 1, 3}, {2, 3, 2}};
        int[][] expectedDist = {{0, 3, INF, INF}, {INF, 0, INF, INF}, {INF, INF, 0, 2}, {INF, INF, INF, 0}};

        int[][] dist = converter.floydWarshall(4, edges);

        assertArrayEquals(expectedDist, dist);
    }

    @Test
    public void testFloydWarshallWithSingleNodeGraph() {
        int[][] edges = {};
        int[][] expectedDist = {{0}};

        int[][] dist = converter.floydWarshall(1, edges);

        assertArrayEquals(expectedDist, dist);
    }

    @Test
    public void testFloydWarshallWithNegativeCycle() {
        int[][] edges = {{0, 1, 3}, {1, 2, -2}, {2, 0, -5}};
        int[][] expectedDist = new int[][]{};

        int[][] dist = converter.floydWarshall(3, edges);

        assertArrayEquals(expectedDist, dist);
    }

    @Test
    public void testFloydWarshallWithLargeGraph() {
        int[][] edges = {
                {0, 1, 2}, {0, 2, 5}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}, {2, 4, 3}, {3, 4, 2}
        };
        int[][] expectedDist = {
                {0, 2, 3, 4, 6},
                {INF, 0, 1, 2, 4},
                {INF, INF, 0, 1, 3},
                {INF, INF, INF, 0, 2},
                {INF, INF, INF, INF, 0}
        };

        int[][] dist = converter.floydWarshall(5, edges);

        assertArrayEquals(expectedDist, dist);
    }

}