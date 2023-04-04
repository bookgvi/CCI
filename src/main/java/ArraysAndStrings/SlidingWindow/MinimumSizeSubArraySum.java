package ArraysAndStrings.SlidingWindow;

public class MinimumSizeSubArraySum {
    /**
     * PrefixSum + Two pointers algo
     *
     * @param target - grater or equal this value
     * @param nums - arrays of positive integers
     * @return minimum subarray
     */
    public int minSubArrayLen(int target, int[] nums) {
        int p1 = 0, len = nums.length, sum = 0;
        if (len < 1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int[] prefixSumArr = new int[len];
        prefixSumArr[0] = nums[0];
        for (int p2 = 1; p2 < len; p2 += 1) {
            prefixSumArr[p2] = prefixSumArr[p2 - 1] + nums[p2];
        }
        for (int p2 = 0; p2 < len; p2 += 1) {
            sum = prefixSumArr[p2] - prefixSumArr[p1] + nums[p1];
            while (p1 <= p2 && sum >= target) {
                res = Math.min(res, p2 - p1 + 1);
                p1 += 1;
                if (p1 <= p2) {
                    sum = prefixSumArr[p2] - prefixSumArr[p1] + nums[p1];
                }
            }
        }
        return res < Integer.MAX_VALUE ? res : 0;
    }

}
