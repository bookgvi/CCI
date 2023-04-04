package ArraysAndStrings.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">...</a>
 * <p>
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace
 * and initial word order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsStringIII {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0, len = words.length; i < len; i += 1) {
            words[i] = reverse(words[i]);
        }
        return String.join(" ", words);
    }

    private String reverse(String word) {
        char[] strArr = word.toCharArray();
        int p1 = 0, p2 = word.length() - 1;
        while(p1 < p2) {
            char lastCh = strArr[p2];
            strArr[p2] = strArr[p1];
            strArr[p1] = lastCh;
            p1 += 1;
            p2 -= 1;
        }
        return new String(strArr);
    }
}
