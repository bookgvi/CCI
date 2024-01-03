package graph.task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SafeNodesInGraphKahnsAlgorithmTest {

    private SafeNodesInGraph_KahnsAlgorithm s = new SafeNodesInGraph_KahnsAlgorithm();
    
    @Before
    public void init() {
        s = new SafeNodesInGraph_KahnsAlgorithm();
    }

    @Test
    public void testEmptyGraph() {
        int[][] graph = new int[0][0];
        List<Integer> expected = new ArrayList<>();

        List<Integer> result = s.eventualSafeNodes(graph);

        assertEquals(expected, result);
    }

    @Test
    public void testSingleNodeGraph() {
        int[][] graph = {{}};
        List<Integer> expected = Arrays.asList(0);

        List<Integer> result = s.eventualSafeNodes(graph);

        assertEquals(expected, result);
    }

    @Test
    public void testLinearGraph() {
        int[][] graph = {{1}, {2}, {3}, {}};
        List<Integer> expected = Arrays.asList(0,1,2,3);

        List<Integer> result = s.eventualSafeNodes(graph);

        assertEquals(expected, result);
    }

    @Test
    public void testCycleGraph() {
        int[][] graph = {{1}, {2}, {0}};
        List<Integer> expected = new ArrayList<>();

        List<Integer> result = s.eventualSafeNodes(graph);

        assertEquals(expected, result);
    }

    @Test
    public void testGraph1() {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> expected = Arrays.asList(2,4,5,6);

        List<Integer> result = s.eventualSafeNodes(graph);

        assertEquals(expected, result);
    }

    @Test
    public void testGraph2() {
        int[][] graph = {{1}, {2,3}, {3}, {}};
        List<Integer> expected = Arrays.asList(0,1,2,3);

        List<Integer> result = s.eventualSafeNodes(graph);

        assertEquals(expected, result);
    }

}