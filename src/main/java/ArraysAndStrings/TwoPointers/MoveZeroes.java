package ArraysAndStrings.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">...</a>
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int p = 0, len = nums.length, zeroCounter = 0;
        for (int i = 0; i < len; i += 1) {
            if (nums[i] == 0) {
                zeroCounter += 1;
            } else {
                zeroCounter = 0;
            }
            if (zeroCounter < 1) {
                nums[p++] = nums[i];
            }
        }
        while (p < len) {
            nums[p++] = 0;
        }
    }
}
