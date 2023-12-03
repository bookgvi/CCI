package graph.dijkstra2;

import lombok.Getter;

import java.util.*;

public class Graph {
    private final Map<Node, List<Edge<Node>>> graph;

    public Graph(int size) {
        this.graph = new HashMap<>(size);
    }

    public boolean addEdge(String source, String dest, int weight) {
        if (source == null || source.isEmpty()) {
            return false;
        }
        if (weight < 0) {
            return false;
        }
        Node sourceNode = new Node(source);
        Node destNode = dest == null ? null : new Node(dest);
        Edge<Node> edge = new Edge<>(sourceNode, destNode, weight);
        persistEdge(sourceNode, edge);
        persistEdge(destNode, null);
        return true;
    }

    public void dijkstra(Node sourceNode) {
        Map<Node, Integer> destinationsMap = new HashMap<>();
        for (Map.Entry<Node, List<Edge<Node>>> entry : graph.entrySet()) {
            List<Edge<Node>> neighbours = entry.getValue();
            for (Edge<Node> neighbour : neighbours) {
                destinationsMap.put(neighbour.getDest(), Integer.MAX_VALUE);
            }
        }
        destinationsMap.put(sourceNode, 0);
        PriorityQueueCustom2<Node> q = new PriorityQueueCustom2<>(Comparator.comparingInt(destinationsMap::get));
        q.offer(sourceNode);
        Map<Node, Node> pathMap = new HashMap<>();
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            List<Edge<Node>> neighbours = graph.get(curNode);
            if (neighbours != null) {
                for (Edge<Node> neighbour : neighbours) {
                    int distCurNode = destinationsMap.get(curNode);
                    int dist = distCurNode + neighbour.getWeight();
                    int distDestNode = destinationsMap.get(neighbour.getDest());
                    if (distDestNode > dist) {
                        destinationsMap.put(neighbour.getDest(), dist);
                        q.offer(neighbour.getDest());
                        pathMap.put(neighbour.getDest(), curNode);
                    }
                }
            }
        }

        for (Node curNode : graph.keySet()) {
            Node dest = curNode;
            List<Node> pathArr = new ArrayList<>();
            while (curNode != null) {
                pathArr.add(curNode);
                curNode = pathMap.get(curNode);
            }
            int size = pathArr.size();
            List<Node> pathArrReverse = new ArrayList<>(size);
            for (int i = size - 1; i >=0; i -= 1) {
                pathArrReverse.add(pathArr.get(i));
            }
            System.out.println("Shortest path from " + sourceNode + " to " + dest + ": " + pathArrReverse);
        }
    }

    private void persistEdge(Node node, Edge<Node> edge) {
        if (node == null) {
            return;
        }
        List<Edge<Node>> neighbours = graph.getOrDefault(node, new ArrayList<>());
        if (edge != null) {
            neighbours.add(edge);
        }
        graph.putIfAbsent(node, neighbours);
    }

}
