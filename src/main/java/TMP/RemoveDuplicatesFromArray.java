package TMP;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {
    public int[] process(int[] nums) {
        int p = 0, len = nums.length, i = 0;
        if (len < 2) {
            return nums;
        }
        nums = sort(nums);
        while(p < len) {
            if (p + 1 < len && nums[p] != nums[p + 1]) {
                nums[i++] = nums[p++];
            } else {
                while (p + 1 < len && nums[p] == nums[p + 1]) {
                    p += 1;
                }
                p += 1;
            }
        }
        return Arrays.copyOf(nums, i);
    }

    private int[] sort(int[] numsOrig) {
        int len = numsOrig.length, dw = 4, b = 8;
        int[] nums = Arrays.copyOf(numsOrig, len);
        int[] tmp = new int[len];
        for (int p = 0; p < dw; p += 1) {
            int[] count = new int[1 << b];
            for (int elt : nums) {
                count[((elt ^ Integer.MIN_VALUE) >>> (p * b)) & ((1 << b) - 1)] += 1;
            }
            for (int i = 1; i < (1 << b); i += 1) {
                count[i] += count[i - 1];
            }
            for (int i = len - 1; i >= 0; i -= 1) {
                tmp[--count[((nums[i] ^ Integer.MIN_VALUE) >>> (p * b)) & ((1 << b) - 1)]] = nums[i];
            }
            System.arraycopy(tmp, 0, nums, 0, len);
        }
        return nums;
    }
}
