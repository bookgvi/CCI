package graph.task;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlices_II_Subsequence {

    /*
     * Success
     * Runtime: 132 ms, faster than 81.40% of Java online submissions for Arithmetic Slices II - Subsequence.
     * Memory Usage: 90.7 MB, less than 44.19% of Java online submissions for Arithmetic Slices II - Subsequence.
     *
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int diffInt = (int) diff;
                int prevCount = dp[j].getOrDefault(diffInt, 0);
                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + prevCount + 1);
                count += prevCount;
            }
        }

        return count;
    }
}
