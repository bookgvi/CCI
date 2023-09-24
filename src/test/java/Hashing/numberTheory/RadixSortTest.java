package Hashing.numberTheory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RadixSortTest {
    private RadixSort radixSort;

    @Before
    public void setUp() {
        radixSort = new RadixSort();
    }

    @Test
    public void testSortWhenUnsortedArrayThenSortedArray() {
        int[] unsortedArray = {5, 2, 9, -1, 5, 6};
        int[] expectedArray = {-1, 2, 5, 5, 6, 9};
        radixSort.sort(unsortedArray);
        Assert.assertArrayEquals(expectedArray, unsortedArray);
    }

    @Test
    public void testSortWhenSortedArrayThenSameArray() {
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] expectedArray = {1, 2, 3, 4, 5};
        radixSort.sort(sortedArray);
        Assert.assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public void testSortWhenReverseSortedArrayThenSortedArray() {
        int[] reverseSortedArray = {5, 4, 3, 2, 1};
        int[] expectedArray = {1, 2, 3, 4, 5};
        radixSort.sort(reverseSortedArray);
        Assert.assertArrayEquals(expectedArray, reverseSortedArray);
    }

    @Test
    public void testSortWhenArrayWithDuplicatesThenSortedArray() {
        int[] arrayWithDuplicates = {5, 1, 2, 5, 1};
        int[] expectedArray = {1, 1, 2, 5, 5};
        radixSort.sort(arrayWithDuplicates);
        Assert.assertArrayEquals(expectedArray, arrayWithDuplicates);
    }

    @Test
    public void testSortWhenEmptyArrayThenSameArray() {
        int[] emptyArray = {};
        int[] expectedArray = {};
        radixSort.sort(emptyArray);
        Assert.assertArrayEquals(expectedArray, emptyArray);
    }

    @Test
    public void testSortWhenNullArrayThenNull() {
        int[] nullArray = null;
        radixSort.sort(nullArray);
        // No exception should be thrown
    }
}