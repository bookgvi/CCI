package TMP.leetcode;

public class NumberOfIslands {
    private int ROW, COL;

    public int numIslands(char[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        int  counter = 0;
        boolean[][] used = new boolean[ROW][COL];
        for (int r = 0; r < ROW; ++r) {
            for (int c = 0; c < COL; ++c) {
                if (grid[r][c] == '1' && !used[r][c]) {
                    ++counter;
                    dfs(r, c, grid, used);
                }
            }
        }
        return counter;
    }

    private boolean isSafe(int r, int c, char[][] grid, boolean[][] used) {
        return c < COL && c >= 0 && r < ROW && r >= 0 && !used[r][c] && grid[r][c] == '1';
    }

    private void dfs(int r, int c, char[][] grid, boolean[][] used) {
        int[] col = new int[]{-1, 0, 1, 0};
        int[] row = new int[]{0, -1, 0, 1};
        used[r][c] = true;
        for (int i = 0; i < col.length; ++i) {
            if (isSafe(r + row[i], c + col[i], grid, used)) {
                dfs(r + row[i], c + col[i], grid, used);
            }
        }
    }
}
