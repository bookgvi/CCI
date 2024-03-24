package TMP.leetcode;

public class FindContiguousSubArray {
    private static int count = 1;

    private boolean isAccept(int[] binNums, boolean[] used, int i) {
        return i < binNums.length && i >= 0 && binNums[i] == 1 && !used[i];
    }

    private void dfsSubArrayChecker(int[] binNums, boolean[] used, int index) {
        int[] siblings = {-1, 0, 1};
        for (int i : siblings) {
            if (isAccept(binNums, used, index + i)) {
                used[index + i] = true;
                ++count;
                dfsSubArrayChecker(binNums, used, index + i);
            }
        }
    }

    public int proceed(int[] binNums) {
        int len = binNums.length;
        boolean[] used = new boolean[len];
        int res = 0;
        for (int i = 0; i < len; ++i) {
            count = 0;
            dfsSubArrayChecker(binNums, used, i);
            res = Math.max(res, count);
        }
        return res;
    }
}
