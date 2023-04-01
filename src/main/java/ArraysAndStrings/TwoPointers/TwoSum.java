package ArraysAndStrings.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * Constraints:
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * </p>
 * <p>
 * Only one valid answer exists.
 * </p>
 */
public class TwoSum {
    /**
     * TLE
     * @param nums array of integers
     * @param target - int for compare
     * @return 2 elements array of indices
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums != null && nums.length > 1) {
            int p1 = 0, p2 = nums.length - 1;
            target = Math.abs(target);
            while (p1 < p2) {
                int sum = Math.abs(nums[p1] + nums[p2]);
                if (target < sum) {
                    p2 -= 1;
                    if (p1 == p2 && p1 > 0) {
                        p1 -= 1;
                    }
                } else if (target > sum) {
                    p1 += 1;
                    if (p1 == p2 && p2 < nums.length - 1) {
                        p2 += 1;
                    }
                } else {
                    return new int[] {p1, p2};
                }
            }
        }
        return null;
    }

    public int[] twoSumSort(int[] nums, int target) {
        Arrays.sort(nums);
        int p1 = 0, p2 = nums.length - 1;
        target = Math.abs(target);
        while (p1 < p2) {
            int sum = Math.abs(nums[p1] + nums[p2]);
            if (sum > target) {
                p2 -= 1;
            } else if (sum < target) {
                p1 += 1;
            } else {
                return new int[] {p1, p2};
            }
        }
        return null;
    }

    public int[] twoSumExt(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i += 1) {
            map.put(nums[i], i);
        }
        for (int i = 0, len = nums.length; i < len; i += 1) {
            int calcVal = target - nums[i];
            if (map.containsKey(calcVal) && i != map.get(calcVal)) {
                return new int[] {i, map.get(calcVal)};
            }
        }
        return null;
    }
}
