package graph.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfProvincesTest {

    private final NumberOfProvinces n = new NumberOfProvinces();
    @Test
    public void testFindCircleNum() {
        int[][] isConnected1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        assertEquals(2, n.findCircleNum(isConnected1));

        int[][] isConnected2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        assertEquals(3, n.findCircleNum(isConnected2));

        int[][] isConnected3 = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        assertEquals(2, n.findCircleNum(isConnected3));

        int[][] isConnected4 = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        assertEquals(1, n.findCircleNum(isConnected4));
    }

}