package backtracking;

import org.junit.Assert;
import org.junit.Test;

public class WordSearchTest {

    @Test
    public void exist_test1() {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        WordSearch w = new WordSearch();
        boolean res = w.exist(board, word);
        Assert.assertTrue(res);
    }
}