package TMP.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    int ROW, COL;
    boolean res;
    List<int[]> prev = new ArrayList<>();

    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;
        boolean[][] used = new boolean[ROW][COL];
        for (int row = 0; row < ROW; ++row) {
            for (int col = 0; col < COL; ++col) {
                int letterIndex = 0;
                if (isLetter(board[row][col], word, letterIndex) && !used[row][col]) {
                    backTracking(board, word, letterIndex, row, col, used);
                }
                if (res) return true;
            }
        }
        return false;
    }

    private void backTracking(char[][] board, String word, int letterIndex, int row, int col, boolean[][] used) {
        if (letterIndex == word.length()) {
            res = true;
            return;
        }
        int[] cols = {0, 0, -1, 0, 1};
        int[] rows = {0, -1, 0, 1, 0};
        for (int i = 0; i < 5; ++i) {
            if (!res && isSafe(row + rows[i], col + cols[i], used)) {
                char ch = board[row + rows[i]][col + cols[i]];
                if (isLetter(ch, word, letterIndex)) {
                    persist(row + rows[i], col + cols[i], used);
                    backTracking(board, word, letterIndex + 1, row + rows[i], col + cols[i], used);
                    revert(used);
                }
            }
        }
    }

    private void persist(int row, int col, boolean[][] used) {
        used[row][col] = true;
        prev.add(new int[]{row, col});
    }

    private void revert(boolean[][] used) {
        if (prev.isEmpty()) {
            return;
        }
        int[] prevRowCol = prev.remove(prev.size() - 1);
        used[prevRowCol[0]][prevRowCol[1]] = false;
    }

    private boolean isLetter(char ch, String word, int letterIndex) {
        return letterIndex < word.length() && word.charAt(letterIndex) == ch;
    }

    private boolean isSafe(int row, int col, boolean[][] used) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && !used[row][col];
    }
}
