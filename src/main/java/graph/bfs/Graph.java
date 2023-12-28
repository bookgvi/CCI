package graph.bfs;

import Queue.genericQueue.Queue;

import java.util.Arrays;

public class Graph {

    private int[][] graph;
    private int[] visited;
    private int neighboursCount = 0;

    public Graph() {
        this(255);
    }

    public Graph(int size) {
        this.graph = new int[size][size];
        this.visited = new int[size];

        Arrays.fill(graph, new int[1]);
        for (int[] neigh : graph) {
            Arrays.fill(neigh, -1);
        }
        Arrays.fill(visited, -1);
    }

    public int[][] getGraph() {
        return Arrays.copyOf(graph, graph.length);
    }

    public void addEdge(int src, int dst) {
        if (src >= graph.length) {
            growNodes(src);
        }
        if (dst >= graph.length) {
            growNodes(dst);
        }
        if (dst >= graph[src].length) {
            graph[src] = grow(graph[src], src);
        }
        int[] neighbours = graph[src];
        neighbours[neighboursCount++] = dst;
    }

    public void bfs(int node) {
        if (node >= graph.length) {
            return;
        }
        Queue<Integer> q = new Queue<>();
        q.add(node);
        while (!q.empty()) {
            int curNode = q.poll();
            visit(curNode);
            for (int neighbour : graph[curNode]) {
                if (neighbour == -1 || isVisited(neighbour)) {
                    continue;
                }
                System.out.println(curNode + " -> " + neighbour);
                q.add(neighbour);
            }
        }
    }

    private void visit(int neighbour) {
        if (neighbour >= visited.length) {
            visited = grow(visited, neighbour);
        }
        visited[neighbour] = 1;
    }

    private boolean isVisited(int neighbour) {
        if (neighbour >= visited.length) {
            visited = grow(visited, neighbour);
            return false;
        }
        return visited[neighbour] == 1;
    }

    private void growNodes(int size) {
        int oldSize = graph.length;

        int s = Math.max(size + 1, 2);
        int newS = s + (s >>> 1);
        graph = Arrays.copyOf(graph, newS);
        for (; newS >= oldSize; newS -= 1) {
            graph[newS - 1] = new int[1];
            Arrays.fill(graph[newS - 1], -1);
        }
    }

    private int[] grow(int[] arr, int src) {
        int oldSize = arr.length;
        int s = Math.max(src + 1, 2);
        int newS = s + (s >>> 1);
        arr = Arrays.copyOf(arr, newS);
//        Arrays.fill(arr, -1);
        for (; newS >= oldSize; newS -= 1) {
            arr[newS - 1] = -1;
        }
        return arr;
    }
}
