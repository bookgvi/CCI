package ArraysAndStrings.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/merge-strings-alternately/">...</a>
 */
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int i = 1;
        int p1 = 0, p2 = 0;
        StringBuilder res = new StringBuilder();
        while (p1 < len1 && p2 < len2) {
            if ((i & 1) == 1) {
                res.append(word1.charAt(p1++));
            } else {
                res.append(word2.charAt(p2++));
            }
            i += 1;
        }
        if (p1 < len1) {
            res.append(new String(word1.toCharArray(), p1, len1 - p1));
        }
        if (p2 < len2) {
            res.append(new String(word2.toCharArray(), p2, len2 - p2));
        }
        return res.toString();
    }
}
