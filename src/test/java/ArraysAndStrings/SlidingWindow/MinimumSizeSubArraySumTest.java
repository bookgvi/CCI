package ArraysAndStrings.SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumSizeSubArraySumTest {

    @Test
    public void minSubArrayLen_test1() {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        int res = 2;
        MinimumSizeSubArraySum m = new MinimumSizeSubArraySum();
        Assert.assertEquals(res, m.minSubArrayLen(target, nums));
    }

    @Test
    public void minSubArrayLen_test2() {
        int[] nums = new int[]{1,4,4};
        int target = 4;
        int res = 1;
        MinimumSizeSubArraySum m = new MinimumSizeSubArraySum();
        Assert.assertEquals(res, m.minSubArrayLen(target, nums));
    }

    @Test
    public void minSubArrayLen_test3() {
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int target = 11;
        int res = 0;
        MinimumSizeSubArraySum m = new MinimumSizeSubArraySum();
        Assert.assertEquals(res, m.minSubArrayLen(target, nums));
    }

    @Test
    public void minSubArrayLen_test4() {
        int[] nums = new int[]{};
        int target = 11;
        int res = 0;
        MinimumSizeSubArraySum m = new MinimumSizeSubArraySum();
        Assert.assertEquals(res, m.minSubArrayLen(target, nums));
    }

    @Test
    public void minSubArrayLen_test5() {
        int[] nums = new int[]{11};
        int target = 11;
        int res = 1;
        MinimumSizeSubArraySum m = new MinimumSizeSubArraySum();
        Assert.assertEquals(res, m.minSubArrayLen(target, nums));
    }
}