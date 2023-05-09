package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

public class FindDuplicateNumberTest {

    @Test
    public void findDuplicate_test1() {
        int[] nums = new int[]{1, 3, 4, 2, 2, 5, 6};
        int ans = 2;
        FindDuplicateNumber f = new FindDuplicateNumber();
        int res = f.findDuplicate(nums);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void findDuplicate_test2() {
        int[] nums = new int[]{3, 1, 3, 4, 2};
        int ans = 3;
        FindDuplicateNumber f = new FindDuplicateNumber();
        int res = f.findDuplicate(nums);
        Assert.assertEquals(ans, res);
    }
}