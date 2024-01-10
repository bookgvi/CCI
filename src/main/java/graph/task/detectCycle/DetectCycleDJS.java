package graph.task.detectCycle;

import java.util.List;
import java.util.ArrayList;

public class DetectCycleDJS {

    public boolean hasCycle(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        boolean hasCycle = false;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            hasCycle = !merge(u, v, parent, rank);
            if (hasCycle) {
                return true;
            }
        }
        return hasCycle;
    }

    private int find(int v, int[] parent) {
        if (v == parent[v]) {
            return v;
        }
        parent[v] = find(parent[v], parent);
        return parent[v];
    }

    /**
     * Merges two elements in a disjoint set.
     *
     * @param  a     the first element to merge
     * @param  b     the second element to merge
     * @param  parent  the array representing the parent of each element in the disjoint set
     * @param  rank  the array representing the rank of each element in the disjoint set
     * @return          true if the elements are merged successfully, false if elements already in the set
     */private boolean merge(int a, int b, int[] parent, int[] rank) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB) {
            return false;
        }
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootB] < rank[rootA]) {
            parent[rootB] = rootA;
        } else {
            rank[rootA] += 1;
            parent[rootB] = rootA;
        }
        return true;
    }
}
