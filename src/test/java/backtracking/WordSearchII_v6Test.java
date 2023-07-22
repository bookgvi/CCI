package backtracking;

// LeetCode test cases

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

//        [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
//        ["oath","pea","eat","rain"]
//        [["a","b"],["c","d"]]
//        ["abcb"]
//        [["a","b","c"],["a","e","d"],["a","f","g"]]
//        ["abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"]
//        [["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]
//        ["oa","oaa"]
//        [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
//        ["oath","pea","eat","rain","hklf", "hf"]
//        [["a","b"],["c","d"]]
//        ["ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"]
//        [["d","c","e","b","d","e","d","a"],["c","a","e","a","d","d","e","e"],["a","c","e","d","b","c","c","b"],["c","b","a","a","a","e","e","e"],["a","e","d","e","b","d","d","e"],["a","a","d","c","e","a","d","e"],["b","d","e","b","b","b","c","e"],["d","a","e","e","b","e","b","d"],["b","b","c","a","b","b","b","a"],["a","c","b","a","c","a","d","d"]]
//        ["ab","bddbebcba","ededa","daebeda","edecaeabc","cbeedad","bcaaecb","c","eb","aadbdbacee","dcaaba"]
//
//
public class WordSearchII_v6Test {
    @Test
    public void findWords_test1() {
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String[] words = {"ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb"};
        List<String> ans = Arrays.stream(new String[]{"ab", "ac", "bd", "ca", "db"}).collect(Collectors.toList());
        WordSearchII_v6 f = new WordSearchII_v6();
        f.findWords(board, words);
    }

    @Test
    public void findWords_test2() {
        char[][] board = {{'d', 'c', 'e', 'b', 'd', 'e', 'd', 'a'}, {'c', 'a', 'e', 'a', 'd', 'd', 'e', 'e'}, {'a', 'c', 'e', 'd', 'b', 'c', 'c', 'b'}, {'c', 'b', 'a', 'a', 'a', 'e', 'e', 'e'}, {'a', 'e', 'd', 'e', 'b', 'd', 'd', 'e'}, {'a', 'a', 'd', 'c', 'e', 'a', 'd', 'e'}, {'b', 'd', 'e', 'b', 'b', 'b', 'c', 'e'}, {'d', 'a', 'e', 'e', 'b', 'e', 'b', 'd'}, {'b', 'b', 'c', 'a', 'b', 'b', 'b', 'a'}, {'a', 'c', 'b', 'a', 'c', 'a', 'd', 'd'}};
        String[] words = {"ab", "bddbebcba", "ededa", "daebeda", "edecaeabc", "cbeedad", "bcaaecb", "c", "eb", "aadbdbacee", "dcaaba"};
        List<String> ans = Arrays.stream(new String[]{"c", "eb", "ededa", "ab", "daebeda"}).collect(Collectors.toList());
        WordSearchII_v6 f = new WordSearchII_v6();
        f.findWords(board, words);
    }

    @Test
    public void findWords_test3() {
        char[][] board = {{'d', 'c', 'e', 'b', 'd', 'e', 'd', 'a'}, {'c', 'a', 'e', 'a', 'd', 'd', 'e', 'e'}, {'a', 'c', 'e', 'd', 'b', 'c', 'c', 'b'}, {'c', 'b', 'a', 'a', 'a', 'e', 'e', 'e'}, {'a', 'e', 'd', 'e', 'b', 'd', 'd', 'e'}, {'a', 'a', 'd', 'c', 'e', 'a', 'd', 'e'}, {'b', 'd', 'e', 'b', 'b', 'b', 'c', 'e'}, {'d', 'a', 'e', 'e', 'b', 'e', 'b', 'd'}, {'b', 'b', 'c', 'a', 'b', 'b', 'b', 'a'}, {'a', 'c', 'b', 'a', 'c', 'a', 'd', 'd'}};
        String[] words = {"ededa", "ab", "daebeda"};
        List<String> ans = Arrays.stream(new String[]{"ededa", "ab", "daebeda"}).collect(Collectors.toList());
        WordSearchII_v6 f = new WordSearchII_v6();
        f.findWords(board, words);
    }

    @Test
    public void findWords_test4() {
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String[] words = {"bd", "db"};
        List<String> ans = Arrays.stream(new String[]{"ab", "ac", "bd", "ca", "db"}).collect(Collectors.toList());
        WordSearchII_v6 f = new WordSearchII_v6();
        f.findWords(board, words);
    }

    @Test
    public void findWords_test5() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain", "rat", "vrena", "oaoa"};
        WordSearchII_v6 f = new WordSearchII_v6();
        f.findWords(board, words);
    }

    @Test
    public void findWords_test6() {
        char[][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String[] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
        List<String> ans = Arrays.stream(new String[]{"abcdefg","befa","eaabcdgfa","gfedcbaaa"}).collect(Collectors.toList());
        WordSearchII_v6 f = new WordSearchII_v6();
        List<String> res = f.findWords(board, words);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void set_test() {
        Set<Integer> set = new HashSet<>();
        for (int i : new int[]{2,3,1}) {
            set.add(i);
        }
        Set<String> c = Collections.synchronizedSet(new LinkedHashSet<>());
    }
}
