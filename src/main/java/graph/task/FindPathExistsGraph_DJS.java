package graph.task;

public class FindPathExistsGraph_DJS {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DJS djs = new DJS(n);
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            djs.merge(src, dst);
        }
        int rootSource = djs.find(source);
        int rootDest = djs.find(destination);
        return rootSource == rootDest;
    }

    private static class DJS {
        private final int[] parent;
        private final int[] rank;

        public DJS(int n) {
            this.rank = new int[n];
            this.parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        int find(int v) {
            if (v == parent[v]) {
                return v;
            }
            parent[v] = find(parent[v]);
            return parent[v];
        }

        boolean merge(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return false;
            }
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootB] < rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                rank[rootA] += 1;
                parent[rootB] = rootA;
            }
            return true;
        }
    }
}
