package ArraysAndStrings.TwoPointers;

public class Palindrome {
    public boolean isStringPalindrome(String str) {
        if (str == null || str.length() < 1) {
            return false;
        }
        int len = str.length();
        int p1 = 0, p2 = len - 1;
        while(p1 < p2) {
            if (str.charAt(p1) != str.charAt(p2)) {
                return false;
            }
            p1 += 1;
            p2 -= 1;
        }
        return true;
    }
}
