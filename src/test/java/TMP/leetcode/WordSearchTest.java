package TMP.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {
    @Test
    public void test1() {
        WordSearch w = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean res = w.exist(board, word);
        assertTrue(res);
    }
    @Test
    public void test2() {
        WordSearch w = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        boolean res = w.exist(board, word);
        assertTrue(res);
    }
    @Test
    public void test3() {
        WordSearch w = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        boolean res = w.exist(board, word);
        assertFalse(res);
    }
}