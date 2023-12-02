package twoPointers;

public class RemoveDuplicatesInSortedArr {
    public int removeDuplicates(int[] nums) {
        int p1 = 0, len = nums.length, res = 0;
        if (len < 1) {
            return 0;
        }
        if (len < 2) {
            return len;
        }
        for (int i = 1; i < len; i += 1) {
            int val = nums[i];
            if (nums[p1] != val) {
                nums[++p1] = val;
            } else {
                res += 1;
            }
        }
        for (p1 += 1 ;p1 < len; p1 += 1) {
            nums[p1] = Integer.MIN_VALUE;
        }
        return len - res;
    }

}
