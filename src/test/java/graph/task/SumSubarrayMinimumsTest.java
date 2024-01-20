package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumSubarrayMinimumsTest {

    private SumSubarrayMinimums s;

    @Before
    public void setUp() throws Exception {
        s = new SumSubarrayMinimums();
    }

    @Test
    public void sumSubarrayMins() {
        int[] arr = {3,1,2,4};
        int expected = 17;
        int res = s.sumSubarrayMins(arr);
        assertEquals(expected, res);
    }

    @Test
    public void sumSubarrayMins2() {
        int[] arr = {4,3,2,1};
        int expected = 20;
        int res = s.sumSubarrayMins(arr);
        assertEquals(expected, res);
    }

    @Test
    public void sumSubarrayMins3() {
        int[] arr = {2,3,1,5,4};
        int expected = 20;
        int res = s.sumSubarrayMins(arr);
        assertEquals(expected, res);
    }
}