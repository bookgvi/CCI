package graph.topo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


public class TopologicalSortTest {

    private TopologicalSort.TopoSort tDFS;
    private TopologicalSort.TopoSort tBFS;

    @Before
    public void init() {
        tBFS = new TopologicalSort.BFS();
        tDFS = new TopologicalSort.DFS();
    }

    @Test
    public void testTopologicalSort_SimpleDAG() {
        int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[] expected = {1, 2, 3, 4, 5};

        int[] result = tDFS.process(graph);
        result = Arrays.copyOf(result, expected.length);
        assertArrayEquals(expected, result);

        result = tBFS.process(graph);
        result = Arrays.copyOf(result, expected.length);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testTopologicalSort_MultipleValidOrderings() {
        int[][] graph = {{1, 2}, {1, 3}, {2, 4}, {3, 4}};
        int[] expected1 = {1, 2, 3, 4};
        int[] expected2 = {1, 3, 2, 4};

        int[] result = tDFS.process(graph);
        result = Arrays.copyOf(result, expected1.length);
        assertTrue(Arrays.equals(expected1, result) || Arrays.equals(expected2, result));

        result = tBFS.process(graph);
        result = Arrays.copyOf(result, expected1.length);
        assertTrue(Arrays.equals(expected1, result) || Arrays.equals(expected2, result));
    }

    @Test
    public void testTopologicalSort_Cycle() {
        int[][] graph = {{1, 2}, {2, 3}, {3, 1}};

        int[] result = tDFS.process(graph);
        assertArrayEquals(new int[]{}, result);

        result = tBFS.process(graph);
        assertArrayEquals(new int[]{}, result);
    }
}