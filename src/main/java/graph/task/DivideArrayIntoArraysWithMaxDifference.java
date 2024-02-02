package graph.task;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] res = new int[n / 3][3];
        int j = -1, x = 0;
        for (int i = 0; i < n; ++i) {
            j = x == 0 ? j + 1 : j;
            res[j][x] = nums[i];
            if (x >= 1 && res[j][x] - res[j][x - 1] > k) {
                return new int[][]{};
            }
            if (j > 0 && res[j - 1][2] == res[j][0]) {
                return new int[][]{};
            }
            x = (x + 1) % 3;
        }
        return res;
    }

}
