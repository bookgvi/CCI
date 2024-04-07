package TMP.leetcode;

public class SubarrayProductStrictlyLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        if (nums.length < 2) return nums[0] < k ? 1 : 0;
        int product = nums[0];
        int left = 0, counter = 0;
        for (int right = 0; right < nums.length; ++right) {
            while (++right< nums.length && product * nums[right] < k) {
                product *= nums[right];
                counter += ((right - left) << 1) + 1;
            }
            if (right >= nums.length) break;
            left = --right;
            product = nums[left];
        }
        return counter;
    }
}
