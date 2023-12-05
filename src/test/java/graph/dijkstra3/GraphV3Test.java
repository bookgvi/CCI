package graph.dijkstra3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GraphV3Test {

    private GraphV3 graphV3;

    @BeforeEach
    public void setup() {
        graphV3 = new GraphV3(5);
    }

    @Test
    public void testAddEdgeWhenValidInputsThenEdgeAdded() {
        // Arrange
        int source = 1;
        int destination = 2;
        int dist = 3;
        Edge expectedEdge = new Edge(source, destination, dist);

        // Act
        graphV3.addEdge(source, destination, dist);

        // Assert
        Map<Integer, Set<Edge>> graph = graphV3.getGraph();
        assertTrue(graph.containsKey(source));
        assertTrue(graph.get(source).contains(expectedEdge));
    }

    @Test
    public void testAddEdgeWhenNegativeDistanceThenAbsoluteValueUsed() {
        // Arrange
        int source = 1;
        int destination = 2;
        int dist = -3;
        Edge expectedEdge = new Edge(source, destination, Math.abs(dist));

        // Act
        graphV3.addEdge(source, destination, dist);

        // Assert
        Map<Integer, Set<Edge>> graph = graphV3.getGraph();
        assertTrue(graph.containsKey(source));
        assertTrue(graph.get(source).contains(expectedEdge));
    }

    @Test
    public void testAddEdgeWhenSameSourceAndDestinationThenNoEdgeAdded() {
        // Arrange
        int source = 1;
        int destination = 1;
        int dist = 3;

        // Act
        graphV3.addEdge(source, destination, dist);

        // Assert
        Map<Integer, Set<Edge>> graph = graphV3.getGraph();
        assertTrue(graph.containsKey(source));
        assertFalse(graph.get(source).stream().anyMatch(edge -> edge.getSource() == edge.getDest()));
    }

    @Test
    public void testAddEdgeWhenSameEdgeAlreadyAddedThenNoEdgeAdded() {
        // Arrange
        int source = 1;
        int destination = 2;
        int dist = 3;

        // Act
        graphV3.addEdge(source, destination, dist);
        graphV3.addEdge(source, destination, dist);

        // Assert
        Map<Integer, Set<Edge>> graph = graphV3.getGraph();
        assertTrue(graph.containsKey(source));
        assertFalse(graph.get(source).stream().anyMatch(edge -> edge.getSource() == edge.getDest()));
    }

    @Test
    public void testDijkstraWhenSourceNodeNotPresentThenEmptyMap() {
        // Arrange
        graphV3.addEdge(2, 3, 1);
        int source = 1;

        // Act
        Map<Integer, Integer> shortestPathMap = graphV3.dijkstra(source);

        // Assert
        assertTrue(shortestPathMap.isEmpty());
    }

    @Test
    public void testDijkstraWhenNoPathFromSourceToAnyNodeThenMapWithSourceNodeAndZeroValue() {
        // Arrange
        graphV3.addEdge(1, 2, 1);
        graphV3.addEdge(2, 3, 1);
        int source = 4;

        // Act
        Map<Integer, Integer> shortestPathMap = graphV3.dijkstra(source);

        // Assert
        assertNull(shortestPathMap.get(source));
    }

    @Test
    public void testDijkstraWhenPathFromSourceToDestinationThenMapWithDestinationNodeAndDistanceValue() {
        // Arrange
        graphV3.addEdge(1, 2, 1);
        graphV3.addEdge(2, 3, 1);
        int source = 1;
        int destination = 3;

        // Act
        Map<Integer, Integer> shortestPathMap = graphV3.dijkstra(source);

        // Assert
        assertTrue(shortestPathMap.containsKey(destination));
        assertEquals(2, shortestPathMap.get(destination));
    }

    @Test
    public void testDijkstraWhenPathFromSourceToMultipleDestinationsThenMapWithDestinationNodesAndDistanceValues() {
        // Arrange
        graphV3.addEdge(1, 2, 1);
        graphV3.addEdge(1, 3, 2);
        graphV3.addEdge(2, 4, 3);
        graphV3.addEdge(3, 4, 1);
        int source = 1;

        // Act
        Map<Integer, Integer> shortestPathMap = graphV3.dijkstra(source);

        // Assert
        assertEquals(3, shortestPathMap.size());
        assertTrue(shortestPathMap.containsKey(2));
        assertTrue(shortestPathMap.containsKey(3));
        assertTrue(shortestPathMap.containsKey(4));
        assertEquals(3, shortestPathMap.get(4));
        assertEquals(1, shortestPathMap.get(3));
    }

    @Test
    public void testDijkstraSuccess2() {
        graphV3.addEdge(0, 1, 5);
        graphV3.addEdge(0, 4, 3);
        graphV3.addEdge(1, 4, 7);
        graphV3.addEdge(1, 3, 3);
        graphV3.addEdge(1, 2, 3);
        graphV3.addEdge(2, 3, 5);
        graphV3.addEdge(2, 4, 11);
        int source = 0;
        Map<Integer, Integer> shortestPathMap = graphV3.dijkstra(source);
        assertEquals(4, shortestPathMap.size());
    }
}