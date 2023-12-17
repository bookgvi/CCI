package graph.dijkstra4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DijkstraTest {
    private Dijkstra dijkstra;

    @BeforeEach
    public void setup() {
        dijkstra = new Dijkstra();
    }

    @Test
    public void testProcessWhenGraphIsEmptyThenReturnEmptyMap() {
        // Arrange
        Map<Dijkstra.Node, List<Dijkstra.Node>> graph = new HashMap<>();
        Dijkstra.Node start = new Dijkstra.Node(1, 1);

        // Act
        Map<Dijkstra.Node, Dijkstra.Node> result = dijkstra.process(graph, start);

        // Assert
        assertTrue(result.isEmpty(), "The result map should be empty when the graph is empty");
    }

    @Test
    public void testProcessWhenGraphIsNotEmptyThenReturnShortestPathMap() {
        // Arrange
        Dijkstra.Node start = new Dijkstra.Node(1, 0);
        Dijkstra.Node node2 = new Dijkstra.Node(2, 1);
        Dijkstra.Node node3 = new Dijkstra.Node(3, 2);
        Dijkstra.Node node4 = new Dijkstra.Node(4, 3);

        Map<Dijkstra.Node, List<Dijkstra.Node>> graph = new HashMap<>();
        graph.put(start, Arrays.asList(node2, node3));
        graph.put(node2, Arrays.asList(node4));
        graph.put(node3, Arrays.asList(node4));
        graph.put(node4, new ArrayList<>());

        // Act
        Map<Dijkstra.Node, Dijkstra.Node> result = dijkstra.process(graph, start);

        // Assert
        assertEquals(3, result.size(), "The result map should contain 3 entries");
        assertEquals(start, result.get(node2), "The shortest path from start to node2 should be start");
        assertEquals(start, result.get(node3), "The shortest path from start to node3 should be start");
        assertEquals(node2, result.get(node4), "The shortest path from start to node4 should be node2");
    }
}