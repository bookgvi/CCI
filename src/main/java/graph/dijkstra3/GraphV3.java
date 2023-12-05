package graph.dijkstra3;

import java.util.*;

public class GraphV3 {

    private final Map<Integer, Set<Edge>> graph;

    public GraphV3(int size) {
        this.graph = new HashMap<>(size);
    }

    public Map<Integer, Set<Edge>> getGraph() {
        return new HashMap<>(graph);
    }

    public void addEdge(int source, int destination, int dist) {
        dist = Math.abs(dist);
        graph.computeIfAbsent(source, k -> new HashSet<>());
        if (source != destination) {
            graph.computeIfAbsent(source, k -> new HashSet<>()).add(new Edge(source, destination, dist));
        }
        graph.putIfAbsent(destination, new HashSet<>());
    }

    public Map<Integer, Integer> dijkstra(int src) {
        Map<Integer, Integer> shortestPathMap = new HashMap<>();
        Map<Integer, Integer> distancesMap = new HashMap<>(graph.size());
        for (Integer node : graph.keySet()) {
            distancesMap.put(node, Integer.MAX_VALUE);
        }
        distancesMap.put(src, 0);
        PriorityQueueCustom3 q = new PriorityQueueCustom3(graph.size(), Comparator.comparingInt(distancesMap::get));
        q.offer(src);
        while(!q.isEmpty()) {
            int cur = q.poll();
            Set<Edge> neighbours = graph.getOrDefault(cur, Collections.emptySet());
            for (Edge neighbour : neighbours) {
                int storedDist = distancesMap.get(neighbour.getDest());
                int dist = neighbour.getWeight() + distancesMap.get(cur);
                if (storedDist > dist) {
                    distancesMap.put(neighbour.getDest(), dist);
                    q.offer(neighbour.getDest());
                    shortestPathMap.put(neighbour.getDest(), cur);
                }
            }
        }
        return shortestPathMap;
    }

}
