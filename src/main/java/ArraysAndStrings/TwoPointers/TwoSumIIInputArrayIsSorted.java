package ArraysAndStrings.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">...</a>
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such
 * that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 */
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
            int len = numbers.length, p1 = 0, p2 = len - 1;
            int sum = 0;
            while (p1 < p2) {
                sum = numbers[p1] + numbers[p2];
                if (sum > target) {
                    p2 -= 1;
                } else if (sum < target) {
                    p1 += 1;
                } else {
                    return new int[]{p1 + 1, p2 + 1};
                }
            }
            return new int[]{};
    }

    public int[] twoSumStraight(int[] numbers, int target) {
        int len = numbers.length, p1 = 0; ;
        int sum = 0;
        for (int p2 = 0; p2 < len; p2 += 1) {
            sum += numbers[p2];
            while (sum > target && p1 < p2) {
                sum -= numbers[p1++];
            }
            if (sum == target) {
                return new int[]{p1 + 1, p2 + 1};
            }
        }
        return null;
    }
}
