package backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordSearchII_v2Test {

    @Test
    public void findWords_test1() {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain", "rat","vrena", "oaoa"};
        WordSearchII_v2 f = new WordSearchII_v2();
        f.findWords(board, words);
    }

    @Test
    public void findWords_test2() {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oaoa"};
        WordSearchII_v2 f = new WordSearchII_v2();
        f.findWords(board, words);
    }

    @Test
    public void findWords_test3() {
        char[][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String[] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
        List<String> ans = Arrays.stream(new String[]{"abcdefg","befa","eaabcdgfa","gfedcbaaa"}).collect(Collectors.toList());
        WordSearchII_v2 f = new WordSearchII_v2();
        List<String> res = f.findWords(board, words);
        Assert.assertEquals(ans, res);
    }

}