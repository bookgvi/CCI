package ArraysAndStrings.TwoPointers;

public class Substring {
    public boolean processed(String str, String subStr) {
        int p1 = 0, p2 = 0, strLen = str.length(), subStrLen = subStr.length();
        while(p1 < strLen && p2 < subStrLen) {
            if (str.charAt(p1) == subStr.charAt(p2)) {
                p2 += 1;
            }
            p1 += 1;
        }
        return p2 == subStrLen;
    }
}
