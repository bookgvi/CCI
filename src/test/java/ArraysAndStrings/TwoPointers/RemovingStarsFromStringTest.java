package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemovingStarsFromStringTest {

    @Test
    public void removeStars_test1() {
        String s = "leet**cod*e";
        String ans = "lecoe";
        RemovingStarsFromString r = new RemovingStarsFromString();
        Assert.assertEquals(ans, r.removeStars(s));
        Assert.assertEquals(ans, r.removeStarsTP(s));
    }

    @Test
    public void removeStars_test2() {
        String s = s = "erase*****";
        String ans = "";
        RemovingStarsFromString r = new RemovingStarsFromString();
        Assert.assertEquals(ans, r.removeStars(s));
        Assert.assertEquals(ans, r.removeStarsTP(s));
    }
}