package backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/word-search/">...</a>
 */
public class WordSearch {
    private int rowLen;
    private int colLen;
    private boolean isExist = false;

    public boolean exist(char[][] board, String word) {
        rowLen = board.length;
        colLen = board[0].length;
        Vertex root = new Vertex("root", "");
        buildTree(word, root);
        for (int row = 0; row < rowLen; row += 1) {
            for (int col = 0; col < colLen; col += 1) {
                boolean[][] visited = new boolean[rowLen][colLen];
                dfs(board, row, col, root, visited);
            }
        }
        return isExist;
    }

    private void dfs(char[][] board, int row, int col, Vertex vertex, boolean[][] visited) {
        if (vertex == null || row < 0 || row >= rowLen || col < 0 || col >= colLen || visited[row][col]) {
            return;
        }
        Vertex next = vertex.next.get(board[row][col]);
        if (next == null) {
            return;
        }
        if (next.isTerminal) {
            isExist = true;
        }
        visited[row][col] = true;
        if (!isExist) dfs(board, row + 1, col, next, visited);
        if (!isExist) dfs(board, row - 1, col, next, visited);
        if (!isExist) dfs(board, row, col + 1, next, visited);
        if (!isExist) dfs(board, row, col - 1, next, visited);
        visited[row][col] = false;


    }

    private void buildTree(String word, Vertex root) {
        Vertex cur = root;
        StringBuilder suffix = new StringBuilder();
        for (char ch : word.toCharArray()) {
            suffix.append(ch);
            String label = String.valueOf(ch);
            cur.next.putIfAbsent(ch, new Vertex(label, suffix.toString()));
            cur = cur.next.get(ch);
        }
        cur.isTerminal = true;
    }

    private static class Vertex {
        String label;
        String suffix;
        Map<Character, Vertex> next = new HashMap<>();
        boolean isTerminal = false;

        Vertex(String label, String suffix) {
            this.label = label;
            this.suffix = suffix;
        }
    }
}
