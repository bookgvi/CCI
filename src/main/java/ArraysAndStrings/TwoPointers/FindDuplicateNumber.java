package ArraysAndStrings.TwoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">...</a>
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 * <p>
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate2(int[] nums) {
        int len = nums.length, p = 0;
        Set<Integer> uniques = new HashSet<>(len);
        while (p < len) {
            if (!uniques.add(nums[p])) {
                return nums[p];
            }
            p += 1;
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        int len = nums.length;
        int[] tmpNums = new int[len];
        System.arraycopy(nums, 0, tmpNums, 0, len);
        for (int i = 1; i < len; i <<= 1) {
            for (int j = 0; j < len - i; j += i << 1) {
                int r = merge(j, Math.min(len, i + j), Math.min(len, j + (i << 1)), tmpNums);
                if (r != Integer.MIN_VALUE) {
                    return r;
                }
            }
        }
        return -1;
    }

    private int check(int l, int r, int[] nums) {
        int len = nums.length, p1 = l + 1;
        while (p1 < r && p1 < len) {
            if (nums[l++] == nums[p1++]) {
                return nums[l];
            }
        }
        return Integer.MIN_VALUE;
    }

    private int merge(int l, int mid, int r, int[] nums) {
        int p1 = 0, p2 = 0;
        int[] tmp = new int[r - l];
        while (l + p1 < mid && mid + p2 < r) {
            if (nums[l + p1] < nums[mid + p2]) {
                tmp[p1 + p2] = nums[l + p1];
                p1 += 1;
            } else {
                tmp[p1 + p2] = nums[mid + p2];
                p2 += 1;
            }
        }
        while (l + p1 < mid) {
            tmp[p1 + p2] = nums[l + p1];
            p1 += 1;
        }
        while (mid + p2 < r) {
            tmp[p1 + p2] = nums[mid + p2];
            p2 += 1;
        }
        System.arraycopy(tmp, 0, nums, l, r - l);
        return check(l, r, tmp);
    }
}
