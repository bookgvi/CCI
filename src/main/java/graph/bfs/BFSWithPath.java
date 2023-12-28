package graph.bfs;
import java.util.*;

public class BFSWithPath {
    public List<List<Integer>> bfsWithPath(int[][] graph, int start, int end) {
        List<List<Integer>> pathList = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        // Add the start node to the queue with an empty path
        queue.offer(new ArrayList<>(Collections.singletonList(start)));

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int currentNode = currentPath.get(currentPath.size() - 1);

            // If the current node is the end node, return the path
            if (currentNode == end) {
                pathList.add(currentPath);
            }

            // Mark the current node as visited
            visited[currentNode] = true;

            // Explore the neighbors of the current node
            for (int neighbor : graph[currentNode]) {
                if (!visited[neighbor]) {
                    // Create a new path by appending the neighbor to the current path
                    List<Integer> newPath = new ArrayList<>(currentPath);
                    newPath.add(neighbor);
                    queue.offer(newPath);
                }
            }
        }

        // If no path is found, return an empty list
        return pathList;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},     // Node 0 is connected to nodes 1 and 2
                {3, 4},     // Node 1 is connected to nodes 3 and 4
                {5},        // Node 2 is connected to node 5
                {6, 7},     // Node 3 is connected to nodes 6 and 7
                {8},        // Node 4 is connected to node 8
                {9},        // Node 5 is connected to node 9
                {},         // Node 6 has no outgoing edges
                {},         // Node 7 has no outgoing edges
                {},         // Node 8 has no outgoing edges
                {}          // Node 9 has no outgoing edges
        };

        int start = 0;
        int end = 9;

        BFSWithPath bfs = new BFSWithPath();
        List<List<Integer>> pathList = bfs.bfsWithPath(graph, start, end);

        if (pathList.isEmpty()) {
            System.out.println("No path found from node " + start + " to node " + end);
        } else {
            for (List<Integer> path : pathList) {
                System.out.println("Path from node " + start + " to node " + end + ": " + path);
            }
        }
    }
}