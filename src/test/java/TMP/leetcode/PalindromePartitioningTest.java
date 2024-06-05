package TMP.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PalindromePartitioningTest {

    @Test
    public void isPalindromeTest1() {
        PalindromePartitioning p = new PalindromePartitioning();
        String s = "aaa";
        boolean res = p.isPalindrome(s);
        assertTrue(res);
        List<List<String>> ans = p.partition(s);
    }

    @Test
    public void isPalindromeTest2() {
        PalindromePartitioning p = new PalindromePartitioning();
        String s = "aaaa";
        boolean res = p.isPalindrome(s);
        assertTrue(res);
        List<List<String>> ans = p.partition(s);
    }

    @Test
    public void isPalindromeTest3() {
        PalindromePartitioning p = new PalindromePartitioning();
        String s = "aabaa";
        boolean res = p.isPalindrome(s);
        assertTrue(res);
        List<List<String>> ans = p.partition(s);
    }

    @Test
    public void isPalindromeTest4() {
        PalindromePartitioning p = new PalindromePartitioning();
        String s = "aabbaa";
        boolean res = p.isPalindrome(s);
        assertTrue(res);
        List<List<String>> ans = p.partition(s);
    }

    @Test
    public void isPalindromeTest5() {
        PalindromePartitioning p = new PalindromePartitioning();
        String s = "aabbaaa";
        boolean res = p.isPalindrome(s);
        assertFalse(res);
        List<List<String>> ans = p.partition(s);
    }

    @Test
    public void isPalindromeTest6() {
        PalindromePartitioning p = new PalindromePartitioning();
        String s = "a";
        boolean res = p.isPalindrome(s);
        assertTrue(res);
        List<List<String>> ans = p.partition(s);
    }
}