package TMP.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParenthesisTest {

    @Test
    public void test1() {
        Parenthesis p = new Parenthesis();
        String str = "(())()()((()))";
        boolean res = p.isValidString(str);
        assertTrue(res);
    }

    @Test
    public void test2() {
        Parenthesis p = new Parenthesis();
        String str = ")(())()()((()))";
        boolean res = p.isValidString(str);
        assertFalse(res);
    }

    @Test
    public void test3() {
        Parenthesis p = new Parenthesis();
        String str = "(())()()((())))";
        boolean res = p.isValidString(str);
        assertFalse(res);
    }

    @Test
    public void test4() {
        Parenthesis p = new Parenthesis();
        String str = "";
        boolean res = p.isValidString(str);
        assertTrue(res);
    }

    @Test
    public void test5() {
        Parenthesis p = new Parenthesis();
        String str = "qwe(ew)()()((1+2))";
        boolean res = p.isValidString(str);
        assertTrue(res);
    }

    @Test
    public void test6() {
        Parenthesis p = new Parenthesis();
        String str = "(*)";
        boolean res = p.isValidString(str);
        assertTrue(res);
    }

    @Test
    public void test7() {
        Parenthesis p = new Parenthesis();
        String str = "(*))";
        boolean res = p.isValidString(str);
        assertTrue(res);
    }

}