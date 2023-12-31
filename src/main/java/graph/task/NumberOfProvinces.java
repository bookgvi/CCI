package graph.task;

public class NumberOfProvinces {
    private int[] parent;
    private int[] rank;

    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int count = isConnected.length;
        parent = initParent(isConnected);
        rank = initRank(isConnected);
        for (int i = 0; i < len; i += 1) {
            for (int j = 0; j < len; j += 1) {
                if (isConnected[i][j] == 1 && find(i) != find(j)) {
                    merge(i, j);
                    count -= 1;
                }
            }
        }
        return count;
    }


    private int[] initRank(int[][] isConnected) {
        return new int[isConnected.length];
    }

    private int[] initParent(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i += 1) {
            parent[i] = i;
        }
        return parent;
    }

    int find(int v) {
        if (parent[v] == v) {
            return v;
        }
        parent[v] = find(parent[v]);
        return parent[v];
    }

    void merge(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 == root2) {
            return;
        }

        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root2] < rank[root1]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1] += 1;
        }
    }
}
