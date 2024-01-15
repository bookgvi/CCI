package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReorderRoutesMakeAllPathsLeadCityZeroFlipNodeTest {

    private ReorderRoutesMakeAllPathsLeadCityZero_FlipEdge r;

    @Before
    public void setUp() throws Exception {
        r = new ReorderRoutesMakeAllPathsLeadCityZero_FlipEdge();
    }

    @Test
    public void minReorder1() {
        int n = 6; 
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int expected = 3;

        int res = r.minReorder(n, connections);
        assertEquals(expected, res);
    }

    @Test
    public void minReorder2() {
        int n = 5;
        int[][] connections = {{1,0},{1,2},{2,3},{4,2}};
        int expected = 2;

        int res = r.minReorder(n, connections);
        assertEquals(expected, res);
    }
}