package graph.task;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        n = n + 1;
        List<List<Integer>> adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i += 1) {
            adjacencyList.add(new ArrayList<>());
        }
        int len = dislikes.length;
        for (int i = 0; i < len; i += 1) {
            adjacencyList.get(dislikes[i][0]).add(dislikes[i][1]);
            adjacencyList.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        boolean isBipartite = true;
        for (int i = 1; i < n; i += 1) {
            if (visited[i] == -1) {
                isBipartite &= dfs(i, adjacencyList, visited, 1);
            }
        }
        return isBipartite;
    }

    private boolean dfs(int i, List<List<Integer>> adjacencyList, int[] visited, int color) {
        visited[i] = color;
        boolean isBipartite = true;
        for (int adjacency : adjacencyList.get(i)) {
            if (visited[adjacency] == -1) {
                isBipartite = dfs(adjacency, adjacencyList, visited, 1 - color);
            } else if (visited[adjacency] == color) {
                return false;
            }
        }
        return isBipartite;
    }
}
