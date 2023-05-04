package TMP;

import org.junit.Assert;
import org.junit.Test;

public class GCDTest {

    @Test
    public void evklid_test1() {
        int a = 6, b = 10;
        int ans = 2;
        GCD g = new GCD();
        int res = g.evklid(a, b);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void evklid_test2() {
        int a = 5, b = 11;
        int ans = 1;
        GCD g = new GCD();
        int res = g.evklid(a, b);
        Assert.assertEquals(ans, res);
    }
}