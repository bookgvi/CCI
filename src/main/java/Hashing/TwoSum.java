package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/">...</a>
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        int[] ans = new int[2];
        for (int i1 = 0, len = nums.length; i1 < len; i1 += 1) {
            Integer i2 = numToIndexMap.get(target - nums[i1]);
            if (i2 != null) {
                return new int[]{i1, i2};
            }
            numToIndexMap.put(nums[i1], i1);
        }
        return ans;
    }
}
