package graph.dijkstra4;

import Queue.PriorityQueueImpl;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Dijkstra {

    public Map<Node, Node> process(Map<Node, List<Node>> graph, Node start) {
        Set<Node> allNodes = getAllNodes(graph);
        int size = allNodes.size();
        if (size == 0) {
            return new HashMap<>();
        }
        Map<Node, Node> path = new HashMap<>(size);
        Map<Node, Integer> nodeDistMap = getNodeDistMap(allNodes);
        PriorityQueueImpl<Node> q = new PriorityQueueImpl<>(Comparator.comparingInt(Node::getVal));

        nodeDistMap.put(start, 0);
        q.add(start);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            List<Node> adjList = graph.getOrDefault(cur, new ArrayList<>());
            for (Node adj : adjList) {
                int calcDist = nodeDistMap.get(cur) + adj.getWeight();
                int storedDist = nodeDistMap.get(adj);
                if (storedDist > calcDist) {
                    nodeDistMap.put(adj, calcDist);
                    path.put(adj, cur);
                    q.add(adj);
                }
            }
        }
        return path;
    }

    private Map<Node, Integer> getNodeDistMap(Set<Node> allNodes) {
        return allNodes.stream().collect(Collectors.toMap(Function.identity(), Node::getInf));
    }

    private Set<Node> getAllNodes(Map<Node, List<Node>> graph) {
        Set<Node> uniqueNodes = new HashSet<>();
        if (graph != null && graph.size() > 0) {
            uniqueNodes = new HashSet<>(graph.keySet());
            for (Map.Entry<Node, List<Node>> entry : graph.entrySet()) {
                List<Node> nodes = entry.getValue();
                if (nodes == null || nodes.size() < 1) {
                    continue;
                }
                uniqueNodes.addAll(new HashSet<>(nodes));
            }
        }
        return uniqueNodes;
    }

    static class Node {
        private final int val;
        private final int weight;

        Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }

        public int getVal() {
            return val;
        }

        public int getWeight() {
            return weight;
        }

        int getInf() {
            return Integer.MAX_VALUE;
        }

    }
}
