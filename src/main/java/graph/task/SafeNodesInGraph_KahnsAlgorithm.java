package graph.task;
import java.util.*;

public class SafeNodesInGraph_KahnsAlgorithm {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> safeNodes = new ArrayList<>();
        int[] inDegrees = new int[n];
        List<List<Integer>> rGraph = reverse(graph);

        for (List<Integer> edges : rGraph) {
            for (int node : edges) {
                inDegrees[node] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);

            for (int neighbor : rGraph.get(node)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    private List<List<Integer>> reverse(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i);
            }
        }
        return adj;
    }
}