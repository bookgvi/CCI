package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * <a href="https://leetcode.com/problems/word-search-ii/">...</a>
 * <p>
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once in a word.
 */
public class WordSearchII_v6 {
    private final ConcurrentMap<Integer, Future<List<String>>> cache = new ConcurrentHashMap<>();
    private int rowLen;
    private int colLen;

    public List<String> findWords(char[][] board, String[] words) {
        rowLen = board.length;
        colLen = board[0].length;
        List<String> res = new ArrayList<>();
        final Vertex root = new Vertex("root", "");
        for (String word : words) {
            buildBor(word, root);
        }
        for (int row = 0; row < rowLen; row += 1) {
            for (int col = 0; col < colLen; col += 1) {
                int divider = row < 10 ? 10 : 100;
                Future<List<String>> f = cache.get(row * divider + col);
                if (f == null) {
                    int finalRow = row;
                    int finalCol = col;
                    FutureTask<List<String>> ft = new FutureTask<>(() -> {
                        boolean[][] visited = new boolean[rowLen][colLen];
                        List<String> tmpRes = new ArrayList<>();
                        dfs(board, finalRow, finalCol, root, tmpRes, visited);
                        return tmpRes;
                    });
                    f = cache.putIfAbsent(row * divider + col, ft);
                    if (f == null) {
                        f = ft;
                        ft.run();
                    }
                }
                try {
                    res.addAll(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
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