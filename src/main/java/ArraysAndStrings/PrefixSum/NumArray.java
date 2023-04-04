package ArraysAndStrings.PrefixSum;

public class NumArray {
    private final int[] nums;
    private final int[] prefixArr;

    public NumArray(int[] nums) {
        this.nums = nums;
        prefixArr = new int[nums.length];
        initPrefixArr();
    }

    public int sumRange(int left, int right) {
        return prefixArr[right] - prefixArr[left] + nums[left];
    }

    private void initPrefixArr() {
        prefixArr[0] = nums[0];
        for (int i = 1, len = nums.length; i < len; i += 1) {
            prefixArr[i] = prefixArr[i - 1] + nums[i];
        }
    }
}
