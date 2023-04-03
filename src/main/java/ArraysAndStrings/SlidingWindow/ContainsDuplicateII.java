package ArraysAndStrings.SlidingWindow;

/**
 *
 * <a href="https://leetcode.com/problems/contains-duplicate-ii/">ContainsDuplicateII</a>
 * <p>
 *  Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
 *  such that nums[i] == nums[j] and abs(i - j) <= k.
 * </p>
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || k == 0) {
            return false;
        }
        int l;
        boolean ans = false;
        for (int r = 1, len = nums.length; r < len; r += 1) {
            l = Math.max(r - k, 0);
            ans = nums[l] == nums[r];
            while (!ans && r > l + 1) {
                ans = nums[++l] == nums[r];
            }
            if (ans) {
                break;
            }
        }
        return ans;
    }
}
