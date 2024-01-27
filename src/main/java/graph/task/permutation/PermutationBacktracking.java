package graph.task.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationBacktracking {

    private final List<int[]> perms = new ArrayList<>();

    public List<int[]> proceed(int n) {
        for (int i = 0; i < n; ++i) {
            boolean[] used = new boolean[n];
            int[] p = new int[n];
            p[0] = i;
            used[i] = true;
            backTrack(1, n, p, used);
        }
        return perms;
    }

    private void backTrack(int i, int n, int[] p, boolean[] used) {
        if (i >= n) {
            perms.add(Arrays.copyOf(p, n));
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (!used[j]) {
                p[i] = j;
                used[j] = true;
                backTrack(i + 1, n, p, used);
                reverse(i, p, used);
            }
        }
    }

    private void reverse(int i, int[] p, boolean[] used) {
        used[p[i]] = false;
        p[i] = -1;
    }
}
