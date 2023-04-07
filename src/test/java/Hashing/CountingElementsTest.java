package Hashing;

import org.junit.Assert;
import org.junit.Test;

public class CountingElementsTest {

    @Test
    public void countElements_test1() {
        int[] arr = new int[]{1,1,1,2,3,3,3,3,2};
        int ans = 5;
        CountingElements c = new CountingElements();
        int res = c.countElements(arr);
        Assert.assertEquals(ans, res);
    }
}