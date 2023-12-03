package graph.dijkstra2;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;

public class GraphTest {

    @Test
    public void testAddEdgeWhenSourceIsNullThenReturnFalse() {
        Graph graph = new Graph(5);
        boolean result = graph.addEdge(null, "B", 10);
        Assertions.assertFalse(result);
    }

    @Test
    public void testAddEdgeWhenSourceIsEmptyThenReturnFalse() {
        Graph graph = new Graph(5);
        boolean result = graph.addEdge("", "B", 10);
        Assertions.assertFalse(result);
    }

    @Test
    public void testAddEdgeWhenWeightIsNegativeThenReturnFalse() {
        Graph graph = new Graph(5);
        boolean result = graph.addEdge("A", "B", -10);
        Assertions.assertFalse(result);
    }

    @Test
    public void testAddEdgeWhenSourceDestinationAndWeightAreValidThenReturnTrue() {
        Graph graph = new Graph(5);
        boolean result = graph.addEdge("A", "B", 10);
        Assertions.assertTrue(result);
    }

    @Test
    public void testAddEdgeWhenDestinationIsNullThenReturnTrue() {
        Graph graph = new Graph(5);
        boolean result = graph.addEdge("A", null, 10);
        Assertions.assertTrue(result);
    }

    @Test
    public void testAddSomeEdgesToGraph() {
        Graph graph = new Graph(5);
        boolean res = true;
        boolean result1 = graph.addEdge("A", "B", 10);
        res &= result1;
        boolean result2 = graph.addEdge("A", "C", 3);
        res &= result2;
        boolean result3 = graph.addEdge("B", "D", 10);
        res &= result3;
        boolean result4 = graph.addEdge("C", "D", 11);
        res &= result4;
        boolean result5 = graph.addEdge("D", "E", 2);
        res &= result5;

        Assertions.assertTrue(res);
    }

    @Test
    public void testDijkstra() {
        Graph graph = new Graph(5);
        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 13);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "D", 11);
        graph.addEdge("D", "E", 2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        graph.dijkstra(new Node("A"));

        String expectedOutput = "Shortest path from Node{title='A'} to Node{title='A'}: [Node{title='A'}]\n" +
                "Shortest path from Node{title='A'} to Node{title='B'}: [Node{title='A'}, Node{title='B'}]\n" +
                "Shortest path from Node{title='A'} to Node{title='C'}: [Node{title='A'}, Node{title='C'}]\n" +
                "Shortest path from Node{title='A'} to Node{title='D'}: [Node{title='A'}, Node{title='B'}, Node{title='D'}]\n" +
                "Shortest path from Node{title='A'} to Node{title='E'}: [Node{title='A'}, Node{title='B'}, Node{title='D'}, Node{title='E'}]\n";

        Assertions.assertEquals(expectedOutput, String.valueOf(outContent));
    }
}