package graphUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphV3Test {

    private GraphV3 graph;

    @BeforeEach
    public void setUp() {
        int[][] adjacency = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        graph = new GraphV3(adjacency);
    }

    @Test
    public void testDfsWhenGraphIsEmptyThenUsedArrayUnchanged() {
        int[][] adjacency = new int[][]{};
        GraphV3 emptyGraph = new GraphV3(adjacency);
        emptyGraph.dfs(0);
        assertArrayEquals(new int[]{}, emptyGraph.getUsed());
    }

    @Test
    public void testDfsWhenGraphHasOneVertexThenUsedArrayUpdatedCorrectly() {
        int[][] adjacency = new int[][]{{0, 0}};
        GraphV3 singleVertexGraph = new GraphV3(adjacency);
        singleVertexGraph.dfs(0);
        assertArrayEquals(new int[]{1}, singleVertexGraph.getUsed());
    }

    @Test
    public void testDfsWhenGraphHasMultipleVerticesThenUsedArrayUpdatedCorrectly() {
        graph.dfs(0);
        assertArrayEquals(new int[]{1, 1, 1, 1, 1}, graph.getUsed());
    }

    @Test
    public void testFindAdjacencyComponentsWhenGraphIsEmptyThenUsedArrayUnchanged() {
        int[][] adjacency = new int[][]{};
        GraphV3 emptyGraph = new GraphV3(adjacency);
        emptyGraph.findAdjacencyComponents();
        assertArrayEquals(new int[]{}, emptyGraph.getUsed());
    }

    @Test
    public void testFindAdjacencyComponentsWhenGraphHasOneVertexThenUsedArrayUpdatedCorrectly() {
        int[][] adjacency = new int[][]{{0, 0}};
        GraphV3 singleVertexGraph = new GraphV3(adjacency);
        singleVertexGraph.findAdjacencyComponents();
        assertArrayEquals(new int[]{1}, singleVertexGraph.getUsed());
    }

    @Test
    public void testFindAdjacencyComponentsWhenGraphHasMultipleVerticesThenUsedArrayUpdatedCorrectly() {
        graph.findAdjacencyComponents();
        assertArrayEquals(new int[]{1, 1, 1, 1, 1}, graph.getUsed());
    }
}