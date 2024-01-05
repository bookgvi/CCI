package graph.task;

import java.util.*;

public class MostStonesRemovedWithSameRowColumn {

    static class MostStonesRemovedWithSameRowColumnDJS {

        public int removeStones(int[][] stones) {
            int n = stones.length;
            int[] parent = new int[n];
            int[] rank = new int[n];
            for (int i = 0; i < n; i += 1) {
                parent[i] = i;
            }
            for (int  i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                        merge(i, j, parent, rank);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (parent[i] == i) {
                    count++;
                }
            }

            // Return the number of stones that can be removed
            return n - count;
        }

        private int find(int v, int[] parent) {
            if (parent[v] == v) {
                return v;
            }
            parent[v] = find(parent[v], parent);
            return parent[v];
        }

        private void merge(int a, int b, int[] parent, int[] rank) {
            int rootA = find(a, parent);
            int rootB = find(b, parent);

            if (rank[rootA] < rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootB] < rank[rootA]) {
                parent[rootA] = rootB;
            } else {
                rank[rootA] += 1;
                parent[rootA] = rootB;
            }
        }

    }
    static class MostStonesRemovedWithSameRowColumnDFS {

        public int removeStones(int[][] stones) {
            int n = stones.length;
            Map<Integer, List<Integer>> graph = new HashMap<>();
            boolean[] visited = new boolean[n];
            int connectedComponents = 0;

            // Build the graph
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                        graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                        graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                    }
                }
            }

            // Traverse the graph and find connected components
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    connectedComponents++;
                    dfs(i, graph, visited);
                }
            }

            return n - connectedComponents;
        }

        private void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
            visited[node] = true;

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        dfs(neighbor, graph, visited);
                    }
                }
            }
        }
    }
}
