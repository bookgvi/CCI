package TMP.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FindCommonCharactersTest {

    @Test
    public void test1() {
        String[] words = {"bella","label","roller"};
        List<String> ans = List.of("e","l","l");
        FindCommonCharacters f = new FindCommonCharacters();
        List<String> res = f.commonChars(words);
        assertArrayEquals(ans.toArray(), res.toArray());
    }

    @Test
    public void test2() {
        String[] words = {"cool","lock","cook"};
        List<String> ans = List.of("c","o");
        FindCommonCharacters f = new FindCommonCharacters();
        List<String> res = f.commonChars(words);
        assertArrayEquals(ans.toArray(), res.toArray());
    }
}