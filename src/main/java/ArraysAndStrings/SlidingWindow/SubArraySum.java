package ArraysAndStrings.SlidingWindow;

public class SubArraySum {
    public int proceed(int[] arr, int k) {
        int l = 0, curSum = 0, res = 0;
        for (int r = 0, len = arr.length; r < len; r += 1) {
            curSum += arr[r];
            while(curSum > k) {
                curSum -= arr[l++];
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
