package graph.task;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class MinimumHeightTreesTest {

    private MinimumHeightTrees mht = new MinimumHeightTrees();

    @Before
    public void init() {
        mht = new MinimumHeightTrees();
    }

    @Test
    public void testFindMinHeightTrees() {

        // Test case 1: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> result1 = mht.findMinHeightTrees(4, edges1);
        List<Integer> expected1 = Arrays.asList(1);
        Assertions.assertEquals(expected1, result1);
    }

    @Test
    public void testFindMinHeightTrees2() {
        // Test case 2: n = 6, edges = [[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]]
        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        List<Integer> result2 = mht.findMinHeightTrees(6, edges2);
        List<Integer> expected2 = Arrays.asList(3, 4);
        Assertions.assertEquals(expected2, result2);

        // Add more test cases as needed
    }
}