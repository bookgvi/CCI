package graph.task;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedundantConnectionTest {


    @Test
    public void testFindRedundantConnection() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] expected = {1, 4};

        RedundantConnection findRedundantConnection = new RedundantConnection();
        int[] result = findRedundantConnection.findRedundantConnection(edges);

        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testFindRedundantConnection_MultipleRedundantEdges() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 2}};
        int[] expected = {1, 2};

        RedundantConnection findRedundantConnection = new RedundantConnection();
        int[] result = findRedundantConnection.findRedundantConnection(edges);

        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testFindRedundantConnection_NoRedundantEdges() {
        int[][] edges = {{1, 2}, {2, 3}, {1, 3}};
        int[] expected = {1, 3};

        RedundantConnection findRedundantConnection = new RedundantConnection();
        int[] result = findRedundantConnection.findRedundantConnection(edges);

        Assert.assertArrayEquals(expected, result);
    }
}
