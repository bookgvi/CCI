package twoPointers;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/longest-string-chain/?envType=daily-question&envId=2023-09-23">...</a>
 * <p>
 * You are given an array of words where each word consists of lowercase English letters.
 * <p>
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without
 * changing the order of the other characters to make it equal to wordB.
 * <p>
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2,
 * word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 * <p>
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 */
public class LongestStringChain {
    Map<String, Set<String>> chainMap = new HashMap<>();
    List<String> orderedWordsInChain = new ArrayList<>();
    String startChainWord = "";
    int maxSize = 1;

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int i = 0, len = words.length;
        for (String word : words) {
            if (maxSize >= len - i + 1) {
                break;
            }

            startChainWord = word;
            Set<String> chain = new HashSet<>();
            chain.add(startChainWord);
            chainMap.put(startChainWord, chain);
            orderedWordsInChain = new ArrayList<>();
            orderedWordsInChain.add(startChainWord);

            backtracking(startChainWord, words, 1, len);
            i += 1;
        }
        return maxSize;
    }

    public void backtracking(String w1, String[] words, int p, int len) {
        for (; p < len; p += 1) {
            String w2 = words[p];
            if (isWordValid(w1, w2)) {
                w1 = storeWordToChain(w2);
                backtracking(w1, words, p + 1, len);
                String prevLetter = removePrevWordInChain();
                w1 = Objects.equals("", prevLetter) ? w1 : prevLetter;
            }
        }
        int size = chainMap.get(startChainWord) != null ? chainMap.get(startChainWord).size() : 0;
        maxSize = Math.max(maxSize, size);
    }

    private String removePrevWordInChain() {
        int size = orderedWordsInChain.size();
        if (size > 0) {
            String word = orderedWordsInChain.remove(size - 1);
            Set<String> chain = chainMap.get(startChainWord);
            chain.remove(word);
        }
        return orderedWordsInChain.size() > 0 ?  orderedWordsInChain.get(orderedWordsInChain.size() - 1) : "";
    }

    private String storeWordToChain(String w2) {
        orderedWordsInChain.add(w2);
        Set<String> chain = chainMap.getOrDefault(startChainWord, new HashSet<>());
        chain.add(w2);
        chainMap.putIfAbsent(startChainWord, chain);
        return w2;
    }

    private boolean isWordValid(String w1, String w2) {
        return getChainOfTwoWords(w1, w2).size() == 2;
    }

    /**
     * Create chain or empty array
     *
     * @param w1 - first word
     * @param w2 - seconf word
     * @return array of this word if first word is predecessor of second word or empty collection
     */
    private Set<String> getChainOfTwoWords(String w1, String w2) {
        Set<String> res = new HashSet<>();
        res.add(w1);
        int len1 = w1.length(), len2 = w2.length();
        if (len2 - len1 > 1) {
            return res;
        }
        int p1 = 0, p2 = 0;
        while (p1 < len1 && p2 < len2) {
            if (w1.charAt(p1) == w2.charAt(p2)) {
                p1 += 1;
            }
            p2 += 1;
        }
        if (p1 == len1) {
            res.add(w2);
        }
        return res;
    }
}
