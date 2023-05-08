package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumIIInputArrayIsSortedTest {

    @Test
    public void twoSum_test1() {
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
        int[] ans = new int[]{1,2};
        TwoSumIIInputArrayIsSorted t = new TwoSumIIInputArrayIsSorted();
        int[] res = t.twoSum(numbers, target);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void twoSum_test2() {
        int[] numbers = new int[]{2,3,4};
        int target = 6;
        int[] ans = new int[]{1,3};
        TwoSumIIInputArrayIsSorted t = new TwoSumIIInputArrayIsSorted();
        int[] res = t.twoSum(numbers, target);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void twoSum_test3() {
        int[] numbers = new int[]{-1,0};
        int target = -1;
        int[] ans = new int[]{1,2};
        TwoSumIIInputArrayIsSorted t = new TwoSumIIInputArrayIsSorted();
        int[] res = t.twoSum(numbers, target);
        Assert.assertArrayEquals(ans, res);
    }
}