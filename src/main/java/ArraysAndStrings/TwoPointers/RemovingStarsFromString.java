package ArraysAndStrings.TwoPointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/removing-stars-from-a-string/">...</a>
 * <p>
 * You are given a string s, which contains stars *.
 * <p>
 * In one operation, you can:
 * <p>
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * <p>
 * Note:
 * <p>
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 */
public class RemovingStarsFromString {
    /*
    * O(n)
    * */
    public String removeStarsTP(String s) {
        int len = s.length(), p = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i += 1) {
            char ch = chars[i];
            if (ch == '*') {
                p -= 1;
            } else {
                chars[p++] = ch;
            }
        }
        return new String(chars, 0, p);
    }

    /*
    * O(n2)
    * */
    public String removeStars(String s) {
        int p1 = 0, p2 = 1;
        StringBuilder sb = new StringBuilder(s);
        while (p2 < sb.length()) {
            while (p2 < sb.length() && sb.charAt(p2) == '*') {
                sb.deleteCharAt(p1--);
                sb.deleteCharAt(--p2);
            }
            p2 += 1;
            p1 += 1;
        }
        return sb.toString();
    }
}
