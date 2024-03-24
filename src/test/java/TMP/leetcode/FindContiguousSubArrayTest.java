package TMP.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindContiguousSubArrayTest {

    private FindContiguousSubArray f;

    @Before
    public void init() {
        f = new FindContiguousSubArray();
    }

    @Test
    public void proceedTest1() {
        int[] binNums = {1,1,1,1,0,1,1};
        int expected = 4;
        int res = f.proceed(binNums);
        assertEquals(expected, res);
    }

    @Test
    public void proceedTest2() {
        int[] binNums = {0,1,1};
        int expected = 2;
        int res = f.proceed(binNums);
        assertEquals(expected, res);
    }

    @Test
    public void proceedTest3() {
        int[] binNums = {0,1,0,0,1,1};
        int expected = 2;
        int res = f.proceed(binNums);
        assertEquals(expected, res);
    }

    @Test
    public void proceedTest4() {
        int[] binNums = {};
        int expected = 0;
        int res = f.proceed(binNums);
        assertEquals(expected, res);
    }

    @Test
    public void proceedTest5() {
        int[] binNums = {0};
        int expected = 0;
        int res = f.proceed(binNums);
        assertEquals(expected, res);
    }

    @Test
    public void proceedTest6() {
        int[] binNums = {0, 0};
        int expected = 0;
        int res = f.proceed(binNums);
        assertEquals(expected, res);
    }

    @Test
    public void proceedTest7() {
        int[] binNums = {1};
        int expected = 1;
        int res = f.proceed(binNums);
        assertEquals(expected, res);
    }
    @Test
    public void proceedTest8() {
        int[] binNums = {1,1,1,1,1,1,1,1};
        int expected = binNums.length;
        int res = f.proceed(binNums);
        assertEquals(expected, res);
    }

    @Test
    public void proceedTest9() {
        int[] binNums = {1,0,1,0,1};
        int expected = 1;
        int res = f.proceed(binNums);
        assertEquals(expected, res);
    }

}