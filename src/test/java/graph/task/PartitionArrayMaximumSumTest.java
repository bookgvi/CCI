package graph.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionArrayMaximumSumTest {
    @Test
    public void testLargestSumAfterPartitioning1() {
        PartitionArrayMaximumSum solution = new PartitionArrayMaximumSum();
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int expected = 84;
        int result = solution.maxSumAfterPartitioning(arr, k);
        assertEquals(expected, result);
    }

    @Test
    public void testLargestSumAfterPartitioning2() {
        PartitionArrayMaximumSum solution = new PartitionArrayMaximumSum();
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int expected = 83;
        int result = solution.maxSumAfterPartitioning(arr, k);
        assertEquals(expected, result);
    }


}