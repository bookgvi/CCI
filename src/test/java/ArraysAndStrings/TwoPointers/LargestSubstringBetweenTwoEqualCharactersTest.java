package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargestSubstringBetweenTwoEqualCharactersTest {

    @Test
    public void maxLengthBetweenEqualCharacters_test1() {
        String s = "ojdncpvyneq";
        int ans = 4;
        LargestSubstringBetweenTwoEqualCharacters l = new LargestSubstringBetweenTwoEqualCharacters();
        Assert.assertEquals(ans, l.maxLengthBetweenEqualCharacters(s));
    }
}