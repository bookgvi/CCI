package graph.task.detectCycle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetectCycleDJSTest {

    private DetectCycleDJS d;
    
    @Before
    public void init() {
        d = new DetectCycleDJS();
    }

    @Test
    public void testHasCycle_GraphWithCycle_ReturnsTrue() {
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        assertTrue(d.hasCycle(n, edges));
    }

    @Test
    public void testHasCycle_GraphWithoutCycle_ReturnsFalse() {
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        assertFalse(d.hasCycle(n, edges));
    }

    @Test
    public void testHasCycle_GraphWithSelfLoop_ReturnsTrue() {
        int n = 3;
        int[][] edges = {{0, 0}, {0, 1}, {1, 2}};
        assertTrue(d.hasCycle(n, edges));
    }

    @Test
    public void testHasCycle_GraphWithMultipleCycles_ReturnsTrue() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}, {2, 4}};
        assertTrue(d.hasCycle(n, edges));
    }

    @Test
    public void testHasCycle1() {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {4, 3}, {2, 1}};
        assertFalse("DJS is not implemented for direct graph!!!", d.hasCycle(n, edges));
    }

}