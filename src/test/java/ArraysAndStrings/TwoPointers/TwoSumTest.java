package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TwoSumTest {

    @Test
    public void twoSumTest1() {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        int[] res = new int[] {0, 1};
        TwoSum ts = new TwoSum();
        Assert.assertArrayEquals(Arrays.toString(nums), res, ts.twoSum(nums, target));
        Assert.assertArrayEquals(Arrays.toString(nums), res, ts.twoSumSort(nums, target));
        Assert.assertArrayEquals(Arrays.toString(nums), res, ts.twoSumExt(nums, target));
    }

    @Test
    public void twoSumTest2() {
        int[] nums = new int[] {3,2,4};
        int target = 6;
        int[] res = new int[] {1, 2};
        TwoSum ts = new TwoSum();
        Assert.assertArrayEquals(Arrays.toString(nums), res, ts.twoSum(nums, target));
//        Assert.assertArrayEquals(Arrays.toString(nums), res, ts.twoSumSort(nums, target));
        Assert.assertArrayEquals(Arrays.toString(nums), res, ts.twoSumExt(nums, target));
    }

    @Test
    public void twoSumTest3() {
        int[] nums = new int[] {-1,-2,-3,-4,-5};
        int target = -8;
        int[] res = new int[] {2,4};
        TwoSum ts = new TwoSum();
        Assert.assertArrayEquals(Arrays.toString(nums), res, ts.twoSum(nums, target));
//        Assert.assertArrayEquals(Arrays.toString(nums), res, ts.twoSumSort(nums, target));
        Assert.assertArrayEquals(Arrays.toString(nums), res, ts.twoSumExt(nums, target));
    }
}