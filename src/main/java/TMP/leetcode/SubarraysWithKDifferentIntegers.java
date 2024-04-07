package TMP.leetcode;

/**
 * <a href="https://leetcode.com/problems/subarrays-with-k-different-integers/">...</a>
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * <p>
 * A good array is an array where the number of different integers in that array is exactly k.
 * <p>
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 */
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int[] d = new int[nums.length + 1];
        int left = 0;
        int right = 0;
        int counter = 0;
        int result = 0;
        while (right < nums.length) {
            if (d[nums[right++]]++ == 0) {
                --k;
            }
            if (k < 0) {
                --d[nums[left++]];
                ++k;
                counter = 0;
            }
            if (k == 0) {
                while(d[nums[left]] > 1) {
                    counter++;
                    --d[nums[left++]];
                }
                result += (counter + 1);
            }
        }
        return result;
    }
}
