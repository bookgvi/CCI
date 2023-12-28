package graph.bfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    private Graph graph;

    @BeforeEach
    public void setup() {
        graph = new Graph(2);
    }

    @Test
    public void testAddEdgeWhenDstNotWithinCurrentSizeOfNeighborsArrayThenAddEdgeAndResizeGraph() {
        int src = 0;
        int dst = 2;

        graph.addEdge(src, dst);
        int[][] resultGraph = graph.getGraph();

        assertTrue(resultGraph.length > 2, "Graph should have been resized");
        assertEquals(dst, resultGraph[src][0], "Edge should have been added");
    }

    @Test
    public void testAddEdgeWhenBothSrcAndDstWithinCurrentSizeThenAddEdgeWithoutResize() {
        int src = 0;
        int dst = 1;

        graph.addEdge(src, dst);
        int[][] resultGraph = graph.getGraph();

        assertEquals(2, resultGraph.length, "Graph should not have been resized");
        assertEquals(dst, resultGraph[src][0], "Edge should have been added");
    }

    @Test
    public void testAddEdgeWhenSrcNotWithinCurrentSizeThenAddEdgeAndResizeGraph() {
        int src = 2;
        int dst = 1;

        graph.addEdge(src, dst);
        int[][] resultGraph = graph.getGraph();

        assertTrue(resultGraph.length > 2, "Graph should have been resized");
        assertEquals(dst, resultGraph[src][0], "Edge should have been added");
    }

    @Test
    public void testBfsWhenNodeNotWithinCurrentSizeThenNoOperation() {
        int node = 2;

        graph.bfs(node);
        int[][] resultGraph = graph.getGraph();

        assertEquals(2, resultGraph.length, "Graph should not have been resized");
    }

    @Test
    public void testBfsWhenNodeWithinCurrentSizeThenPerformBfs() {
        int src = 0;
        int dst = 1;

        graph.addEdge(src, dst);
        graph.bfs(src);
        int[][] resultGraph = graph.getGraph();

        assertEquals(2, resultGraph.length, "Graph should not have been resized");
        assertEquals(dst, resultGraph[src][0], "Edge should have been visited");
    }

    @Test
    public void testBfsWhenGraphIsEmptyThenNoOperation() {
        Graph emptyGraph = new Graph(0);
        emptyGraph.bfs(0);
        int[][] resultGraph = emptyGraph.getGraph();

        assertEquals(0, resultGraph.length, "Graph should not have been resized");
    }

    @Test
    public void testBfs() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.bfs(0);

    }

    @Test
    public void testOptional() {
        String nullName = "james";
        String name = Optional.ofNullable(nullName).orElse("john");
        assertEquals("james", name);
        nullName = null;
        name = Optional.ofNullable(nullName).orElse("john");
        assertEquals("john", name);

        AtomicBoolean skipCheck = new AtomicBoolean(false);
        Graph graph1 = null;
        Optional.ofNullable(graph1).filter(Objects::nonNull).map(Graph::getGraph).ifPresent(inst -> skipCheck.set(true));
        assertFalse(skipCheck.get());


        Optional.ofNullable(graph).map(Graph::getGraph).ifPresent(inst -> skipCheck.set(true));
        assertTrue(skipCheck.get());
    }
}