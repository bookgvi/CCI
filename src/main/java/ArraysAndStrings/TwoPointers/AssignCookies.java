package ArraysAndStrings.TwoPointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/assign-cookies/">...</a>
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int p1 = 0, p2 = 0, gLen = g.length, sLen = s.length, ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (p1 < gLen && p2 < sLen) {
            if (g[p1] <= s[p2]) {
                p1 += 1;
                p2 += 1;
                ans += 1;
            } else {
                p2 += 1;
            }
        }
        return ans;
    }
}
