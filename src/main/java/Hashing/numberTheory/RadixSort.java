package Hashing.numberTheory;

public class RadixSort {
    public void sort(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        int b = 8, dw = Integer.BYTES;
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
    }
}
