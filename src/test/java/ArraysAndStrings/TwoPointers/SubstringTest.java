package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubstringTest {

    @Test
    public void processedCheck_if_subString() {
        String str = "abcde", subStr = "acd";
        Substring s = new Substring();
        Assert.assertTrue(subStr + " -> " + str, s.processed(str, subStr));
    }
}