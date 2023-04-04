package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsStringIIITest {

    @Test
    public void reverseWords_test1() {
        String s = "Let's take LeetCode contest";
        String reversedStr = "s'teL ekat edoCteeL tsetnoc";
        ReverseWordsStringIII rs = new ReverseWordsStringIII();
        String res = rs.reverseWords(s);
        Assert.assertEquals(reversedStr, res);
    }

    @Test
    public void reverseWords_test2() {
        String s = "L";
        String reversedStr = "L";
        ReverseWordsStringIII rs = new ReverseWordsStringIII();
        String res = rs.reverseWords(s);
        Assert.assertEquals(reversedStr, res);
    }
}