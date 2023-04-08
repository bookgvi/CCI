package ArraysAndStrings.TwoPointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays/">...</a>
 */
public class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0, i = 0, len1 = nums1.length, len2 = nums2.length;
        int[] ans = new int[len1 + len2];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (p1 < len1 && p2 < len2) {
            if (nums1[p1] < nums2[p2]) {
                p1 += 1;
            } else if (nums1[p1] > nums2[p2]) {
                p2 += 1;
            } else {
                ans[i++] = nums1[p1];
                p1 += 1;
                p2 += 1;
            }
        }
        return getUnique(Arrays.copyOf(ans, i));
    }

    private int[] getUnique(int[] nums) {
        int len = nums.length, p1 = 0, uniqueCounter = 1;
        if (len < 1) return new int[]{};
        int[] ans = new int[len];
        ans[p1++] = nums[0];
        for (int i = 1; i < len; i += 1) {
            if (nums[i - 1] == nums[i]) {
                uniqueCounter += 1;
            } else {
                uniqueCounter = 1;
            }
            if (uniqueCounter <= 1) {
                ans[p1++] = nums[i];
            }
        }
        return Arrays.copyOf(ans, p1);
    }

    public int binPow(int n, int pow) {
        int ans = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans *= n;
            }
            n *= n;
            pow >>= 1;
        }
        return ans;
    }
}
