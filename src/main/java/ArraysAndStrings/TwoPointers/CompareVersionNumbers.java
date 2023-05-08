package ArraysAndStrings.TwoPointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/compare-version-numbers/">...</a>
 * Given two version numbers, version1 and version2, compare them.
 * <p>
 * Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may
 * contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right,
 * with the leftmost revision being revision 0, the next revision being revision 1, and so on.
 * For example 2.5.33 and 0.1 are valid version numbers.
 * <p>
 * To compare version numbers, compare their revisions in left-to-right order.
 * Revisions are compared using their integer value ignoring any leading zeros.
 * This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index,
 * then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same,
 * but their revision 1s are 0 and 1 respectively, and 0 < 1.
 * <p>
 * Return the following:
 * <p>
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length(), p1 = 0, p2 = 0;
        int i1 = 0;
        int i2 = 0;
        int res = 0;
        while (p1 < len1 || p2 < len2) {
            Integer quantum1;
            int quantum2;
            char[] digits1 = new char[501];
            char[] digits2 = new char[501];
            while (p1 < len1 && version1.charAt(p1) != '.' || p2 < len2 && version2.charAt(p2) != '.') {
                if (p1 < len1 && version1.charAt(p1) != '.') {
                    char ch1 = version1.charAt(p1);
                    digits1[i1++] = ch1;
                    p1 += 1;
                }
                if (p2 < len2 && version2.charAt(p2) != '.') {
                    char ch2 = version2.charAt(p2);
                    digits2[i2++] = ch2;
                    p2 += 1;
                }
            }
            char[] digits1Cut = Arrays.copyOf(digits1, i1);
            char[] digits2Cut = Arrays.copyOf(digits2, i2);
            quantum1 = Integer.valueOf(new String(digits1Cut.length > 0 ? digits1Cut : new char[]{'0'}));
            quantum2 = Integer.parseInt(new String(digits2Cut.length > 0 ? digits2Cut : new char[]{'0'}));
            res = quantum1.compareTo(quantum2);
            if (res != 0) {
                return res;
            }
            i1 = 0;
            i2 = 0;
            p1 += 1;
            p2 += 1;
        }
        return res;
    }

    //WRONG!!!
    public int compareVersion1(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length(), p1 = 0, p2 = 0;
        int relPos1 = 0, relPos2 = 0;
        int res = 0;
        while (p1 < len1 || p2 < len2) {
            char ch1 = p1 < len1 ? version1.charAt(p1) : '0';
            char ch2 = p2 < len2 ? version2.charAt(p2) : '0';
            if (p1 < len1 && relPos1 == 0 && ch1 == '0') {
                while (p1 < len1 && version1.charAt(p1) == '0') {
                    p1 += 1;
                }
                if (p1 < len1) {
                    ch1 = version1.charAt(p1) == '.' ? '0' : version1.charAt(p1);
                }
                relPos1 = 1;
            }
            if (p2 < len2 && relPos2 == 0 && ch2 == '0') {
                while (p2 < len1 && version2.charAt(p2) == '0') {
                    p2 += 1;
                }
                if (p2 < len2) {
                    ch2 = version2.charAt(p2) == '.' ? '0' : version2.charAt(p2);
                }
                relPos2 = 1;
            }
            if (ch1 == '.' && p1 + 1 < len1) {
                relPos1 = -1;
            }
            if (ch2 == '.' && p2 + 1 < len2) {
                relPos2 = -1;
            }
            if (ch1 != '.' && ch2 != '.' && relPos1 != -1 && relPos2 != -1) {
                res = Character.compare(ch1, ch2);
            }
            if (res != 0) {
                return res < 0 ? -1 : 1;
            }
            p1 += 1;
            p2 += 1;
            relPos1 += 1;
            relPos2 += 1;
        }
        return res;
    }
}
