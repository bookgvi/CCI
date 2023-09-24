package Hashing.numberTheory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinPowTest {
    private BinPow binPow;

    @Before
    public void setUp() {
        binPow = new BinPow();
    }

    @Test
    public void testPowWhenNormalCaseThenCorrectResult() {
        int n = 2;
        int pow = 3;
        long result = binPow.pow(n, pow);
        assertEquals(8, result);
    }

    @Test
    public void testPowWhenPowerIsZeroThenOne() {
        int n = 2;
        int pow = 0;
        long result = binPow.pow(n, pow);
        assertEquals(1, result);
    }

    @Test
    public void testPowWhenNumberIsZeroThenZero() {
        int n = 0;
        int pow = 3;
        long result = binPow.pow(n, pow);
        assertEquals(0, result);
    }

    @Test
    public void testPowModWhenPositiveInputsThenReturnCorrectResult() {
        int n = 2;
        int pow = 3;
        int mod = 5;
        long result = binPow.powMod(n, pow, mod);
        assertEquals(3, result);
    }

    @Test
    public void testPowModWhenZeroPowerThenReturnOne() {
        int n = 2;
        int pow = 0;
        int mod = 5;
        long result = binPow.powMod(n, pow, mod);
        assertEquals(1, result);
    }

    @Test
    public void testPowModWhenZeroBaseThenReturnZero() {
        int n = 0;
        int pow = 3;
        int mod = 5;
        long result = binPow.powMod(n, pow, mod);
        assertEquals(0, result);
    }

    @Test
    public void testPowModWhenOneModulusThenReturnZero() {
        int n = 2;
        int pow = 3;
        int mod = 1;
        long result = binPow.powMod(n, pow, mod);
        assertEquals(0, result);
    }
}