package graph.task;

import java.util.*;

public class NetworkDelayTime {

    private final int INF = (int) 1e9+7;

    public int networkDelayTime(int[][] times, int n, int k) {
        if (times == null || times.length == 0) {
            return -1;
        }
        int[] distances = initDistances(times, k, n);
        List<List<Edge>> adjacencyList = initAdjacency(times, n);
        if (adjacencyList.get(k).isEmpty()) {
            return -1;
        }
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        q.offer(new Edge(k, 0));
        int resWeight = 0;
        while (!q.isEmpty()) {
            Edge curEdge = q.poll();
            int curNode = curEdge.getDestination();
            int curWeight = curEdge.getWeight();
            if (visited[curNode]) {
                continue;
            }
            resWeight = curWeight;
            visited[curNode] = true;
            n -= 1;
            for (Edge edge : adjacencyList.get(curNode)) {
                int destination = edge.getDestination();
                int destinationWeight = edge.getWeight();
                int storedWeight = distances[destination];
                int calcWeight = curWeight + destinationWeight;
                if (calcWeight < storedWeight) {
                    distances[destination] = calcWeight;
                    q.offer(new Edge(destination, calcWeight));
                }
            }
        }
        return n == 0 ? resWeight : -1;
    }

    private List<List<Edge>> initAdjacency(int[][] times, int n) {
        List<List<Edge>> resList = new ArrayList<>(n + 2);
        for (int i = 1; i <= n + 1; i += 1) {
            resList.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            resList.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }
        return resList;
    }

    private int[] initDistances(int[][] times, int k, int n) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, INF);
        distances[k] = 0;
        return distances;
    }

    private static class Edge {
        int destination;
        int weight;

        public int getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
