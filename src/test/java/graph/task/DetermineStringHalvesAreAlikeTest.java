package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetermineStringHalvesAreAlikeTest {

   private DetermineStringHalvesAreAlike d;

   @Before
   public void init() {
       d = new DetermineStringHalvesAreAlike();
   }

    @Test
    public void halvesAreAlikeTest() {
       String s = "book";
       boolean res = d.halvesAreAlike(s);
       assertTrue(res);
    }

    @Test
    public void halvesAreAlikeTest2() {
        String s = "booktest";
        boolean res = d.halvesAreAlike(s);
        assertFalse(res);
    }

    @Test
    public void halvesAreAlikeTest3() {
       String s = "boOOok";
       boolean res = d.halvesAreAlike(s);
       assertTrue(res);
    }

    @Test
    public void halvesAreAlikeTest4() {
       String s = "oO";
       boolean res = d.halvesAreAlike(s);
       assertTrue(res);
    }

    @Test
    public void halvesAreAlikeTest5() {
       String s = "boOk";
       boolean res = d.halvesAreAlike(s);
       assertTrue(res);
    }

    @Test
    public void halvesAreAlikeTest6() {
       String s = "AbCdEfGh";
       boolean res = d.halvesAreAlike(s);
       assertTrue(res);
    }
}