package graph.task;

import java.util.*;

public class FlowerPlantingWithNoAdjacent {

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>(3));
        }
        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }

        int[] flowers = new int[n];
        for (int i = 1; i <= n; ++i) {
            if (flowers[i - 1] == 0) {
                Set<Integer> usedFlowers = new HashSet<>();
                for (int adj : graph.get(i)) {
                    if (flowers[adj - 1] != 0) {
                        usedFlowers.add(flowers[adj - 1]);
                    }
                }
                for (int j = 1; j < 5; ++j) {
                    if (!usedFlowers.contains(j)) {
                        flowers[i - 1] = j;
                        break;
                    }
                }
            }
        }
        return flowers;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, int[] flowers, int i) {
        visited[node] = true;
        for (int adj : graph.get(node)) {
            if (!visited[adj]) {
                visited[adj] = true;
                flowers[adj - 1] = (i % 4) + 1;
                dfs(adj, graph, visited, flowers, flowers[adj - 1]);
            }
        }
    }
}
