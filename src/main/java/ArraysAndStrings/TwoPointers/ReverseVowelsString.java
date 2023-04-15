package ArraysAndStrings.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">...</a>
 */
public class ReverseVowelsString {
    public String reverseVowels(String s) {
        int[] vowels = new int[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

        int len = s.length(), p1 = 0, p2 = len - 1;
        char[] strChars = s.toCharArray();
        while (p1 < p2) {
            boolean isChAtP1isVowel = isVowel(vowels, s.charAt(p1));
            boolean isChAtP2isVowel = isVowel(vowels, s.charAt(p2));
            if (!isChAtP1isVowel) {
                p1 += 1;
            }
            if (!isChAtP2isVowel) {
                p2 -= 1;
            }
            if (isChAtP1isVowel && isChAtP2isVowel) {
                char tmp = s.charAt(p1);
                strChars[p1] = s.charAt(p2);
                strChars[p2] = tmp;
                p1 += 1;
                p2 -= 1;
            }
        }
        return new String(strChars);
    }

    private boolean isVowel(int[] chars, char ch) {
        int l = 0, r = chars.length - 1;
        while (l < r) {
            int mid = (r + l) >>> 1;
            if (chars[mid] == ch) {
                return true;
            }
            if (chars[mid] < ch) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return chars[l] == ch || chars[r] == ch;
    }
}
