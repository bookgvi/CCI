package graph.task;

import java.util.*;

public class ReorderRoutesMakeAllPathsLeadCityZero_FlipEdge {

    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : connections) {
            graph.get(edge[0]).add(new int[]{edge[1], 1}); // Directed edge from edge[0] to edge[1]
            graph.get(edge[1]).add(new int[]{edge[0], 0}); // Undirected edge from edge[1] to edge[0]
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        count = dfs(0, graph, visited);

        return count;
    }

    private int dfs(int u, List<List<int[]>> graph, boolean[] visited) {
        int count = 0;
        visited[u] = true;
        for (int[] edge : graph.get(u)) {
            int v = edge[0];
            int direction = edge[1];
            if (!visited[v]) {
                if (direction == 1) {
                    count++; // Increment count if the edge is directed from u to v
                }
                count += dfs(v, graph, visited);
            }
        }
        return count;
    }


    private class MLE {
        // MLE
        public int minReorder(int n, int[][] connections) {
            List<List<Integer>> uGraph = new ArrayList<>(n);
            List<List<Integer>> dGraph = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                uGraph.add(new ArrayList<>(n));
                dGraph.add(new ArrayList<>(n));
            }
            for (int[] edge : connections) {
                dGraph.get(edge[0]).add(edge[1]);

                uGraph.get(edge[0]).add(edge[1]);
                uGraph.get(edge[1]).add(edge[0]);
            }

            Deque<Integer> startCityQ = new LinkedList<>();
            for (int i = 1; i < n; ++i) {
                if (uGraph.get(i).size() == 1) {
                    startCityQ.addLast(i);
                }
            }
            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            boolean[] visited = new boolean[n];
            dfs(0, uGraph, visited, parent);

            int count = 0;
            while (!startCityQ.isEmpty()) {
                int cur, next;
                cur = next = startCityQ.poll();
                while (next != 0) {
                    next = parent[next];
                    List<Integer> adjacencyList = dGraph.get(cur);
                    if (adjacencyList.isEmpty() || !adjacencyList.contains(next)) {
                        adjacencyList.add(next);
                        ++count;
                    }
                    cur = next;
                }
            }
            return count;
        }

        private void dfs(int u, List<List<Integer>> graph, boolean[] visited, int[] parent) {
            visited[u] = true;
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    parent[v] = u;
                    dfs(v, graph, visited, parent);
                }
            }
        }
    }
}
