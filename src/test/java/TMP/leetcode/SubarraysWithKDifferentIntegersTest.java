package TMP.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubarraysWithKDifferentIntegersTest {
    @Test
    public void testAllSameElements() {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 1;
        assertEquals(15, subarraysWithKDistinct(nums, k));
    }

    @Test
    public void testKGreaterThanUniqueElements() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 10;
        assertEquals(0, subarraysWithKDistinct(nums, k));
    }

    @Test
    public void testKEqualToUniqueElements() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        assertEquals(1, subarraysWithKDistinct(nums, k));
    }

    @Test
    public void testGeneralCase() {
        int[] nums = {1, 2, 1, 3, 4, 1, 2};
        int k = 3;
        assertEquals(6, subarraysWithKDistinct(nums, k));
    }

    @Test
    public void testGeneralCase1() {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        assertEquals(7, subarraysWithKDistinct(nums, k));
    }

    public void testGeneralCase2() {
        int[] nums = {1,2,1,3,4};
        int k = 3;
        assertEquals(3, subarraysWithKDistinct(nums, k));
    }

    private int subarraysWithKDistinct(int[] nums, int k) {
        return new SubarraysWithKDifferentIntegers().subarraysWithKDistinct(nums, k);
    }
}