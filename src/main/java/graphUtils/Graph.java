package graphUtils;

public class Graph {
    public int[] from(int[] arr) {
        int[] graph = new int[arr.length];
        int index = 0;
        for (int elt : arr) {
            graph[index] = elt;
        }
        return graph;
    }
}
