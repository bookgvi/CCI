package graph.task;

import java.util.*;

public class PathMaximumProbability_dijkstra {


    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Node>[] graph = new List[n];
        double[] dist = new double[n];

        dist[start_node] = 1;

        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0, len = edges.length; i < len; ++i) {
            int[] edge = edges[i];
            double weight = succProb[i];
            graph[edge[0]].add(new Node(edge[1], weight));
            graph[edge[1]].add(new Node(edge[0], weight));
        }

        PriorityQueue<Node> maxPQ = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        Node startNode = new Node(start_node, dist[start_node]);
        maxPQ.add(startNode);

        boolean[] visited = new boolean[n];

        while (!maxPQ.isEmpty()) {
            Node cur = maxPQ.poll();
            int currNode = cur.dst;
            double currProb = cur.probability;

            if (currNode == end_node) {
                return currProb;
            }

            if (visited[currNode]) {
                continue;
            }

            visited[currNode] = true;

            for (Node adj : graph[cur.dst]) {
                double storedWeight = dist[adj.dst];
                double newWeight = dist[cur.dst] * adj.probability;
                if (newWeight > storedWeight) {
                    dist[adj.dst] = newWeight;
                    maxPQ.add(new Node(adj.dst, dist[adj.dst]));
                }
            }
        }
        return 0.0;
    }

    static class Node {
        int dst;
        double probability;

        public Node(int dst, double probability) {
            this.dst = dst;
            this.probability = probability;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return dst == node.dst && Double.compare(probability, node.probability) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dst, probability);
        }
    }
}
