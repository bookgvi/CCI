package ArraysAndStrings.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/reverse-only-letters/">...</a>
 * Given a string s, reverse the string according to the following rules:
 * <p>
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * <p>
 * Return s after reversing it.
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        int len = s.length(), p1 = 0, p2 = len - 1;
        StringBuilder res = new StringBuilder(s);
        while (p1 < p2) {
            char ch1 = s.charAt(p1);
            char ch2 = s.charAt(p2);
            while (!isChar(ch1) && p1 < p2) {
                p1 += 1;
                ch1 = s.charAt(p1);
            }
            while (!isChar(ch2) && p1 < p2) {
                p2 -= 1;
                ch2 = s.charAt(p2);
            }
            if (isChar(ch1) && isChar(ch2)) {
                res.replace(p1, p1 + 1, String.valueOf(ch2));
                res.replace(p2, p2 + 1, String.valueOf(ch1));
            }
            p1 += 1;
            p2 -= 1;
        }
        return res.toString();
    }

    private boolean isChar(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
