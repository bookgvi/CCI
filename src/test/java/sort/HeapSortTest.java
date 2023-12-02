package sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {
    private HeapSort sorter;

    @BeforeEach
    public void setup() {
        sorter = new HeapSort();
    }

    @Test
    public void testSortWhenGivenUnsortedArrayThenReturnSortedArray() {
        int[] nums = {5, 2, 8, 9, 1, 3};
        int[] expected = {1, 2, 3, 5, 8, 9};
        int[] result = sorter.sort(nums);
        assertArrayEquals(expected, result, "The sorted array does not match the expected array");
    }

    @Test
    public void testSortWhenGivenSortedArrayThenReturnSortedArray() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] result = sorter.sort(nums);
        assertArrayEquals(expected, result, "The sorted array does not match the expected array");
    }

    @Test
    public void testSortWhenGivenDescendingArrayThenReturnSortedArray() {
        int[] nums = {6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] result = sorter.sort(nums);
        assertArrayEquals(expected, result, "The sorted array does not match the expected array");
    }

    @Test
    public void testSortWhenGivenUnsortedArrayWithPositiveAndNegativeIntegersThenReturnSortedArray() {
        int[] nums = {5, -2, 8, -9, 1, -3};
        int[] expected = {-9, -3, -2, 1, 5, 8};
        int[] result = sorter.sort(nums);
        assertArrayEquals(expected, result, "The sorted array does not match the expected array");
    }

    @Test
    public void testSortWhenGivenEmptyArrayThenReturnEmptyArray() {
        int[] nums = {};
        int[] expected = {};
        int[] result = sorter.sort(nums);
        assertArrayEquals(expected, result, "The sorted array does not match the expected array");
    }

    @Test
    public void testSortWhenGivenEmptyArrayThenReturnNull() {
        int[] nums = null;
        int[] expected = null;
        int[] result = sorter.sort(nums);
        assertArrayEquals(expected, result, "The sorted array does not match the expected array");
    }

    @Test
    public void testSortWhenGivenArrayWithDuplicateElementsThenReturnSortedArray() {
        int[] nums = {5, 2, 2, 9, 1, 3, 3, 5};
        int[] expected = {1, 2, 2, 3, 3, 5, 5, 9};
        int[] result = sorter.sort(nums);
        assertArrayEquals(expected, result, "The sorted array does not match the expected array");
    }
}
