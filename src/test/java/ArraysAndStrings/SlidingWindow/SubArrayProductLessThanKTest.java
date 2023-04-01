package ArraysAndStrings.SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubArrayProductLessThanKTest {

    @Test
    public void proceed_test() {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        int res = 8;
        SubArrayProductLessThanK s = new SubArrayProductLessThanK();
        Assert.assertEquals(res, s.proceed(nums, k));
        Assert.assertEquals(res, s.proceed2(nums, k));
    }
}