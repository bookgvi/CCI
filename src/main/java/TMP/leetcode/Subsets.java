package TMP.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private boolean flag;
    private final List<List<Integer>> result = new ArrayList<>();
    private int[] counter = new int[12];

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int[][] pr = cfCalc(n);
        int[] cf = pr[0];
        counter = pr[1];
        result.add(new ArrayList<>());
        for (int i = 1; i <= n; ++i) {
            flag = false;
            backtracking(nums, i, cf[i], new ArrayList<>(), new ArrayList<>());
        }
        return result;
    }

    private int[][] cfCalc(int n) {
        int[][] res = new int[2][12];
        int[] cf = new int[12];
        int[] counter = new int[12];
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] * i;
        }
        counter[0] = 1;
        for (int i = 1; i <= n; ++i) {
            cf[i] = f[n] / (f[n - i] * f[i]);
            counter[i] = counter[i - 1] + cf[i];
        }
        res[0] = cf;
        res[1] = counter;
        return res;
    }

    private void backtracking(int[] nums, int c, int cf, List<Integer> localRes, List<Integer> used) {
        if (result.size() == counter[c]) {
            flag = true;
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (localRes.size() < c && isAccept(i, used)) {
                persist(i, nums, used, localRes);
                if (localRes.size() == c) {
                    result.add(new ArrayList<>(localRes));
                }
                backtracking(nums, c, cf, localRes, used);
                if (!flag) {
                    removeLast(used, localRes);
                }
            }
        }
    }

    private void persist(int i, int[] nums, List<Integer> used, List<Integer> localRes) {
        used.add(i);
        localRes.add(nums[i]);
    }

    private void removeLast(List<Integer> used, List<Integer> localRes) {
        if (localRes.isEmpty()) {
            return;
        }
        localRes.remove(localRes.size() - 1);
        used.remove(used.size() - 1);
    }

    private boolean isAccept(int i, List<Integer> used) {
        if (used.isEmpty()) {
            return true;
        }
        return used.get(used.size() - 1) < i;
    }
}
