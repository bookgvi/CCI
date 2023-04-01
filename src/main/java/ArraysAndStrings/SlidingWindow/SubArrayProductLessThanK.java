package ArraysAndStrings.SlidingWindow;

public class SubArrayProductLessThanK {
    public int proceed(int[] nums, int k) {
        int l, cur = 1, res = 0;
        for (int r = 0, len = nums.length; r < len; r += 1) {
            cur *= nums[r];
            if (cur < k) {
                res += 1;
            }
            l = r;
            while(cur < k && l > 0) {
                cur *= nums[--l];
                if (cur < k) {
                    res += 1;
                }
            }
            cur = 1;
        }
        return res;
    }

    public int proceed2(int[] nums, int k) {
        int l = 0, curProd = 1, ans = 0;
        if (k < 1) {
            return 0;
        }
        for (int r = 0, len = nums.length; r < len; r += 1) {
            curProd *= nums[r];
            while(curProd >= k && l <= r) {
                curProd /= nums[l++];
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
