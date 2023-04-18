package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeStringsAlternatelyTest {

    @Test
    public void mergeAlternately_test1() {
        String word1 = "abc", word2 = "pqr";
        String ans = "apbqcr";
        MergeStringsAlternately m = new MergeStringsAlternately();
        Assert.assertEquals(ans, m.mergeAlternately(word1, word2));
    }
}