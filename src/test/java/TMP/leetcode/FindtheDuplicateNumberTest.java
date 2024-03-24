package TMP.leetcode;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FindtheDuplicateNumberTest {

    @Test
    public void testFindDuplicate_DuplicateElement() {
        int[] nums = {1, 2, 3, 4, 2};
        int expected = 2;
        int actual = new FindtheDuplicateNumber().findDuplicate(nums);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindDuplicate_DuplicateElements() {
        int[] nums = {1, 2, 3, 3};
        int expected = 3;
        int actual = new FindtheDuplicateNumber().findDuplicate(nums);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindDuplicate_DuplicateElements2() {
        int[] nums = {1,1};
        int expected = 1;
        int actual = new FindtheDuplicateNumber().findDuplicate(nums);
        Assertions.assertEquals(expected, actual);
    }

}