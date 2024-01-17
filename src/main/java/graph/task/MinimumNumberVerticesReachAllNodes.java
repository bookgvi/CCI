package graph.task;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberVerticesReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        boolean[] isReachable = new boolean[n];

        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            isReachable[to] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!isReachable[i]) {
                result.add(i);
            }
        }

        return result;
    }

}
