package graph.task;

import java.util.*;

public class FindTheTownJudge {

    /*
     * Runtime: 2 ms, faster than 99.45% of Java online submissions for Find the Town Judge.
     * Memory Usage: 54.4 MB, less than 6.38% of Java online submissions for Find the Town Judge.
     */
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        for (int[] edge : trust) {
            inDegree[edge[0]] += 1;
            outDegree[edge[1]] += 1;
        }
        int i = 1;
        while (i <= n && inDegree[i] != 0) {
            ++i;
        }
        if (i > n) {
            return -1;
        }
        int k = n - 1 - outDegree[i];
        return k == 0 ? i : -1;
    }

    /*
     * Runtime: 8 ms, faster than 27.44% of Java online submissions for Find the Town Judge.
     * Memory Usage: 53.4 MB, less than 21.92% of Java online submissions for Find the Town Judge.
     */
    public int findJudge1(int n, int[][] trust) {
        int sum = ((n + 1) * n) >>> 1;
        Set<Integer> unique = new HashSet<>(n + 1);
        int[] outDegree = new int[n + 1];
        for (int[] edge : trust) {
            if (unique.add(edge[0])) {
                sum -= edge[0];
            }
            outDegree[edge[1]] += 1;
        }
        return sum > 0 && sum <= n && outDegree[sum] == n - 1 ? sum : -1;
    }
}
