package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsStringTest {

    @Test
    public void reverseWords_test1() {
        String str = "  hello   world  ";
        String ans = "world hello";
        ReverseWordsString r = new ReverseWordsString();
        Assert.assertEquals(ans, r.reverseWords(str));
    }

    @Test
    public void reverseWords_test2() {
        String str = "the sky is blue";
        String ans = "blue is sky the";
        ReverseWordsString r = new ReverseWordsString();
        Assert.assertEquals(ans, r.reverseWords(str));
    }
}