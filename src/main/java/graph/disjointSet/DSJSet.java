package graph.disjointSet;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class DSJSet {
    private final int[] parent;
    private final int[] rank;
    private final Map<Integer, IntBinaryOperator> unionStrategy = new HashMap<>();

    public DSJSet(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
            this.rank[i] = 0;
        }

        this.unionStrategy.put(-1, (a, b) -> this.parent[a] = b);
        this.unionStrategy.put(1, (a, b) -> this.parent[b] = a);
        this.unionStrategy.put(0, (a, b) -> {
            this.rank[a] += 1;
            this.parent[b] = a;
            return a;
        });
    }

    /**
     * Finds the representative element of the set that contains the given value.
     *
     * @param  val  the value to find the representative element for
     * @return      the representative element of the set
     */public int find(int val) {
        if (parent[val] == val) {
            return val;
        }
        int p = find(parent[val]);
        parent[val] = p;
        return p;
    }

    /**
     * Performs the union operation between two elements.
     *
     * @param  a    the first element to union
     * @param  b    the second element to union
     */public void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        int compareResult = Integer.compare(rank[pA], rank[pB]);
        IntBinaryOperator union = this.unionStrategy.get(compareResult);
        union.applyAsInt(pA, pB);
    }

    public boolean hasCycle(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) {
                return true; // Cycle detected
            }

            union(rootU, rootV);
        }

        return false; // No cycle detected
    }
}
