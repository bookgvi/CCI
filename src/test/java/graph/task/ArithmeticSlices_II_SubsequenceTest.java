package graph.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticSlices_II_SubsequenceTest {

    @Test
    public void numberOfArithmeticSlicesTest1() {
        int[] nums = {7,7,7,7,7};
        int expected = 16;
        ArithmeticSlices_II_Subsequence a = new ArithmeticSlices_II_Subsequence();
        int count = a.numberOfArithmeticSlices(nums);
        assertEquals(expected, count);
    }

}