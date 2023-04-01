package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PalindromeTest {

    @Test
    public void isStringPalindrome() {
        Map<String, Boolean> stringsForTest = new HashMap<>();
        stringsForTest.put("asddsa", true);
        stringsForTest.put("a", true);
        stringsForTest.put(null, false);
        stringsForTest.put("aa", true);
        stringsForTest.put("ab", false);
        stringsForTest.put("Aa", false);
        stringsForTest.put("123454321", true);
        stringsForTest.put("", false);
        
        Palindrome p = new Palindrome();
        for (Map.Entry<String, Boolean> strEntry : stringsForTest.entrySet()) {
            boolean isPalindrome = p.isStringPalindrome(strEntry.getKey());
            Assert.assertEquals("Test for " + strEntry.getKey(), strEntry.getValue(), isPalindrome);
        }
    }
}