package graphUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphV3 {

    private final int[][] g;
    private final int[] used;
    private final int[] tin;
    private final int[] tout;
    private int t = 0;

    public GraphV3(int[][] adjacency) {
        int size = getSize(adjacency);
        this.g = new int[size][2];
        this.used = new int[size];
        this.tin = new int[size];
        this.tout = new int[size];
        fromAdjacencyToGraph(adjacency);
    }

    private int getSize(int[][] adjacency) {
        int res = 0;
        if (adjacency == null) {
            return res;
        }
        for (int[] inAdj : adjacency) {
            for (int i = 0, len = inAdj.length; i < len; i += 1) {
                res = Math.max(res, inAdj[i] + 1);
            }
        }
        return res;
    }

    private void fromAdjacencyToGraph(int[][] adjacency) {
        int size = adjacency != null ? adjacency.length : 0;
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < 2; j += 1) {
                g[i][j] = adjacency[i][j];
            }
        }
    }

    private void adjMark(int v, int num) {
        used[v] = num;
        for (int u : g[v]) {
            if (used[u] == 0) {
                used[u] = num;
                adjMark(u, num);
            }
        }
    }

    public void dfs(int v) {
        if (tin.length <= v) {
            return;
        }
        tin[v] = t++;
        used[v] = 1;
        for (int u : g[v]) {
            if (u < used.length && used[u] != 1) {
                dfs(u);
            }
        }
        tout[v] = t;
    }

    public int findAdjacencyComponents() {
        int num = 1;
        for (int i = 0, len = g.length; i < len; i += 1) {
            if (used[i] == 0) {
                adjMark(i, num++);
            }
        }
        return num;
    }
}
