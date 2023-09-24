package Hashing.numberTheory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GCDTest {

    @Test
    public void testGetGCDWhenOneNumberIsPrimeThenReturnPrimeNumber() {
        // Arrange
        GCD gcd = new GCD();
        int a = 14;
        int b = 7; // prime number

        // Act
        int result = gcd.getGCD(a, b);

        // Assert
        assertEquals(b, result);
    }

    @Test
    public void testGetGCDWhenBothNumbersIsPrimeThenReturnOne() {
        // Arrange
        GCD gcd = new GCD();
        int a = 14;
        int b = 7; // prime number

        // Act
        int result = gcd.getGCD(a, b);

        // Assert
        assertEquals(b, result);
    }

    @Test
    public void testGetGCDWhenOneIsMultipleOfOtherThenReturnSmallerNumber() {
        // Arrange
        GCD gcd = new GCD();
        int a = 3;
        int b = 9; // multiple of a

        // Act
        int result = gcd.getGCD(a, b);

        // Assert
        assertEquals(a, result);
    }

    @Test
    public void testGetGCDWhenTwoEqualNumbersThenReturnSameNumber() {
        // Arrange
        GCD gcd = new GCD();
        int a = 5;
        int b = 5; // equal to a

        // Act
        int result = gcd.getGCD(a, b);

        // Assert
        assertEquals(a, result);
    }

    @Test
    public void testGetGCDWhenGCDIsNotOneOrEitherNumberThenReturnCorrectGCD() {
        // Arrange
        GCD gcd = new GCD();
        int a = 18;
        int b = 24; // GCD is not 1 or either of the numbers

        // Act
        int result = gcd.getGCD(a, b);

        // Assert
        assertEquals(6, result); // GCD of 18 and 24 is 6
    }
}