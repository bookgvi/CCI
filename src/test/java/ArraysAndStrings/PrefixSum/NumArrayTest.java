package ArraysAndStrings.PrefixSum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumArrayTest {

    @Test
    public void sumRange_test1() {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(nums);
        int res = na.sumRange(0, 2);
        Assert.assertEquals(1, res);
        res = na.sumRange(2, 5);
        Assert.assertEquals(-1, res);
        res = na.sumRange(0, 5);
        Assert.assertEquals(-3, res);
    }
}