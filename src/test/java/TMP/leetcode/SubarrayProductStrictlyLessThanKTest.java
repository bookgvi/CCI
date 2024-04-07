package TMP.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubarrayProductStrictlyLessThanKTest {
    @Test
    public void test1() {
        int nums[] = {10, 5, 2, 6}, k = 100;
        int exp = 8;
        int res = new SubarrayProductStrictlyLessThanK().numSubarrayProductLessThanK(nums, k);
        assertEquals(exp, res);
    }

    @Test
    public void test2() {
        int nums[] = {1, 2, 3}, k = 0;
        int exp = 0;
        int res = new SubarrayProductStrictlyLessThanK().numSubarrayProductLessThanK(nums, k);
        assertEquals(exp, res);
    }

    @Test
    public void test3() {
        int nums[] = {1, 1, 1}, k = 2;
        int exp = 6;
        int res = new SubarrayProductStrictlyLessThanK().numSubarrayProductLessThanK(nums, k);
        assertEquals(exp, res);
    }
}