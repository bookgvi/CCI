package graph.task;

public class SatisfiabilityEqualityEquations_DJS {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int first = equation.charAt(0) - 'a';
                int last = equation.charAt(3) - 'a';
                merge(first, last, parent, rank);
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int first = equation.charAt(0) - 'a';
                int last = equation.charAt(3) - 'a';
                if (find(first, parent) == find(last, parent)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int v, int[] parent) {
        if (v == parent[v]) {
            return v;
        }
        parent[v] = find(parent[v], parent);
        return parent[v];
    }

    private void merge(int a, int b, int[] parent, int[] rank) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB) {
            return;
        }
        if (rank[rootA] < rank[rootB]) {
            parent[rootB] = rootA;
        } else if (rank[rootB] < rank[rootA]) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootB]++;
        }
    }

}
