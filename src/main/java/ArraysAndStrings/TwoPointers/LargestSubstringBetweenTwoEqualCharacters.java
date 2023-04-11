package ArraysAndStrings.TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/largest-substring-between-two-equal-characters/">...</a>
 * <p>
 * Given a string s, return the length of the longest substring between two equal characters, excluding the two characters.
 * If there is no such substring return -1.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 */
public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1, len = s.length();
        Map<Character, Pair<Integer, Integer>> charToDistanceMap = new HashMap<>();
        for (int i = 0; i < len; i += 1) {
            Pair<Integer, Integer> indexes = charToDistanceMap.getOrDefault(s.charAt(i), new Pair<>(i, -1));
            if (indexes.getSecond() < i) {
                indexes.setSecond(i);
            }
            charToDistanceMap.put(s.charAt(i), indexes);
        }
        for (Map.Entry<Character, Pair<Integer, Integer>> entry : charToDistanceMap.entrySet()) {
                res = Math.max(res, entry.getValue().getSecond() - entry.getValue().getFirst() - 1);
        }
        return res;
    }

    private class Pair<U, V> {
        private U first;
        private V second;

        Pair(U f, V s) {
            this.first = f;
            this.second = s;
        }

        public U getFirst() {
            return first;
        }

        public void setFirst(U first) {
            this.first = first;
        }

        public V getSecond() {
            return second;
        }

        public void setSecond(V second) {
            this.second = second;
        }
    }
}
