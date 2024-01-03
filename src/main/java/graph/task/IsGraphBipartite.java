package graph.task;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length < 1) {
            return false;
        }
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        boolean res = true;
        for (int v = 0; v < n; v += 1) {
            if (color[v] == -1) {
                res &= bfs(v, graph, color);
            }
        }
        return res;
    }

    private boolean bfs(int v, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        color[v] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (cur >= graph.length) {
                continue;
            }
            for (int adj : graph[cur]) {
                if (color[adj] == -1) {
                    color[adj] = 1 - color[cur];
                    q.offer(adj);
                } else if (color[cur] == color[adj]) {
                    return false;
                }
            }
        }
        return true;
    }
}
