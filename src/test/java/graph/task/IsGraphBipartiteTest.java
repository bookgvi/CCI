package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsGraphBipartiteTest {

    private IsGraphBipartite i = new IsGraphBipartite();

    @Before
    public void init() {
        i = new IsGraphBipartite();
    }

    @Test
    public void testIsBipartite() {
        // Test case 1: Empty graph
        int[][] graph1 = {};
        assertFalse(i.isBipartite(graph1));
    }

    @Test
    public void testIsBipartite2() {
        // Test case 2: Bipartite graph
        int[][] graph2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        assertTrue(i.isBipartite(graph2));
    }

    @Test
    public void testIsBipartite3() {
        // Test case 3: Non-bipartite graph
        int[][] graph3 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        assertFalse(i.isBipartite(graph3));
    }

}