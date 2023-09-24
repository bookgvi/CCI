package Hashing.numberTheory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinarySearchTest {
    @Test
    public void testFindWhenValueExistsThenReturnCorrectIndex() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArr = {1, 2, 3, 4, 5};
        int val = 3;
        int result = binarySearch.find(sortedArr, 0, sortedArr.length - 1, val);
        assertEquals(2, result);
    }

    @Test
    public void testFindWhenValueDoesNotExistThenReturnNegative() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArr = {1, 2, 3, 4, 5};
        int val = 6;
        int result = binarySearch.find(sortedArr, 0, sortedArr.length - 1, val);
        assertTrue(result < 0);
    }

    @Test
    public void testFindWhenArrayIsEmptyThenReturnNegative() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArr = {};
        int val = 1;
        int result = binarySearch.find(sortedArr, 0, sortedArr.length - 1, val);
        assertTrue(result < 0);
    }

    @Test
    public void testFindWhenArrayIsEmptyThenReturnMinusOne() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArr = {};
        int val = 1;
        int result = binarySearch.find(sortedArr, val);
        assertEquals(-1, result);
    }

    @Test
    public void testFindWhenArrayHasOneElementThenReturnIndex() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArr = {1};
        int val = 1;
        int result = binarySearch.find(sortedArr, val);
        assertEquals(0, result);
    }

    @Test
    public void testFindWhenArrayHasMultipleElementsAndValueNotFoundThenReturnNegative() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArr = {1, 2, 3, 4, 5};
        int val = 6;
        int result = binarySearch.find(sortedArr, val);
        assertTrue(result < 0);
    }

    @Test
    public void testFindWhenArrayHasMultipleElementsAndValueFoundThenReturnIndex() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArr = {1, 2, 3, 4, 5};
        int val = 3;
        int result = binarySearch.find(sortedArr, val);
        assertEquals(2, result);
    }
}