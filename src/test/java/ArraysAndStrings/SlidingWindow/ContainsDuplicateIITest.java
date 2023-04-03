package ArraysAndStrings.SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicateIITest {

    @Test
    public void containsNearbyDuplicate_test1() {
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        boolean ans = true;
        ContainsDuplicateII c = new ContainsDuplicateII();
        Assert.assertEquals(ans, c.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void containsNearbyDuplicate_test2() {
        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        boolean ans = true;
        ContainsDuplicateII c = new ContainsDuplicateII();
        Assert.assertEquals(ans, c.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void containsNearbyDuplicate_test3() {
        int[] nums = new int[]{1,2,3,1,2,3};
        int k = 2;
        boolean ans = false;
        ContainsDuplicateII c = new ContainsDuplicateII();
        Assert.assertEquals(ans, c.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void containsNearbyDuplicate_test4() {
        int[] nums = new int[]{1};
        int k = 2;
        boolean ans = false;
        ContainsDuplicateII c = new ContainsDuplicateII();
        Assert.assertEquals(ans, c.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void containsNearbyDuplicate_test5() {
        int[] nums = new int[]{99, 99};
        int k = 2;
        boolean ans = true;
        ContainsDuplicateII c = new ContainsDuplicateII();
        Assert.assertEquals(ans, c.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void containsNearbyDuplicate_test6() {
        int[] nums = new int[]{4,1,2,3,1,5};
        int k = 3;
        boolean ans = true;
        ContainsDuplicateII c = new ContainsDuplicateII();
        Assert.assertEquals(ans, c.containsNearbyDuplicate(nums, k));
    }
}