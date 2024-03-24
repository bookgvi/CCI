package TMP.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/?envType=daily-question&envId=2024-03-24">...</a>
 */
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        int res = -1;
        for (int i = 0; i < len; ++i) {
            res = dfs(nums, used, i);
            break;
        }
        return res;
    }

    private int dfs(int[] nums, boolean[] used, int i) {
        used[i] = true;
        int next = nums[i];
        if (!used[next]) {
            return dfs(nums, used, next);
        }
        return next;
    }
}
