package Hashing;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UncommonWordsFromTwoSentencesTest {

    @Test
    public void uncommonFromSentences1_test1() {
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        String[] ans = new String[]{"sweet","sour"};
        UncommonWordsFromTwoSentences u = new UncommonWordsFromTwoSentences();
        Assert.assertArrayEquals(ans, u.uncommonFromSentences1(s1, s2));
    }
}