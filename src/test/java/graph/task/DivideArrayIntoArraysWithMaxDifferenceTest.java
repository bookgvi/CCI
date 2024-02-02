package graph.task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DivideArrayIntoArraysWithMaxDifferenceTest {

    @Test
    public void testDivideArray() {
        DivideArrayIntoArraysWithMaxDifference divider = new DivideArrayIntoArraysWithMaxDifference();

        // Test case 1: nums = [1, 2, 3, 4, 5, 6], k = 1
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int k1 = 1;
        int[][] expected1 = {{1, 2, 3}, {4, 5, 6}};
        assertArrayEquals(expected1, divider.divideArray(nums1, k1));

        // Test case 2: nums = [3, 8, 12, 15, 18, 21], k = 5
        int[] nums2 = {3, 8, 12, 15, 18, 21};
        int k2 = 5;
        int[][] expected2 = {{3, 8, 12}, {15, 18, 21}};
        assertArrayEquals(expected2, divider.divideArray(nums2, k2));

        // Test case 3: nums = [10, 20, 30, 40, 50, 60], k = 10
        int[] nums3 = {10, 20, 30, 40, 50, 60};
        int k3 = 10;
        int[][] expected3 = {{10, 20, 30}, {40, 50, 60}};
        assertArrayEquals(expected3, divider.divideArray(nums3, k3));

        // Test case 4: nums = [5, 10, 15, 20, 25, 30], k = 3
        int[] nums4 = {5, 10, 15, 20, 25, 30};
        int k4 = 3;
        int[][] expected4 = {{5, 10, 15}, {20, 25, 30}};
        assertArrayEquals(expected4, divider.divideArray(nums4, k4));

        // Test case 5: nums = [1, 2, 3, 4, 5, 6], k = 2
        int[] nums5 = {1, 2, 3, 4, 5, 6};
        int k5 = 2;
        int[][] expected5 = {{1, 2, 3}, {4, 5, 6}};
        assertArrayEquals(expected5, divider.divideArray(nums5, k5));

        // Test case 6: nums = [1, 2, 3, 4, 5, 6], k = 0
        int[] nums6 = {1, 2, 3, 4, 5, 6};
        int k6 = 2;
        int[][] expected6 = {};
        assertArrayEquals(expected6, divider.divideArray(nums6, k6));

        // Test case 7: nums = [1, 2, 3, 4, 5, 6], k = 10
        int[] nums7 = {1, 2, 3, 4, 5, 6};
        int k7 = 10;
        int[][] expected7 = {{1, 2, 3, 4, 5, 6}};
        assertArrayEquals(expected7, divider.divideArray(nums7, k7));
    }
}