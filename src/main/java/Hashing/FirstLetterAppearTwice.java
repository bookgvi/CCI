package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/first-letter-to-appear-twice/">...</a>
 * <p>
 * Given a string s consisting of lowercase English letters, return the first letter to appear twice.
 * <p>
 * Note:
 * <p>
 * A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
 * s will contain at least one letter that appears twice.
 */
public class FirstLetterAppearTwice {
    public char repeatedCharacter(String s) {
        Set<Character> charSet = new HashSet<>();
        char ch = ' ';
        for (int i = 0, len = s.length(); i < len; i += 1) {
            char chAtPos = s.charAt(i);
            if (!charSet.add(chAtPos)) {
                return chAtPos;
            }
        }
        return ch;
    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= len; i += 1) {
            set.add(i);
        }
        for (int i = 0; i < len; i += 1) {
            set.remove(i);
        }
        return set.iterator().next();
    }

}
