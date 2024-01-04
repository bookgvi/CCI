package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumNumberOperationsMakeArrayEmptyTest {

    private MinimumNumberOperationsMakeArrayEmpty m = new MinimumNumberOperationsMakeArrayEmpty();

    @Before
    public void init() {
        m = new MinimumNumberOperationsMakeArrayEmpty();
    }

    @Test
    public void testMinOperations_noConsecutiveElements() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = -1;
        assertEquals(expected, m.minOperations(nums));
    }

    @Test
    public void testMinOperations_consecutiveElements() {
        int[] nums = {1, 2, 1, 3, 4, 2, 3};
        int expected = -1;
        assertEquals(expected, m.minOperations(nums));
    }

    @Test
    public void testMinOperations_allElementsEqual() {
        int[] nums = {1, 1, 1, 1, 1};
        int expected = 2;
        assertEquals(expected, m.minOperations(nums));
    }

    @Test
    public void testMinOperations_consecutiveElementsAtBeginning() {
        int[] nums = {2, 2, 3, 4, 5};
        int expected = -1;
        assertEquals(expected, m.minOperations(nums));
    }

    @Test
    public void testMinOperations1() {
        int[] nums = {2,3,3,2,2,4,2,3,4};
        int expected = 4;
        assertEquals(expected, m.minOperations(nums));
    }
    @Test
    public void testMinOperations2() {
        int[] nums = {1,1,1,1,1,1};
        int expected = 2;
        assertEquals(expected, m.minOperations(nums));
    }
    @Test
    public void testMinOperations3() {
        int[] nums = {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12};
        int expected = 7;
        assertEquals(expected, m.minOperations(nums));
    }
}
