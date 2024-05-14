package TMP.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathWithMaximumGoldTest {
    @Test
    public void test1() {
        PathWithMaximumGold p = new PathWithMaximumGold();
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        int ans = 24;
        int res = p.getMaximumGold(grid);
        assertEquals(ans, res);
    }
}