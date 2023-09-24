package Hashing.polynomialHash;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PolynomialHashTest {
    private PolynomialHash polynomialHash;

    @Before
    public void setUp() {
        polynomialHash = new PolynomialHash();
    }

    @Test
    public void testGetPowsWhenCalledThenReturnsCorrectArray() {
        // Arrange
        int p = (int) 1e5 + 3;
        int[] expectedPows = new int[p + 1];
        expectedPows[0] = 1;
        for (int i = 1; i < p; i += 1) {
            expectedPows[i] = expectedPows[i - 1] * p;
        }

        // Act
        int[] actualPows = polynomialHash.getPows();

        // Assert
        Assert.assertArrayEquals(expectedPows, actualPows);
    }

    @Test
    public void testPrefixHashesWhenStringIsNotEmptyThenReturnArrayOfIntegers() {
        // Arrange
        String s = "abc";
        int[] expectedHashes = {1, 200007, -62771038};

        // Act
        int[] actualHashes = polynomialHash.prefixHashes(s);

        // Assert
        Assert.assertArrayEquals(expectedHashes, actualHashes);
    }

    @Test
    public void testPrefixHashesWhenStringIsEmptyThenReturnEmptyArray() {
        // Arrange
        String s = "";

        // Act
        int[] actualHashes = polynomialHash.prefixHashes(s);

        // Assert
        Assert.assertArrayEquals(new int[0], actualHashes);
    }

    @Test
    public void testGetReverseModWhenPositiveIntegerThenReturnReverseMod() {
        // Arrange
        int n = 5;

        // Act
        long actualReverseMod = polynomialHash.getReverseMod(n);

        // Assert
        Assert.assertEquals(-263479912, actualReverseMod);
    }

    @Test
    public void testGetReverseModWhenZeroThenReturnZero() {
        // Arrange
        int n = 0;

        // Act
        long actualReverseMod = polynomialHash.getReverseMod(n);

        // Assert
        Assert.assertEquals(0, actualReverseMod);
    }

    @Test
    public void testGetReverseModWhenNegativeIntegerThenReturnReverseMod() {
        // Arrange
        int n = -5;

        // Act
        long actualReverseMod = polynomialHash.getReverseMod(n);

        // Assert
        Assert.assertEquals(263479912, actualReverseMod);
    }
}