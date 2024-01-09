package graph.floydWarchall;

import java.util.Arrays;

public class FloydWarshall {

    private final int INF = Integer.MAX_VALUE >> 1;
    private int[][] paths;

    int[][] convertEdgesToGraph(int v, int[][] edges) {
        int[][] graph = new int[v][v];
        paths = new int[v][v];
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < v; ++j) {
                if (i != j) {
                    graph[i][j] = INF;
                } else {
                    graph[i][j] = 0;
                }
                paths[i][j] = j;
            }
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            int weight = edge[2];
            graph[src][dst] = weight;
        }
        return graph;
    }

    public int[][] floydWarshall(int v, int[][] edges) {
        int[][] dist = convertEdgesToGraph(v, edges);
        for (int k = 0; k < v; ++k) {
            for (int i = 0; i < v; ++i) {
                for (int j = 0; j < v; ++j) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        paths[i][j] = paths[i][k];
                    }
                }
            }
        }
        for (int i = 0; i < v; ++i) {
            if (dist[i][i] < 0) {
                return new int[][]{};
            }
        }
        return dist;
    }

    public int[][] getPaths() {
        int n = paths.length;
        int[][] _paths = new int[n][n];
        for (int i = 0; i < n; ++i) {
            _paths[i] = Arrays.copyOf(paths[i], n);
        }
        return _paths;
    }
}
