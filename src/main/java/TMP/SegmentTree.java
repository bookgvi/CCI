package TMP;

public class SegmentTree {
    private final int[] nums;
    private final int[] origNums;
    private int n;

    public SegmentTree(int[] nums) {
        this.origNums = nums;
        this.n = nums.length;
        this.nums = new int[n << 1];
        System.arraycopy(nums, 0, this.nums, n, n);
        build();
    }

    public int[] build() {
        for (int i = n - 1; i > 0; --i) {
            nums[i] = nums[i << 1] + nums[i << 1 | 1];
        }
        return nums;
    }

    public void changeValue(int index, int value) {
        origNums[index] = value;
        for (nums[index += n] = value; index > 1; index >>= 1) {
            nums[index >> 1] = nums[index] + nums[index ^ 1];
        }
    }

    public int query(int l, int r) {
        int res = 0;
        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) res += nums[l++];
            if ((r & 1) == 1) res += nums[--r];
        }
        return res;
    }
}
