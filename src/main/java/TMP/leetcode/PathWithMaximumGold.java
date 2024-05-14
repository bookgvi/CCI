package TMP.leetcode;

import java.util.Stack;

public class PathWithMaximumGold {
    private int ROW;
    private int COL;
    private boolean[][] used;
    private int result = 0;

    public int getMaximumGold(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        for (int r = 0; r < ROW; ++r) {
            for (int c = 0; c < COL; ++c) {
                used = new boolean[ROW][COL];
                Stack<Integer> stack = new Stack<>();
                backTracking(grid, r, c, 0, stack);
            }
        }
        return result;
    }

    private void backTracking(int[][] grid, int r, int c, int sum, Stack<Integer> stack) {
        int[] x = new int[]{0, -1, 1, 0, 0};
        int[] y = new int[]{0, 0, 0, 1, -1};
        for (int i = 0; i < 5; ++i) {
            if (isValid(r + y[i], c + x[i], grid)) {
                sum += calc(r + y[i], c + x[i], grid, stack);
                backTracking(grid, r + y[i], c + x[i], sum, stack);
                sum -= remove(r + y[i], c + x[i], grid, stack);
            }
        }
        result = Math.max(result, sum);
    }

    private int calc(int r, int c, int[][] grid, Stack<Integer> stack) {
        used[r][c] = true;
        stack.push(grid[r][c]);
        return grid[r][c];
    }

    private int remove(int r, int c, int[][] grid, Stack<Integer> stack) {
        used[r][c] = true;
        stack.pop();
        return grid[r][c];
    }

    private boolean isValid(int r, int c, int[][] grid) {
        return r >= 0 && r < ROW && c >= 0 && c < COL && !used[r][c] && grid[r][c] != 0;
    }
}
