package backtracking;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/word-search-ii/">...</a>
 * <p>
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once in a word.
 */
public class WordSearchII_v5 {
    private int rowLen;
    private int colLen;

    public List<String> findWords(char[][] board, String[] words) {
        rowLen = board.length;
        colLen = board[0].length;
        final Vertex root = new Vertex("root", "");
        List<String> res = new ArrayList<>();
        for (String word : words) {
            buildBor(word, root);
        }
        for (int row = 0; row < rowLen; row += 1) {
            for (int col = 0; col < colLen; col += 1) {
                boolean[][] visited = new boolean[rowLen][colLen];
                dfs(board, row, col, root, res, visited);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col, Vertex cur, List<String> res, boolean[][] visited) {
        if (cur == null || row < 0 || row >= rowLen || col < 0 || col >= colLen || visited[row][col]) {
            return;
        }

        Vertex next = cur.next.get(board[row][col]);
        if (next == null) {
            return;
        }
        if (next.isTerminal && !next.suffix.isEmpty()) {
            res.add(next.suffix);
            next.suffix = "";
        }
        visited[row][col] = true;
        dfs(board, row + 1, col, next, res, visited);
        dfs(board, row - 1, col, next, res, visited);
        dfs(board, row, col + 1, next, res, visited);
        dfs(board, row, col - 1, next, res, visited);
        visited[row][col] = false;
    }

    private void buildBor(String word, Vertex root) {
        Vertex cur = root;
        StringBuilder w = new StringBuilder();
        for (Character ch : word.toCharArray()) {
            w.append(ch);
            String suffix = w.toString();
            String label = String.valueOf(ch);
            cur.next.putIfAbsent(ch, new Vertex(label, suffix));
            cur = cur.next.get(ch);
        }
        cur.isTerminal = true;
    }

    private static class Vertex {
        String label;
        String suffix;
        Map<Character, Vertex> next;
        boolean isVisited = false;
        boolean isTerminal = false;

        Vertex(String label, String suffix) {
            this.label = label;
            this.suffix = suffix;
            this.next = new HashMap<>();
        }
    }
}