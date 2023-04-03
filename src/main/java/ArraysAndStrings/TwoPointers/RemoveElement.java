package ArraysAndStrings.TwoPointers;

/**
 * <p>
 * <a href="https://leetcode.com/problems/remove-element/description/">RemoveElement</a>
 * </p>
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * <p>
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * </p>
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int p1 = 0, p2 = 0;
        while (p2 < len) {
            if (nums[p2] != val) {
                nums[p1] = nums[p2];
                p1 += 1;
            }
            p2 += 1;
        }
        return p1;
    }
}
