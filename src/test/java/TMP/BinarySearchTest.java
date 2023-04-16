package TMP;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void proceed_test1() {
        int[] nums = new int[]{1,2,3,5,6};
        int elt = 4;
        int ans = 3;
        BinarySearch b = new BinarySearch();
        int res = b.proceed(nums, elt);
        Assert.assertEquals(ans, -res - 1);
    }

    @Test
    public void proceed_test2() {
        int[] nums = new int[]{1,2,3,5,6};
        int elt = 3;
        int ans = 2;
        BinarySearch b = new BinarySearch();
        int res = b.proceed(nums, elt);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void proceed_test3() {
        int[] nums = new int[]{1,2,3,5,6};
        int elt = 1;
        int ans = 0;
        BinarySearch b = new BinarySearch();
        int res = b.proceed(nums, elt);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void proceed_test4() {
        int[] nums = new int[]{1,2,3,5,6};
        int elt = 2;
        int ans = 1;
        BinarySearch b = new BinarySearch();
        int res = b.proceed(nums, elt);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void proceed_test5() {
        int[] nums = new int[]{1,2,3,5,6};
        int elt = -10;
        int ans = -1;
        BinarySearch b = new BinarySearch();
        int res = b.proceed(nums, elt);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void proceed_test6() {
        int[] nums = new int[]{1,2,3,5,6};
        int elt = 10;
        int ans = -6;
        BinarySearch b = new BinarySearch();
        int res = b.proceed(nums, elt);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void proceed_test7() {
        int[] nums = new int[]{1,2,3,5,6};
        int elt = 6;
        int ans = 4;
        BinarySearch b = new BinarySearch();
        int res = b.proceed(nums, elt);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void proceed_test8() {
        int[] nums = new int[]{1,2,2,2,2,2,3,5,6};
        int elt = 2;
        int ans = 4;
        BinarySearch b = new BinarySearch();
        int res = b.proceed(nums, elt);
        Assert.assertEquals(ans, res);
    }
}