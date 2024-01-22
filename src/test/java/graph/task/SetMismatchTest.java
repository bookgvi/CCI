package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetMismatchTest {

    private SetMismatch s;

    @Before
    public void setUp() throws Exception {
        s = new SetMismatch();
    }

    @Test
    public void findErrorNums() {
        int[] nums = {1,2,2,4};
        int[] expected = {2,3};
        int[] res = s.findErrorNums(nums);
        assertArrayEquals(expected, res);
    }

    @Test
    public void findErrorNums2() {
        int[] nums2 = {3, 2, 3, 4, 6, 5};
        int[] expected2 = {3, 1};
        int[] result2 = s.findErrorNums(nums2);
        assertArrayEquals(expected2, result2);
    }

    @Test
    public void testFindErrorNums() {
        SetMismatch solution = new SetMismatch();

        // Test Case 1
        int[] nums1 = {1, 2, 2, 4};
        int[] expected1 = {2, 3};
        int[] result1 = solution.findErrorNums(nums1);
        assertArrayEquals(expected1, result1);

        // Test Case 2
        int[] nums2 = {3, 2, 3, 4, 6, 5};
        int[] expected2 = {3, 1};
        int[] result2 = solution.findErrorNums(nums2);
        assertArrayEquals(expected2, result2);


        // Test Case 5: Array with all elements duplicated
        int[] nums5 = {2, 2, 2, 2};
        int[] expected5 = {2, 1};
        int[] result5 = solution.findErrorNums(nums5);
        assertArrayEquals(expected5, result5);

        // Add more test cases as needed
    }

}