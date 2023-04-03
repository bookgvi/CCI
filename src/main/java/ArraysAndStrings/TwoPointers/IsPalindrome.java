package ArraysAndStrings.TwoPointers;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        s = sanitizeStr(s);
        int p1 = 0, len = s.length(), p2 = len - 1;
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return false;
            }
            p1 += 1;
            p2 -= 1;
        }
        return true;
    }

    private String sanitizeStr(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = s.length(); i < len; i += 1) {
            if (validate(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    private boolean validate(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
