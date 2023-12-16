package graph.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumJumpsTest {

    private MinimumJumps minimumJumps;

    @BeforeEach
    public void setUp() {
        minimumJumps = new MinimumJumps();
    }

    @Test
    public void testMinimizeJumpsWhenArrayIsEmptyThenReturnZero() {
        int[] arr = new int[]{};
        int result = minimumJumps.minimizeJumps(arr);
        assertEquals(0, result);
    }

    @Test
    public void testMinimizeJumpsWhenArrayHasOneElementThenReturnZero() {
        int[] arr = new int[]{1};
        int result = minimumJumps.minimizeJumps(arr);
        assertEquals(0, result);
    }

    @Test
    public void testMinimizeJumpsWhenArrayHasTwoSameElementsThenReturnOne() {
        int[] arr = new int[]{1, 1};
        int result = minimumJumps.minimizeJumps(arr);
        assertEquals(1, result);
    }

    @Test
    public void testMinimizeJumpsWhenArrayHasTwoDifferentElementsThenReturnTwo() {
        int[] arr = new int[]{1, 2};
        int result = minimumJumps.minimizeJumps(arr);
        assertEquals(1, result);
    }

    @Test
    public void testMinimizeJumpsWhenNoWayToReachLastIndexThenReturnMinusOne() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int result = minimumJumps.minimizeJumps(arr);
        assertEquals(4, result);
    }

    @Test
    public void testMinimizeJumpsWhenThereIsWayToReachLastIndexThenReturnMinimumJumps() {
        int[] arr = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int result = minimumJumps.minimizeJumps(arr);
        assertEquals(3, result);
    }

    @Test
    public void testMinimizeJumpsWhenThereIsWayWithOneDistanceToReachLastIndexThenReturnMinimumJumps() {
        int[] arr = new int[]{7, 6, 9, 6, 9, 6, 9, 7};
        int result = minimumJumps.minimizeJumps(arr);
        assertEquals(1, result);
    }
}