package TMP;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromArrayTest {

    @Test
    public void process_test1() {
        int[] nums = new int[]{2,2,1,1,3,3,4,4,6,6,9,9,9,3,4,5,6,0};
        int[] ans = new int[]{0,5};
        RemoveDuplicatesFromArray r = new RemoveDuplicatesFromArray();
        int[] res = r.process(nums);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void process_test2() {
        int[] nums = new int[]{-1, -2, -3, -3,2,2,1,1,3,3,4,4,6,6,9,9,9,3,4,5,6,0};
        int[] ans = new int[]{-2, -1, 0, 5};
        RemoveDuplicatesFromArray r = new RemoveDuplicatesFromArray();
        int[] res = r.process(nums);
        Assert.assertArrayEquals(ans, res);
    }
}