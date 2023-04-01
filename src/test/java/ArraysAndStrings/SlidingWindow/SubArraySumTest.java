package ArraysAndStrings.SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubArraySumTest {

    @Test
    public void proceedTest() {
        int[] nums = new int[] {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;
        SubArraySum s = new SubArraySum();
        Assert.assertEquals(4, s.proceed(nums, k));
    }
}