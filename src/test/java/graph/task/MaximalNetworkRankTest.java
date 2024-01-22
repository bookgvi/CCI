package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximalNetworkRankTest {

    private MaximalNetworkRank m;

    @Before
    public void setUp() throws Exception {
        m = new MaximalNetworkRank();
    }

    @Test
    public void maximalNetworkRank() {
        int n = 4, roads[][] = {{0,1},{0,3},{1,2},{1,3}};
        int expected = 4;
        int res = m.maximalNetworkRank(n, roads);
        assertEquals(expected, res);
    }

    @Test
    public void maximalNetworkRank2() {
        int n = 5, roads[][] = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};
        int expected = 5;
        int res = m.maximalNetworkRank(n, roads);
        assertEquals(expected, res);
    }
}