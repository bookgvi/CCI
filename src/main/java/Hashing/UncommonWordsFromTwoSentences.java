package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/uncommon-words-from-two-sentences/">...</a>
 * A sentence is a string of single-space separated words where each word consists only of lowercase letters.
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
 */
public class UncommonWordsFromTwoSentences {
    private final int mod = (int) 1e9 + 7;
    private final int k = (int) 1e5 + 5;
    private final int[] pows = pows();
    private final Map<Integer, String> hashToStringMap = new HashMap<>();

    public String[] uncommonFromSentences1(String s1, String s2) {
        String s = s1 + " " + s2;
        String[] strArr = s.split(" ");
        int[] hashes = new int[strArr.length];
        int i = 0;
        for (String str : strArr) {
            hashes[i++] = getHashAnsSaveToHashToStringMap(str);
        }
        int[] uniqueHashes = getUnique(hashes);
        String[] ans = new String[uniqueHashes.length];
        i = 0;
        for (Integer hash : uniqueHashes) {
            ans[i++] = hashToStringMap.get(hash);
        }
        return ans;
    }

    private int[] getUnique(int[] nums) {
        int len = nums.length, p1 = 0;
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int p2 = 0; p2 < len; p2 += 1) {
            numToCountMap.put(nums[p2], numToCountMap.containsKey(nums[p2]) ? numToCountMap.get(nums[p2]) + 1 : 1);
        }
        int[] ans = new int[len];
        for (Map.Entry<Integer, Integer> entry : numToCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                ans[p1++] = entry.getKey();
            }
        }
        return Arrays.copyOf(ans, p1);
    }

    private int getHashAnsSaveToHashToStringMap(String s) {
        int len = s.length();
        int hash = (s.charAt(0) - 'a' + 1) * pows[0] % mod;
        for (int i = 1; i < len; i += 1) {
            hash = (hash + (s.charAt(i) - 'a' + 1) * pows[i]) % mod;
        }
        hashToStringMap.put(hash, s);
        return hash;
    }

    private int[] pows() {
        int[] pows = new int[k];
        pows[0] = 1;
        for (int i = 1; i < k; i += 1) {
            pows[i] = pows[i - 1] * k % mod;
        }
        return pows;
    }

    private int modPow(int n, int pow) {
        int ans = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans = ans * n % mod;
            }
            n = n * n % mod;
            pow >>= 1;
        }
        return ans;
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> strToCounterMap = new HashMap<>();
        String[] strArr = (s1 + " " + s2).split(" ");
        for (String s : strArr) {
            strToCounterMap.put(s, strToCounterMap.containsKey(s) ? strToCounterMap.get(s) + 1 : 1);
        }
        String[] ans = new String[strToCounterMap.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : strToCounterMap.entrySet()) {
            if (entry.getValue() == 1) {
                ans[i++] = entry.getKey();
            }
        }
        return Arrays.copyOf(ans, i);
    }
}
