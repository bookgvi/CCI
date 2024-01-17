package graph.task;

import java.util.*;
public class MinCostConnectAllPoints_kruskal {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph[i][j] = weight;
                graph[j][i] = weight;
            }
        }

        // Initialize the edges list
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new int[]{i, j, graph[i][j]});
            }
        }

        // Sort the edges in ascending order of weights
        edges.sort(Comparator.comparingInt(arr -> arr[2]));

        DJS djs = new DJS(n);

        int minCost = 0;
        int numEdges = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (djs.merge(u, v)) {
                minCost += weight;
                numEdges += 1;
            }
            if (numEdges == n - 1) {
                break;
            }
        }

        return minCost;
    }

    private static class DJS {
        private final int[] parent;
        private final int[] rank;

        private DJS(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                rank[i] = 0;
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
