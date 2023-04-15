package ArraysAndStrings.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">...</a>
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length, p1 = 0, p2 = len - 1, ans = Integer.MIN_VALUE;
        while(p1 < p2) {
            int curAns = (p2 - p1) * Math.min(height[p2], height[p1]);
            ans = Math.max(ans, curAns);
            if (height[p2] > height[p1]) {
                p1 += 1;
            } else {
                p2 -= 1;
            }
        }
        return ans;
    }
}
