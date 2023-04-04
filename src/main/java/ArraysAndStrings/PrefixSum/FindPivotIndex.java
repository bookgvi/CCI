package ArraysAndStrings.PrefixSum;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int res = -1, len = nums.length, p1 = 0, leftSum = 0, rightSum = 0;
        int[] pa = new int[len];
        pa[0] = nums[0];
        for (int i = 1; i < len; i += 1) {
            pa[i] = pa[i - 1] + nums[i];
        }
        for (int i = 0; i < len; i += 1) {
            if (i >= 1) {
                leftSum = pa[i - 1] - pa[p1] + nums[p1];
            }
            if (i + 1 < len) {
                rightSum = pa[len - 1] - pa[i];
            }
            if (rightSum - leftSum == 0) {
                res = i;
                break;
            }
            leftSum = 0;
            rightSum = 0;
        }
        return res;
    }
}
