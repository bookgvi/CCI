package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseOnlyLettersTest {

    @Test
    public void reverseOnlyLetters_test1() {
        String s = "ab-cd";
        String ans = "dc-ba";
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        String res = r.reverseOnlyLetters(s);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void reverseOnlyLetters_test2() {
        String s = "a-bC-dEf-ghIj";
        String ans = "j-Ih-gfE-dCba";
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        String res = r.reverseOnlyLetters(s);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void reverseOnlyLetters_test3() {
        String s = "Test1ng-Leet=code-Q!";
        String ans = "Qedo1ct-eeLg=ntse-T!";
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        String res = r.reverseOnlyLetters(s);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void reverseOnlyLetters_test4() {
        String s = "123";
        String ans = "123";
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        String res = r.reverseOnlyLetters(s);
        Assert.assertEquals(ans, res);
    }
}