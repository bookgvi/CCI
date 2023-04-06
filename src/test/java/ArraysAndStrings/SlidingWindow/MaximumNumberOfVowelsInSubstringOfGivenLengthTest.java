package ArraysAndStrings.SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumNumberOfVowelsInSubstringOfGivenLengthTest {

    @Test
    public void maxVowels_test1() {
        String s = "abciiidef";
        int k = 3;
        int ans = 3;
        MaximumNumberOfVowelsInSubstringOfGivenLength m = new MaximumNumberOfVowelsInSubstringOfGivenLength();
        Assert.assertEquals(ans, m.maxVowels(s, k));
    }

    @Test
    public void maxVowels_test2() {
        String s = "aeiou";
        int k = 2;
        int ans = 2;
        MaximumNumberOfVowelsInSubstringOfGivenLength m = new MaximumNumberOfVowelsInSubstringOfGivenLength();
        Assert.assertEquals(ans, m.maxVowels(s, k));
    }

    @Test
    public void maxVowels_test3() {
        String s = "leetcode";
        int k = 3;
        int ans = 2;
        MaximumNumberOfVowelsInSubstringOfGivenLength m = new MaximumNumberOfVowelsInSubstringOfGivenLength();
        Assert.assertEquals(ans, m.maxVowels(s, k));
    }

    @Test
    public void maxVowels_test4() {
        String s = "tryhard";
        int k = 4;
        int ans = 1;
        MaximumNumberOfVowelsInSubstringOfGivenLength m = new MaximumNumberOfVowelsInSubstringOfGivenLength();
        Assert.assertEquals(ans, m.maxVowels(s, k));
    }
}