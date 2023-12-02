package graph.dijkstra;

import java.util.*;

public class Graph<T> {
    private final List<Edge<Node<T>>> graph;
    private final List<T> visited;
    private final Map<Node<T>, List<Edge<Node<T>>>> childrenMap;

    public Graph(int size) {
        graph = new ArrayList<>(size);
        visited = new ArrayList<>(size);
        childrenMap = new HashMap<>(size);
    }

    public List<Edge<Node<T>>> getGraph() {
        return new ArrayList<>(graph);
    }

    public Map<Node<T>, List<Edge<Node<T>>>> getChildrenMap() {
        return childrenMap;
    }

    public void displayNodes() {
        for (Edge<Node<T>> edge : graph) {
            System.out.println(edge.getSource() + "->" + edge.getDestination().getT() + " (" + edge.getWeight() + ")");
        }
    }

    public List<Edge<Node<T>>> addEdge(Edge<Node<T>> edge) {
        graph.add(edge);
        Node<T> source = edge.getSource();
        Node<T> dest = edge.getDestination();
        persistChild(source, edge);
        persistChild(dest, null);
        return new ArrayList<>(graph);
    }

    public List<Edge<Node<T>>> addEdge(Node<T> source, Node<T> dest, int weight) {
        Edge<Node<T>> edge = new Edge<>(source, dest, weight);
        graph.add(edge);
        persistChild(source, edge);
        persistChild(dest, null);
        return new ArrayList<>(graph);
    }

    public void dijkstra(Node<T> source) {
        final Integer INF = Integer.MAX_VALUE;
        Map<Node<T>, Integer> distanceMap = new HashMap<>();
        for (Map.Entry<Node<T>, List<Edge<Node<T>>>> entry : childrenMap.entrySet()) {
            Node<T> node = entry.getKey();
            distanceMap.put(node, INF);
        }

        distanceMap.put(source, 0);
        PriorityQueue<Node<T>> queue = new PriorityQueue<>(Comparator.comparingInt(distanceMap::get));
        queue.add(source);
        while(!queue.isEmpty()) {
            Node<T> curNode = queue.poll();
            List<Edge<Node<T>>> children = childrenMap.get(curNode);
            for (Edge<Node<T>> edge : children) {
                Node<T> dest = edge.getDestination();
                int distance = distanceMap.get(curNode) + edge.getWeight();
                if (distance < distanceMap.get(dest)) {
                    distanceMap.put(dest, distance);
                    queue.add(dest);
                }
            }
        }
        for (Edge<Node<T>> edge : graph) {
            Node<T> node = edge.getDestination();
            System.out.println("Shortest distance from " + source + " to " + node + ": " + distanceMap.get(node));
        }
    }

    private void persistChild(Node<T> source, Edge<Node<T>> dest) {
        if (source == null) {
            return;
        }
        List<Edge<Node<T>>> tmpChildrenList = childrenMap.getOrDefault(source, new ArrayList<>());
        if (dest != null) {
            tmpChildrenList.add(dest);
        }
        childrenMap.putIfAbsent(source, tmpChildrenList);
    }

}
