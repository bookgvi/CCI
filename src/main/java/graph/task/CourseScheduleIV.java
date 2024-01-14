package graph.task;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>(numCourses));
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }

        List<Boolean> result = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            boolean[] visited = new boolean[numCourses];
            boolean isP = dfs(query[0], query[1], graph, visited);
            result.add(isP);
        }
        return result;
    }

    private boolean dfs(int src, int dst, List<List<Integer>> graph, boolean[] visited) {
        if (src == dst) {
            return true;
        }
        visited[src] = true;
        for (int adj : graph.get(src)) {
            if (!visited[adj] && dfs(adj, dst, graph, visited)) {
                return true;
            }
        }
        return false;
    }
}
