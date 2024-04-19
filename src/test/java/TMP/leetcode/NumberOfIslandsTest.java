package TMP.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfIslandsTest {

    @Test
    public void numIslands1() {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int res = n.numIslands(grid);
        assertEquals(1, res);
    }

    @Test
    public void numIslands2() {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int res = n.numIslands(grid);
        assertEquals(3, res);
    }
}