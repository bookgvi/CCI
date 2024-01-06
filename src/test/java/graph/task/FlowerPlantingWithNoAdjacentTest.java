package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlowerPlantingWithNoAdjacentTest {
    
    private FlowerPlantingWithNoAdjacent f;
    
    @Before
    public void init() {
        f = new FlowerPlantingWithNoAdjacent();
    }

    @Test
    public void testPath() {
        // Testing when n = 0 and paths is an empty array
        int[][] paths = {{1,2}};
        int[] flowers = f.gardenNoAdj(2, paths);
        assertArrayEquals(new int[]{1,2}, flowers);
    }

    @Test
    public void testValidPaths() {
        // Testing when n = 4 and paths contain two valid paths
        int[][] paths = {{1, 2}, {3, 4}};
        int[] flowers = f.gardenNoAdj(4, paths);
        assertArrayEquals(new int[]{1, 2, 1, 2}, flowers);
    }

    @Test
    public void testPath1() {
        // Testing when n = 5 and paths contain two valid paths and one invalid path
        int[][] paths = {{1, 2}, {3, 4}, {4, 5}};
        int[] flowers = f.gardenNoAdj(5, paths);
        assertArrayEquals(new int[]{1, 2, 1, 2, 1}, flowers);
    }
    @Test
    public void testPath2() {
        // Testing when n = 5 and paths contain two valid paths and one invalid path
        int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
        int[] flowers = f.gardenNoAdj(4, paths);
        assertArrayEquals(new int[]{1, 2, 3, 4}, flowers);
    }
    @Test
    public void testPath3() {
        // Testing when n = 5 and paths contain two valid paths and one invalid path
        int[][] paths = {{3,4},{4,5},{3,2},{5,1},{1,3},{4,2}};
        int[] flowers = f.gardenNoAdj(5, paths);
        assertArrayEquals(new int[]{1,1,2,3,2}, flowers);
    }
}