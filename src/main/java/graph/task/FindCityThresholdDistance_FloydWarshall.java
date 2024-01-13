package graph.task;

public class FindCityThresholdDistance_FloydWarshall {

    private final int INF = Integer.MAX_VALUE;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjDistance = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                adjDistance[i][j] = i == j ? 0 : INF;
            }
        }

        for (int[] edge : edges) {
            adjDistance[edge[0]][edge[1]] = edge[2];
            adjDistance[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (adjDistance[i][k] != INF && adjDistance[k][j] != INF && adjDistance[i][j] > adjDistance[i][k] + adjDistance[k][j]) {
                        adjDistance[i][j] = adjDistance[i][k] + adjDistance[k][j];
                    }
                }
            }
        }

        int minCities = n + 1;
        int result = -1;

        for (int i = 0; i < n; ++i) {
            int reachableCities = 0;
            for (int j = 0; j < n; ++j) {
                if (i != j && adjDistance[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities <= minCities) {
                minCities = reachableCities;
                result = i;
            }
        }

        return result;
    }

}
