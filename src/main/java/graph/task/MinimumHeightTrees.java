package graph.task;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();

        if (n <= 0) {
            return minHeightTrees;
        }

        if (n == 1) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }

        List<List<Integer>> adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);

            indegree[node1]++;
            indegree[node2]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                leaves.offer(i);
            }
        }

        while (n > 2) {
            int leavesSize = leaves.size();
            n -= leavesSize;

            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                List<Integer> neighbors = adjacencyList.get(leaf);

                for (int neighbor : neighbors) {
                    indegree[neighbor]--;

                    if (indegree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        minHeightTrees.addAll(leaves);
        return minHeightTrees;
    }
}