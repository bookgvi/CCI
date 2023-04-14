package ArraysAndStrings.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/3sum-closest/">...</a>
 * <p>
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length, p1, p2, sum, delta, ans = Integer.MAX_VALUE;
        Map<Integer, Integer> distToSumMap = new HashMap<>();
        for (int i = 0; i < len; i += 1) {
            p1 = i + 1;
            p2 = len - 1;
            while (p1 < p2) {
                sum = nums[i] + nums[p1] + nums[p2];
                delta = Math.abs(target - sum);
                distToSumMap.put(delta, sum);
                ans = Math.min(ans, delta);
                if (sum > target) {
                    p2 -= 1;
                } else if (sum < target) {
                    p1 += 1;
                } else {
                    return sum;
                }
            }
        }

        return distToSumMap.get(ans);
    }

}
