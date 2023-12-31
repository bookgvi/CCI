package graph.task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This implementation uses a different approach to find the minimum height trees. It starts by building an adjacency list and an indegree array to represent the graph. Then, it uses a queue to keep track of the leaves (nodes with only one neighbor). It iteratively removes the leaves from the graph until only the minimum height trees remain.
 * You can use this alternative implementation by creating an instance of the MinimumHeightTrees class and calling the findMinHeightTrees method with the number of nodes n and the edges as parameters. The method will return a list of root nodes that form the minimum height trees.
 * <p>
 * A minimum height tree, also known as a centroid tree or a minimum height spanning tree, is a tree that minimizes the maximum height among all possible trees that can be formed from a given graph. In other words, it is a tree that has the smallest possible maximum height.
 * The height of a tree is defined as the maximum number of edges in any path from the root node to a leaf node. The goal of constructing a minimum height tree is to find a tree structure that evenly distributes the nodes and minimizes the longest path from the root to any leaf.
 * In the context of graph theory, a minimum height tree can be used to find the most central nodes or the nodes that are most connected to other nodes in the graph. It is often used in network analysis, data clustering, and optimization problems.
 * To construct a minimum height tree, various algorithms and techniques can be used, such as topological sorting, breadth-first search, or divide-and-conquer approaches. These algorithms aim to find the nodes that can serve as the root of the tree, ensuring that the resulting tree has the minimum height possible.
 * Overall, a minimum height tree is a tree structure that optimizes the balance and height of the tree, providing an efficient way to represent and analyze the underlying graph.
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> mhtRoots = new ArrayList<>();
        if (n <= 0) {
            return mhtRoots;
        }
        if (n < 2) {
            mhtRoots.add(edges[0][0]);
            return mhtRoots;
        }
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i += 1) {
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);

            inDegree[node1] += 1;
            inDegree[node2] += 1;
        }
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i += 1) {
            if (inDegree[i] == 1) {
                leaves.offer(i);
            }
        }
        while (n > 2) {
            int leavesCount = leaves.size();
            n -= leavesCount;

            for (int i = 0; i < leavesCount; i += 1) {
                Integer leaf = leaves.poll();
                if (leaf == null) {
                    continue;
                }
                List<Integer> neighbours = adjList.get(leaf);
                for (int neighbour : neighbours) {
                    inDegree[neighbour] -= 1;
                    if (inDegree[neighbour] == 1) {
                        leaves.offer(neighbour);
                    }
                }
            }
        }
        mhtRoots.addAll(leaves);
        return mhtRoots;
    }


    /**
     * Finds the minimum height trees in a graph represented by adjacency list.
     *
     * @param n     the number of nodes in the graph
     * @param edges the edges connecting the nodes in the graph
     * @return a list of minimum height trees
     */
    public List<Integer> findMinHeightTrees_orig(int n, int[][] edges) {
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