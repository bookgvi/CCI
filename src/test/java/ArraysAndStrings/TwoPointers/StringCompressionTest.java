package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {

    @Test
    public void compress_test1() {
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        char[] ans = new char[]{'a','2','b','2','c','3'};
        StringCompression s = new StringCompression();
        Assert.assertEquals(ans.length, s.compress(chars));
    }

    @Test
    public void compress_test2() {
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] ans = new char[]{'a','b','1','2'};
        StringCompression s = new StringCompression();
        Assert.assertEquals(ans.length, s.compress(chars));
    }

    @Test
    public void compress_test3() {
        char[] chars = new char[]{'a', 'c', 'a', 'q', 'q', 'c'};
        char[] ans = new char[]{'a','c','a','q','2','c'};
        StringCompression s = new StringCompression();
        Assert.assertEquals(ans.length, s.compress(chars));
    }
}