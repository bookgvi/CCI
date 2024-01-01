package graph.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssignCookiesTest {
    
    private final AssignCookies a = new AssignCookies();
    @Test
    public void testFindContentChildren_emptyArrays() {
        int[] g = {};
        int[] s = {};
        int expected = 0;
        int result = a.findContentChildren(g, s);
        assertEquals(expected, result);
    }

    @Test
    public void testFindContentChildren_emptyGArray() {
        int[] g = {};
        int[] s = {1, 2, 3};
        int expected = 0;
        int result = a.findContentChildren(g, s);
        assertEquals(expected, result);
    }

    @Test
    public void testFindContentChildren_emptySArray() {
        int[] g = {1, 2, 3};
        int[] s = {};
        int expected = 0;
        int result = a.findContentChildren(g, s);
        assertEquals(expected, result);
    }

    @Test
    public void testFindContentChildren_sameLengthSameValues() {
        int[] g = {1, 2, 3};
        int[] s = {1, 2, 3};
        int expected = 3;
        int result = a.findContentChildren(g, s);
        assertEquals(expected, result);
    }

    @Test
    public void testFindContentChildren_sameLengthDifferentValues() {
        int[] g = {1, 2, 3};
        int[] s = {3, 2, 1};
        int expected = 3;
        int result = a.findContentChildren(g, s);
        assertEquals(expected, result);
    }

    @Test
    public void testFindContentChildren_gMoreElements() {
        int[] g = {1, 2, 3};
        int[] s = {1, 2};
        int expected = 2;
        int result = a.findContentChildren(g, s);
        assertEquals(expected, result);
    }

    @Test
    public void testFindContentChildren_sMoreElements() {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        int expected = 2;
        int result = a.findContentChildren(g, s);
        assertEquals(expected, result);
    }
}