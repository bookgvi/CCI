package ArraysAndStrings.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/sort-colors/">...</a>
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int[] count = new int[3];
        int[] tmp = new int[len];
        for (int num : nums) {
            count[num] += 1;
        }
        for (int i = 1; i < 3; i += 1) {
            count[i] += count[i - 1];
        }
        for (int i = len - 1; i >= 0; i -= 1) {
            tmp[--count[nums[i]]] = nums[i];
        }
        System.arraycopy(tmp, 0, nums, 0, len);
    }
}
