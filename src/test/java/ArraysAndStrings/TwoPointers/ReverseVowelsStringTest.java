package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseVowelsStringTest {

    @Test
    public void reverseVowels_test1() {
        String s = "leetcode";
        String ans = "leotcede";
        ReverseVowelsString r = new ReverseVowelsString();
        Assert.assertEquals(ans, r.reverseVowels(s));
    }
}