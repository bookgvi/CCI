package graph.task;

import java.util.Arrays;

public class RedundantConnection {

    private int[] parents;
    private int[] ranks;

    public int[] findRedundantConnection(int[][] edges) {
        int[][] initRes = initDJS(edges);
        parents = initRes[0];
        ranks = initRes[1];
        int[] resultArr = new int[2];
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int[] res = merge(a, b);
            if (res.length != 0) {
                resultArr = edge;
            }
        }
        return resultArr;
    }

    private int[][] initDJS(int[][] edges) {
        int len = edges.length + 1;
        int[] parents = new int[len];
        int[] ranks = new int[len];
        for (int i = 0; i < len; i += 1) {
            parents[i] = i;
        }
        return new int[][]{parents, ranks};
    }

    private int find(int v) {
        if (parents[v] == v) {
            return v;
        }
        parents[v] = find(parents[v]);
        return parents[v];
    }

    private int[] merge(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 == root2) {
            return new int[]{a, b};
        }
        if (ranks[root1] > ranks[root2]) {
            parents[root2] = root1;
        } else if (ranks[root1] < ranks[root2]) {
            parents[root1] = root2;
        } else {
            parents[root1] = root2;
            ranks[root2] += 1;
        }
        return new int[]{};
    }
}
