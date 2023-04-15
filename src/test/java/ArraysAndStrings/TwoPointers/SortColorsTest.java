package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortColorsTest {

    @Test
    public void sortColors_test1() {
        int[] nums = new int[]{2,0,2,1,1,0};
        int[] ans = new int[]{0,0,1,1,2,2};
        SortColors s = new SortColors();
        s.sortColors(nums);
        Assert.assertArrayEquals(ans, nums);
    }
}