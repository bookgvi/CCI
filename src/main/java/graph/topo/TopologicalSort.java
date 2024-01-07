package graph.topo;

import java.util.*;

public class TopologicalSort {

    private static List<List<Integer>> constructGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i <= n; i += 1) {
            graph.add(new ArrayList<>(n));
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    public interface TopoSort {
        int[] process(int[][] edges);
    }

    static class BFS implements TopoSort {
        public int[] process(int[][] edges) {
            int n = edges.length + 1;
            List<List<Integer>> graph = constructGraph(n, edges);
            int[] inDegree = new int[n + 1];
            for (List<Integer> adjacencyList : graph) {
                for (int adjNode : adjacencyList) {
                    inDegree[adjNode] += 1;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < n; i += 1) {
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
            if (q.isEmpty()) {
                return new int[]{};
            }
            int[] topoSort = new int[n];
            int i = 0;
            while (!q.isEmpty()) {
                int curNode = q.poll();
                topoSort[i++] = curNode;
                for (int adjacency : graph.get(curNode)) {
                    inDegree[adjacency]--;
                    if (inDegree[adjacency - 1] == 0) {
                        q.offer(adjacency);
                    }
                }
            }
            return Arrays.copyOf(topoSort, i);
        }
    }

    static class DFS implements TopoSort {

        public int[] process(int[][] edges) {
            int n = edges.length + 1;
            List<List<Integer>> graph = constructGraph(n, edges);
            Stack<Integer> stack = new Stack<>();
            int[] visited = new int[n + 1];
            int[] parent = new int[n + 1];
            boolean hasCycle = false;
            for (int i = 1; i < n; ++i) {
                if (visited[i] == 0) {
                    hasCycle = dfs(i, graph, visited, parent, stack);
                }
            }
            if (stack.isEmpty() || hasCycle) {
                return new int[]{};
            }
            int[] topoSort = new int[n];
            int i = 0;
            while (!stack.isEmpty()) {
                topoSort[i++] = stack.pop();
            }
            return Arrays.copyOf(topoSort, i);
        }

        private boolean dfs(int node, List<List<Integer>> graph, int[] visited, int[] parent, Stack<Integer> stack) {
            boolean hasCycle = false;
            visited[node] = 1;
            for (int adjNode : graph.get(node)) {
                parent[adjNode] = node;
                if (visited[adjNode] == 0) {
                    hasCycle = dfs(adjNode, graph, visited, parent, stack);
                } else if (visited[adjNode] == 1) {
                    return true;
                }
            }
            visited[node] = 2;
            stack.push(node);
            return hasCycle;
        }
    }
}