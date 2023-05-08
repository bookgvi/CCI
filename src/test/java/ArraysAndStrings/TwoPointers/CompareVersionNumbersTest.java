package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompareVersionNumbersTest {

    @Test
    public void compareVersion_test1() {
        String version1 = "1.01", version2 = "1.001";
        int ans = 0;
        CompareVersionNumbers c = new CompareVersionNumbers();
        Assert.assertEquals(ans, c.compareVersion(version1, version2));
    }

    @Test
    public void compareVersion_test2() {
        String version1 = "1.0", version2 = "1.0.0";
        int ans = 0;
        CompareVersionNumbers c = new CompareVersionNumbers();
        Assert.assertEquals(ans, c.compareVersion(version1, version2));
    }

    @Test
    public void compareVersion_test3() {
        String version1 = "0.1", version2 = "1.1";
        int ans = -1;
        CompareVersionNumbers c = new CompareVersionNumbers();
        Assert.assertEquals(ans, c.compareVersion(version1, version2));
    }

    @Test
    public void compareVersion_test4() {
        String version1 = "1.1.1", version2 = "1.1";
        int ans = 1;
        CompareVersionNumbers c = new CompareVersionNumbers();
        Assert.assertEquals(ans, c.compareVersion(version1, version2));
    }

    @Test
    public void compareVersion_test5() {
        String version1 = "1.1", version2 = "1.10";
        int ans = -1;
        CompareVersionNumbers c = new CompareVersionNumbers();
        Assert.assertEquals(ans, c.compareVersion(version1, version2));
    }

    @Test
    public void compareVersion_test6() {
        String version1 = "1.00.1", version2 = "1.0.2";
        int ans = -1;
        CompareVersionNumbers c = new CompareVersionNumbers();
        Assert.assertEquals(ans, c.compareVersion(version1, version2));
    }

    @Test
    public void compareVersion_test7() {
        String version1 = "4.08", version2 = "4.08.01";
        int ans = -1;
        CompareVersionNumbers c = new CompareVersionNumbers();
        Assert.assertEquals(ans, c.compareVersion(version1, version2));
    }
}