package ArraysAndStrings.Intervals;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/">...</a>
 * <p>
 * You are given two 2D integer arrays nums1 and nums2.
 * <p>
 * nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
 * nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
 * <p>
 * Each array contains unique ids and is sorted in ascending order by id.
 * <p>
 * Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
 * <p>
 * Only ids that appear in at least one of the two arrays should be included in the resulting array.
 * Each id should be included only once and its value should be the sum of the values of this id in the two arrays.
 * If the id does not exist in one of the two arrays then its value in that array is considered to be 0.
 * <p>
 * Return the resulting array. The returned array must be sorted in ascending order by id.
 */
public class MergeTwo2DArraysBySummingValues {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int len1 = nums1.length, len2 = nums2.length, p1 = 0, p2 = 0, j = 0;
        int[][] tmp = new int[len1 + len2][];
        int[][] res = new int[len1 + len2][];
        while (p1 < len1 && p2 < len2) {
            if (nums1[p1][0] < nums2[p2][0]) {
                tmp[p1 + p2] = nums1[p1];
                p1 += 1;
            } else if (nums1[p1][0] == nums2[p2][0]) {
                tmp[p1 + p2] = nums2[p2];
                tmp[p1 + p2][1] = nums1[p1][1] + nums2[p2][1];
                p2 += 1;
                p1 += 1;
            } else {
                tmp[p1 + p2] = nums2[p2];
                p2 += 1;
            }
        }
        while (p1 < len1) {
            tmp[p1 + p2] = nums1[p1];
            p1 += 1;
        }
        while (p2 < len2) {
            tmp[p1 + p2] = nums2[p2];
            p2 += 1;
        }
        for (int[] pair : tmp) {
            if (pair != null) {
                res[j++] = pair;
            }
        }
        return Arrays.copyOf(res, j);
    }
}
