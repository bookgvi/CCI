package binarySearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinSearchTest {

    @Test
    @DisplayName("Test the 'proceed' method when the value 'k' is present in the 'nums' array.")
    public void testProceedWhenKIsPresentThenReturnIndex() {
        // Arrange
        BinSearch binSearch = new BinSearch();
        int k = 5;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Act
        int result = binSearch.proceed(k, nums);

        // Assert
        assertEquals(4, result, "The index of the 'k' value in the 'nums' array should be 4.");
    }

    @Test
    @DisplayName("Test the 'proceed' method when the value 'k' is not present in the 'nums' array.")
    public void testProceedWhenKIsNotPresentThenReturnNegativeIndex() {
        // Arrange
        BinSearch binSearch = new BinSearch();
        int k = 11;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Act
        int result = binSearch.proceed(k, nums);

        // Assert
        assertEquals(-11, result, "The return value should be -11, which represents the position where the 'k' value should be inserted to maintain the sorted order of the 'nums' array.");
    }

    @Test
    @DisplayName("Test the 'proceed' method when the 'nums' array is empty.")
    public void testProceedWhenNumsIsEmptyThenReturnNegativeIndex() {
        // Arrange
        BinSearch binSearch = new BinSearch();
        int k = 1;
        int[] nums = {};

        // Act
        int result = binSearch.proceed(k, nums);

        // Assert
        assertEquals(-1, result, "The return value should be -1 since the 'k' value cannot be found in an empty array.");
    }
}