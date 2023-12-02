package graph.dijkstra;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class GraphTest {

    private Graph<String> graph;

    @BeforeEach
    public void setUp() {
        graph = new Graph<>(100);
    }

    @Test
    public void testAddEdge() {
        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");

        graph.addEdge(nodeA, nodeB, 5);
        graph.addEdge(nodeA, nodeC, 3);

        List<Edge<Node<String>>> edges = graph.getGraph();
        Assertions.assertEquals(2, edges.size());

        Edge<Node<String>> edge1 = edges.get(0);
        Assertions.assertEquals(nodeA, edge1.getSource());
        Assertions.assertEquals(nodeB, edge1.getDestination());
        Assertions.assertEquals(5, edge1.getWeight());

        Edge<Node<String>> edge2 = edges.get(1);
        Assertions.assertEquals(nodeA, edge2.getSource());
        Assertions.assertEquals(nodeC, edge2.getDestination());
        Assertions.assertEquals(3, edge2.getWeight());
    }

    @Test
    public void testGetChildrenMap() {
        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");

        graph.addEdge(nodeA, nodeB, 5);
        graph.addEdge(nodeA, nodeC, 3);

        Map<Node<String>, List<Edge<Node<String>>>> childrenMap = graph.getChildrenMap();
        Assertions.assertEquals(3, childrenMap.size());

        List<Edge<Node<String>>> childrenA = childrenMap.get(nodeA);
        Assertions.assertEquals(2, childrenA.size());

    }

    @Test
    public void testDijkstra() {

        // Add nodes to the graph
        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");

        // Add edges to the graph
        graph.addEdge(nodeA, nodeB, 5);
        graph.addEdge(nodeA, nodeC, 3);
        graph.addEdge(nodeB, nodeD, 2);
        graph.addEdge(nodeC, nodeD, 1);
        graph.addEdge(nodeD, nodeE, 4);

        // Run Dijkstra's algorithm starting from node A
        graph.dijkstra(nodeA);
    }

    // Add more test methods as needed

}