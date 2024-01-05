package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MostStonesRemovedWithSameRowColumnTest {

    private MostStonesRemovedWithSameRowColumn.MostStonesRemovedWithSameRowColumnDJS m;

    @Before
    public void init() {
        m = new MostStonesRemovedWithSameRowColumn.MostStonesRemovedWithSameRowColumnDJS();
    }

    @Test
    public void testRemoveStones() {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 2}};
        int expectedCount = 3;

        int res = m.removeStones(stones);
        assertEquals(expectedCount, res);
    }
    @Test
    public void testRemoveStones2() {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int expectedCount = 5;

        int res = m.removeStones(stones);
        assertEquals(expectedCount, res);
    }
    @Test
    public void testRemoveStones3() {
        int[][] stones = {{0, 0}};
        int expectedCount = 0;

        int res = m.removeStones(stones);
        assertEquals(expectedCount, res);
    }
    @Test
    public void testRemoveStones4() {
        int[][] stones = {{3,2},{3,1},{4,4},{1,1},{0,2},{4,0}};
        int expectedCount = 4;

        int res = m.removeStones(stones);
        assertEquals(expectedCount, res);
    }
}