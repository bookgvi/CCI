package ArraysAndStrings.PrefixSum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindTheHighestAltitudeTest {

    @Test
    public void largestAltitude_test1() {
        int[] gain = new int[]{-5,1,5,0,-7};
        int ans = 1;
        FindTheHighestAltitude f = new FindTheHighestAltitude();
        Assert.assertEquals(ans, f.largestAltitude(gain));
    }

    @Test
    public void largestAltitude_test2() {
        int[] gain = new int[]{-4,-3,-2,-1,4,3,2};
        int ans = 0;
        FindTheHighestAltitude f = new FindTheHighestAltitude();
        Assert.assertEquals(ans, f.largestAltitude(gain));
    }
}