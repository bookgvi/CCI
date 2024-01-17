package graph.task;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MinimumNumberVerticesReachAllNodesTest implements ListTests {

    private MinimumNumberVerticesReachAllNodes m;

    @Before
    public void setUp() throws Exception {
        m = new MinimumNumberVerticesReachAllNodes();
    }

    @Test
    public void findSmallestSetOfVertices() {
        int n = 6;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 2),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4),
                Arrays.asList(4, 2)
        );
        List<Integer> expected = Arrays.asList(0,3);

        List<Integer> res = m.findSmallestSetOfVertices(n, edges);
        assertListEquals(expected, res);
    }
}