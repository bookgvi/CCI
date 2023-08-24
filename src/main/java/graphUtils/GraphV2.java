package graphUtils;

import stack.genericStack.Stack;
import stack.genericStack.StackOverflowException;

import java.util.Arrays;

public class GraphV2 {
    public static final GraphV2 INSTANCE = new GraphV2();
    private final int nullVal = -1;
    private int MAX = 12;
    private int cycleStart = 0;
    private int cycleEnd = 0;
    private int[][] g = null;
    private int[] p = null;
    private int[] used = null;
    public Stack<Integer> topo = null;

    private GraphV2() {
    }

    public static GraphV2 getInstance() {
        return INSTANCE;
    }

    public int[][] fromArr(int[] arr) {
        if (arr == null) {
            throw new IllegalStateException("must be non null");
        }
        int len = arr.length;
        MAX = (len & 1) == 0 ? len >> 1 : (len + 1) >> 1;
        reset();
        proceedArr(arr, len);
        return g;
    }

    public int[][] fromAdjMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalStateException("must be non null");
        }
        int rowLen = matrix.length, colLen = matrix[0].length;
        g = new int[rowLen][];
        for (int row = 0; row < rowLen; row += 1) {
            int i = 0;
            int[] v = new int[colLen];
            for (int col = 0; col < colLen; col += 1) {
                if (matrix[row][col] == 1) {
                    v[i++] = col;
                }
            }
            g[row] = Arrays.copyOf(v, i);
        }
        return g;
    }

    public int[][] getG() {
        return g;
    }

    public void setG(int[][] g, int max) {
        this.g = g;
        MAX = max;
    }

    public void dfs() {
        dfs(0);
    }

    public void dfs(int v) {
        reset();
        try {
            proceedDFS(v);
        } catch (StackOverflowException ex) {
            ex.printStackTrace();
        }

    }

    private void proceedDFS(int v) throws StackOverflowException {
        used[v] = 1;
        for (int u : g[v]) {
            if (used[u] == 0) {
                p[u] = v;
                proceedDFS(u);
            } else if (used[u] == 1 && p[v] != u) {
                System.out.println("Cycle detected start - " + u + ", end - " + v);
                cycleStart = u;
                cycleEnd = v;
            }
        }
        used[v] = nullVal;
        topo.push(v);
    }

    public void displayCycle() {
        int k = cycleEnd;
        System.out.print("Cycle: ");
        StringBuilder sb = new StringBuilder();
//        sb.append(cycleStart).append(" >- ");
        while (k != cycleStart) {
            sb.append(k).append(" >- ");
            k = p[k];
        }
        sb.append(cycleStart);
        System.out.println(sb.reverse());
    }

    public void displayTopoSort() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < topo.size()) {
            sb.append(topo.peek(index++));
            if (index < topo.size()) {
                sb.append(" -> ");
            }
        }
        System.out.println("TopoSort: " + sb);
    }

    private void proceedArr(int[] arr, int len) {
        if (arr == null || len <= 0) {
            return;
        }
        g = new int[MAX][2];
        int j = 0;
        for (int i = 0; i < len; i += 2) {
            g[j][0] = arr[i];
            if (i + 1 < len) {
                g[j][1] = arr[i + 1];
            } else {
                g[j][1] = -1;
            }
            j += 1;
        }
    }

    private void reset() {
        p = new int[MAX];
        used = new int[MAX];
        topo = new Stack<>(MAX);
        for (int i = 0; i < MAX; i += 1) {
            p[i] = nullVal;
        }
    }
}
