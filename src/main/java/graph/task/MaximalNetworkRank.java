package graph.task;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] cityRank = new int[n];
        int[][] isConnected = new int[n][n];

        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            cityRank[city1]++;
            cityRank[city2]++;
            isConnected[city1][city2] = 1;
            isConnected[city2][city1] = 1;
        }

        int maxRank = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = cityRank[i] + cityRank[j] - isConnected[i][j];
                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}
