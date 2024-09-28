package trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AhoCorasickTest {

    @Test
    public void searchWordsTest1() {
        String[] keyWords = {"he", "she"};
        String text = "She has hershenock";
        AhoCorasick trie = new AhoCorasick(keyWords);
        Map<String, List<Integer>> res = trie.searchWords(text);
        Assert.assertEquals(1, res.getOrDefault("she", new ArrayList<>()).size());
        Assert.assertEquals(3, res.getOrDefault("he", new ArrayList<>()).size());
    }

    @Test
    public void searchWordsTest2() {
        String[] keyWords = {"he", "she"};
        String text = "She has me";
        AhoCorasick trie = new AhoCorasick(keyWords);
        Map<String, List<Integer>> res = trie.searchWords(text);
        Assert.assertEquals(0, res.getOrDefault("she", new ArrayList<>()).size());
        Assert.assertEquals(1, res.getOrDefault("he", new ArrayList<>()).size());
    }

    @Test
    public void searchWordsTest3() {
        String[] keyWords = {};
        String text = "She has me";
        AhoCorasick trie = new AhoCorasick(keyWords);
        Map<String, List<Integer>> res = trie.searchWords(text);
        Assert.assertEquals(0, res.size());
    }

    @Test
    public void searchWordsTest4() {
        String[] keyWords = {};
        String text = "";
        AhoCorasick trie = new AhoCorasick(keyWords);
        Map<String, List<Integer>> res = trie.searchWords(text);
        Assert.assertEquals(0, res.size());
    }

    @Test
    public void searchWordsTest5() {
        String[] keyWords = {"test"};
        AhoCorasick trie = new AhoCorasick(keyWords);
        Map<String, List<Integer>> res = trie.searchWords(null);
        Assert.assertEquals(0, res.size());
    }

    @Test
    public void searchWordsTest6() {
        AhoCorasick trie = new AhoCorasick(null);
        Map<String, List<Integer>> res = trie.searchWords(null);
        Assert.assertEquals(0, res.size());
    }
}