package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsPalindromeTest {

    @Test
    public void isPalindrome_test1() {
        String s = "A man, a plan, a canal: Panama";
        IsPalindrome i = new IsPalindrome();
        Assert.assertTrue(i.isPalindrome(s));
    }

    @Test
    public void isPalindrome_test2() {
        String s = "0P";
        IsPalindrome i = new IsPalindrome();
        Assert.assertFalse(i.isPalindrome(s));
    }
}