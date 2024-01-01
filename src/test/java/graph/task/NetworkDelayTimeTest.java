package graph.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class NetworkDelayTimeTest {

    private final NetworkDelayTime ndt = new NetworkDelayTime();

    @Test
    public void testNetworkDelayTime7() {
        int[][] times = {{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};
        int n = 5;
        int k = 5;
        int expected = 31;
        int result = ndt.networkDelayTime(times, n, k);
        assertEquals(expected, result);
    }

    @Test
    public void testNetworkDelayTime6() {
        int[][] times = {{1,2,1}, {2,1,3}};
        int n = 2;
        int k = 2;
        int expected = 3;
        int result = ndt.networkDelayTime(times, n, k);
        assertEquals(expected, result);
    }

    @Test
    public void testNetworkDelayTime5() {
        int[][] times = {{2,1,1}, {2, 3, 1}, {4,3,1}};
        int n = 4;
        int k = 2;
        int expected = -1;
        int result = ndt.networkDelayTime(times, n, k);
        assertEquals(expected, result);
    }

    @Test
    public void testNetworkDelayTime4() {
        int[][] times = {{1,2,1}};
        int n = 2;
        int k = 2;
        int expected = -1;
        int result = ndt.networkDelayTime(times, n, k);
        assertEquals(expected, result);
    }

    @Test
    public void testNetworkDelayTime3() {
        int[][] times = {{1,2,1}};
        int n = 2;
        int k = 1;
        int expected = 1;
        int result = ndt.networkDelayTime(times, n, k);
        assertEquals(expected, result);
    }

    @Test
    public void testNetworkDelayTime2() {
        int[][] times = {{2,1,1}, {2, 3, 1}, {3,4,1}};
        int n = 4;
        int k = 2;
        int expected = 2;
        int result = ndt.networkDelayTime(times, n, k);
        assertEquals(expected, result);
    }

    @Test
    public void testNetworkDelayTime() {
        int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}};
        int n = 3;
        int k = 1;
        int expected = 3;
        int result = ndt.networkDelayTime(times, n, k);
        assertEquals(expected, result);
    }

    @Test
    public void testNetworkDelayTimeEmptyTimes() {
        int[][] times = {};
        int n = 1;
        int k = 1;
        int expected = -1;
        int result = ndt.networkDelayTime(times, n, k);
        assertEquals(expected, result);
    }

    @Test
    public void testNetworkDelayTimeSingleNode() {
        int[][] times = {};
        int n = 1;
        int k = 1;
        int expected = -1;
        int result = ndt.networkDelayTime(times, n, k);
        assertEquals(expected, result);
    }

}