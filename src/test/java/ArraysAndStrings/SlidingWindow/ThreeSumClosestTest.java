package ArraysAndStrings.SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSumClosestTest {

    @Test
    public void threeSumClosest_test1() {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        int ans = 2;
        ThreeSumClosest t = new ThreeSumClosest();
        Assert.assertEquals(ans, t.threeSumClosest(nums, target));
    }

    @Test
    public void threeSumClosest_test2() {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 10;
        int ans = 2;
        ThreeSumClosest t = new ThreeSumClosest();
        Assert.assertEquals(ans, t.threeSumClosest(nums, target));
    }

    @Test
    public void threeSumClosest_test3() {
        int[] nums = new int[]{1,1,1,0};
        int target = -100;
        int ans = 2;
        ThreeSumClosest t = new ThreeSumClosest();
        Assert.assertEquals(ans, t.threeSumClosest(nums, target));
    }

    @Test
    public void threeSumClosest_test4() {
        int[] nums = new int[]{4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        int ans = -2;
        ThreeSumClosest t = new ThreeSumClosest();
        Assert.assertEquals(ans, t.threeSumClosest(nums, target));
    }
}