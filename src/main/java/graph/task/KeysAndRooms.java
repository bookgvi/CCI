package graph.task;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        q.offer(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            n -= 1;
            for (int adj : rooms.get(cur)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    q.offer(adj);
                }
            }
        }
        return n == 0;
    }
}
