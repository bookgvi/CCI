package twoPointers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesInSortedArrTest {
    private RemoveDuplicatesInSortedArr removeDuplicatesInSortedArr;

    @Before
    public void setup() {
        removeDuplicatesInSortedArr = new RemoveDuplicatesInSortedArr();
    }

    @Test
    public void testRemoveDuplicatesWhenArrayIsEmptyThenReturnZero() {
        int[] nums = new int[0];
        int result = removeDuplicatesInSortedArr.removeDuplicates(nums);
        assertEquals(0, result, "Expected result is 0 when array is empty");
    }

    @Test
    public void testRemoveDuplicatesWhenArrayHasOneElementThenReturnOne() {
        int[] nums = new int[]{1};
        int result = removeDuplicatesInSortedArr.removeDuplicates(nums);
        assertEquals(1, result, "Expected result is 1 when array has one element");
    }

    @Test
    public void testRemoveDuplicatesWhenArrayHasNoDuplicatesThenReturnLength() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int result = removeDuplicatesInSortedArr.removeDuplicates(nums);
        assertEquals(5, result, "Expected result is the length of the array when array has no duplicates");
    }

    @Test
    public void testRemoveDuplicatesWhenArrayHasDuplicatesThenReturnNumberOfDuplicates() {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int result = removeDuplicatesInSortedArr.removeDuplicates(nums);
        assertEquals(5, result, "Expected result is the number of duplicates when array has duplicates");
    }
}