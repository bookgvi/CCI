package graph.task;

public class NumberOperationsMakeNetworkConnected_DJS_Kruskal {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        DJS djs = new DJS(n);
        int count = 0;
        for (int[] edge : connections) {
            if (djs.merge(edge[0], edge[1])) {
                ++count;
            }
        }
        return n - count - 1;
    }

    private static class DJS {
        private final int[] parent;
        private final int[] rank;

        DJS(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; ++i) {
                this.parent[i] = i;
            }
        }

        int find(int val) {
            if (val == parent[val]) {
                return val;
            }
            parent[val] = find(parent[val]);
            return parent[val];
        }

        boolean merge(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootB] > rank[rootA]) {
                parent[rootA] = rootB;
            } else {
                rank[rootA] += 1;
                parent[rootB] = rootA;
            }
            return true;
        }
    }
}
