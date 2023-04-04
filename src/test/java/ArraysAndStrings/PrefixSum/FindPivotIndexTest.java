package ArraysAndStrings.PrefixSum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindPivotIndexTest {

    @Test
    public void pivotIndex_test1() {
        int[] nums = new int[]{1,7,3,6,5,6};
        int res = 3;
        FindPivotIndex f = new FindPivotIndex();
        Assert.assertEquals(res, f.pivotIndex(nums));
    }

    @Test
    public void pivotIndex_test2() {
        int[] nums = new int[]{1,2,3};
        int res = -1;
        FindPivotIndex f = new FindPivotIndex();
        Assert.assertEquals(res, f.pivotIndex(nums));
    }

    @Test
    public void pivotIndex_test3() {
        int[] nums = new int[]{-1,-1,0,1,1,0};
        int res = 5;
        FindPivotIndex f = new FindPivotIndex();
        Assert.assertEquals(res, f.pivotIndex(nums));
    }
}