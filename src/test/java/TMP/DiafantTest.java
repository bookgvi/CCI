package TMP;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiafantTest {

    @Test
    public void gcd_test1() {
        int a = 12;
        int b = 6;
        int ans = 6;
        Diafant d = new Diafant();
        int res = d.gcd(a,b);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void gcd_test2() {
        int a = 12;
        int b = 13;
        int ans = 1;
        Diafant d = new Diafant();
        int res = d.gcd(a,b);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void gcd_test3() {
        int a = 42;
        int b = 55;
        int ans = 1;
        Diafant d = new Diafant();
        int res = d.gcd(a,b);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void gcd_test4() {
        int a = 15;
        int b = 840;
        int ans = 15;
        Diafant d = new Diafant();
        int res = d.gcd(a,b);
        Assert.assertEquals(ans, res);
    }


    @Test
    public void lcm_test1() {
        int a = 12;
        int b = 13;
        int ans = 156;
        Diafant d = new Diafant();
        int lcm = d.lcm(a,b);
        Assert.assertEquals(ans, lcm);
    }

    @Test
    public void lcm_test2() {
        int a = 15;
        int b = 840;
        int ans = 840;
        Diafant d = new Diafant();
        int lcm = d.lcm(a,b);
        Assert.assertEquals(ans, lcm);
    }

    @Test
    public void diafant_test1() {
        int a = 42;
        int b = 55;
//        int ans = 1;
        Diafant d = new Diafant();
        int res[] = d.diafant(a,b);
//        Assert.assertEquals(ans, res);
    }
}