package ArraysAndStrings.TwoPointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/string-compression/">...</a>
 */
public class StringCompression {
    public int compress(char[] chars) {
        int p = 1, len = chars.length, counter = 1, q = 1;
        for (int i = 1; i < len; i += 1) {
            if (chars[i - 1] == chars[i]) {
                counter += 1;
            } else {
                q = counter;
                counter = 1;
            }
            if (counter <= 1) {
                if (q > 1) {
                    char[] qChars = String.valueOf(q).toCharArray();
                    for (char ch : qChars) {
                        chars[p++] = ch;
                    }
                }
                chars[p++] = chars[i];
            }
        }
        if (counter > 1) {
            char[] cChars = String.valueOf(counter).toCharArray();
            for (char ch : cChars) {
                chars[p++] = ch;
            }
        }

        return Arrays.copyOf(chars, p).length;
    }

}
