package ArraysAndStrings.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/">...</a>
 * <p>
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * <p>
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 */
public class FindDifferenceTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        nums1 = getUniqueElementsArray(nums1);
        nums2 = getUniqueElementsArray(nums2);
        List<Integer> uniqueInNums1 = new ArrayList<>();
        List<Integer> uniqueInNums2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(uniqueInNums1);
        ans.add(uniqueInNums2);

        int len1 = nums1.length, len2 = nums2.length;
        while (p1 < len1 && p2 < len2) {
            if (nums1[p1] < nums2[p2]) {
                uniqueInNums1.add(nums1[p1++]);
            } else if (nums1[p1] > nums2[p2]) {
                uniqueInNums2.add(nums2[p2++]);
            } else {
                p1 += 1;
                p2 += 1;
            }
        }
        while (p1 < len1) {
            uniqueInNums1.add(nums1[p1++]);
        }
        while (p2 < len2) {
            uniqueInNums2.add(nums2[p2++]);
        }
        return ans;
    }

    private int[] getUniqueElementsArray(int[] nums) {
        int p1 = 1, p2 = 1, len = nums.length, uniqueCounter = 1;
        int[] ans = new int[len];
        ans[0] = nums[0];
        while (p2 < len) {
            if (nums[p2 - 1] == nums[p2]) {
                uniqueCounter += 1;
            } else {
                uniqueCounter = 1;
            }
            if (uniqueCounter <= 1) {
                ans[p1++] = nums[p2];
            }
            p2 += 1;
        }
        return Arrays.copyOf(ans, p1);
    }
}
