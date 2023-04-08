package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionTwoArraysTest {

    @Test
    public void intersection_test1() {
        int[] nums1 = new int[]{1,22,22,1};
        int[] nums2 = new int[]{22,22};
        int[] ans = new int[]{22};
        IntersectionTwoArrays i = new IntersectionTwoArrays();
        Assert.assertArrayEquals(ans, i.intersection(nums1, nums2));
    }

    @Test
    public void intersection_test2() {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] ans = new int[]{4,9};
        IntersectionTwoArrays i = new IntersectionTwoArrays();
        Assert.assertArrayEquals(ans, i.intersection(nums1, nums2));
    }

    @Test
    public void binPow() {
        int n = 10, pow = 5;
        int ans = 100000;
        IntersectionTwoArrays i = new IntersectionTwoArrays();
        Assert.assertEquals(ans, i.binPow(n, pow));
    }
}