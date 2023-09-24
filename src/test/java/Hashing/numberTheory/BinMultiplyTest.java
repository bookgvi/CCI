package Hashing.numberTheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class BinMultiplyTest {
    private BinMultiply binMultiply = new BinMultiply();

    @Test
    public void testCalculateWhenPositiveIntegersThenReturnProduct() {
        // Arrange
        int a = 5;
        int b = 4;

        // Act
        long result = binMultiply.calculate(a, b);

        // Assert
        assertEquals(20, result);
    }

    @Test
    public void testCalculateWhenOneInputIsZeroThenReturnZero() {
        // Arrange
        int a = 0;
        int b = 4;

        // Act
        long result = binMultiply.calculate(a, b);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testCalculateWhenBothInputsAreZeroThenReturnZero() {
        // Arrange
        int a = 0;
        int b = 0;

        // Act
        long result = binMultiply.calculate(a, b);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testCalculateWhenOneInputIsNegativeThenReturnNegative() {
        // Arrange
        int a = -5;
        int b = 4;

        // Act
        long result = binMultiply.calculate(a, b);

        // Assert
        assertEquals(-20, result);
    }

    @Test
    public void testCalculateWhenBothInputsAreNegativeThenReturnPositive() {
        // Arrange
        int a = -5;
        int b = -4;

        // Act
        long result = binMultiply.calculate(a, b);

        // Assert
        assertEquals(20, result);
    }
    @Test
    public void testCalculateWhenSecondInputIsNegativeThenReturnNegative() {
        // Arrange
        int a = 5;
        int b = -4;

        // Act
        long result = binMultiply.calculate(a, b);

        // Assert
        assertEquals(-20, result);
    }
}