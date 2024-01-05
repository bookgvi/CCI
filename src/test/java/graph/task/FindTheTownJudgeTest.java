package graph.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindTheTownJudgeTest {
    @Test
    public void testNoTrustsJudgeNotFound() {
        FindTheTownJudge judgeFinder = new FindTheTownJudge();
        int[][] trust = new int[][]{};
        int n = 1;
        int expected = 1;
        int result = judgeFinder.findJudge(n, trust);
        assertEquals(expected, result);
    }

    @Test
    public void testNoTrustsJudgeFound() {
        FindTheTownJudge judgeFinder = new FindTheTownJudge();
        int[][] trust = new int[][]{};
        int n = 2;
        int expected = -1;
        int result = judgeFinder.findJudge(n, trust);
        assertEquals(expected, result);
    }

    @Test
    public void testTrustsJudgeNotFound() {
        FindTheTownJudge judgeFinder = new FindTheTownJudge();
        int[][] trust = new int[][]{{1, 2}, {2, 3}};
        int n = 3;
        int expected = -1;
        int result = judgeFinder.findJudge(n, trust);
        assertEquals(expected, result);
    }

    @Test
    public void testTrustsJudgeFound() {
        FindTheTownJudge judgeFinder = new FindTheTownJudge();
        int[][] trust = new int[][]{{1, 2}, {2, 3}, {3, 1}};
        int n = 3;
        int expected = -1;
        int result = judgeFinder.findJudge(n, trust);
        assertEquals(expected, result);
    }

    @Test
    public void testTrustsJudgeFound2() {
        FindTheTownJudge judgeFinder = new FindTheTownJudge();
        int[][] trust = new int[][]{{1,3},{2,3},{3,1}};
        int n = 3;
        int expected = -1;
        int result = judgeFinder.findJudge(n, trust);
        assertEquals(expected, result);
    }

    @Test
    public void testTrustsJudgeFound3() {
        FindTheTownJudge judgeFinder = new FindTheTownJudge();
        int[][] trust = new int[][]{{1,2},{2,3}};
        int n = 3;
        int expected = -1;
        int result = judgeFinder.findJudge(n, trust);
        assertEquals(expected, result);
    }

    @Test
    public void testTrustsJudgeFound4() {
        FindTheTownJudge judgeFinder = new FindTheTownJudge();
        int[][] trust = new int[][]{{1,2}};
        int n = 2;
        int expected = 2;
        int result = judgeFinder.findJudge(n, trust);
        assertEquals(expected, result);
    }

    @Test
    public void testTrustsJudgeFound5() {
        FindTheTownJudge judgeFinder = new FindTheTownJudge();
        int[][] trust = new int[][]{{1,3},{2,3}};
        int n = 3;
        int expected = 3;
        int result = judgeFinder.findJudge(n, trust);
        assertEquals(expected, result);
    }

    @Test
    public void testTrustsJudgeFound6() {
        FindTheTownJudge judgeFinder = new FindTheTownJudge();
        int[][] trust = new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}};
        int n = 4;
        int expected = 3;
        int result = judgeFinder.findJudge(n, trust);
        assertEquals(expected, result);
    }

}