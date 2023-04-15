package ArraysAndStrings.TwoPointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/">...</a>
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0, i = 0, elt = 0;
        int[] tmpArr = new int[m + n];
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                elt = nums1[p1++];
            } else {
                elt = nums2[p2++];
            }
            tmpArr[i++] = elt;
        }
        while (p1 < m) {
            tmpArr[i++] = nums1[p1++];
        }
        while (p2 < n) {
            tmpArr[i++] = nums2[p2++];
        }
        System.arraycopy(tmpArr, 0, nums1, 0, m + n);
    }
}
