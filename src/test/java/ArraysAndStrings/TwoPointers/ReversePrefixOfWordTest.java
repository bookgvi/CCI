package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReversePrefixOfWordTest {

    @Test
    public void reversePrefix() {
        String word = "abcdefd";
        char ch = 'd';
        String res = "dcbaefd";
        ReversePrefixOfWord r = new ReversePrefixOfWord();
        Assert.assertEquals(res, r.reversePrefix(word, ch));
    }
}