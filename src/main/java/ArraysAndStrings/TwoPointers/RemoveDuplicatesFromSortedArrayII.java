package ArraysAndStrings.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">RemoveDuplicatesFromSortedArrayII</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique
 * element appears at most twice. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result
 * be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first
 * k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int p1 = 1, len = nums.length;
        final int countOfEqualsElt = 2;
        int counter = 1;
        for (int p2 = 1; p2 < len; p2 += 1) {
            if (nums[p2 - 1] == nums[p2]) {
                counter += 1;
            } else {
                counter = 1;
            }
            if (counter <= countOfEqualsElt) {
                nums[p1++] = nums[p2];
            }
        }
        return p1;
    }
}
