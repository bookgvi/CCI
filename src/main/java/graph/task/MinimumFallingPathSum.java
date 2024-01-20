package graph.task;

import java.util.*;

public class MinimumFallingPathSum {
    // TLE
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        List<int[][]> distArr = new ArrayList<>(n);
        for (int j = 0; j < n; ++j) {
            distArr.add(initDist(n));
        }
        for (int j = 0; j < n; ++j) {
            int[][] dist = distArr.get(j);
            dist[0][j] = matrix[0][j];

            PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
            Node startNode = new Node(0, j, matrix[0][j]);
            q.add(startNode);
            while (!q.isEmpty()) {
                Node cur = q.poll();
                int row = cur.row;
                int col = cur.col;


                List<Node> adjArr = new ArrayList<>(3);
                if (row + 1 < n && col - 1 >= 0) {
                    adjArr.add(new Node(row + 1, col - 1, matrix[row + 1][col - 1]));
                }
                if (row + 1 < n) {
                    adjArr.add(new Node(row + 1, col, matrix[row + 1][col]));
                }
                if (row + 1 < n && col + 1 < n) {
                    adjArr.add(new Node(row + 1, col + 1, matrix[row + 1][col + 1]));
                }
                for (Node adjNode : adjArr) {
                    int dstWeight = adjNode.weight;
                    int dstRow = adjNode.row;
                    int dstCol = adjNode.col;

                    if (dist[row][col] + dstWeight < dist[dstRow][dstCol]) {
                        dist[dstRow][dstCol] = dist[row][col] + dstWeight;
                        q.add(new Node(dstRow, dstCol, dist[dstRow][dstCol]));
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                min = Math.min(min, dist[n - 1][i]);
            }
        }
        return min;
    }

    private int[][] initDist(int n) {
        int INF = Integer.MAX_VALUE;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dist[i][j] = INF;
            }
        }
        return dist;
    }

    private static class Node {
        int row;
        int col;
        int weight;

        public Node(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return row == node.row && col == node.col && weight == node.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col, weight);
        }
    }
}
