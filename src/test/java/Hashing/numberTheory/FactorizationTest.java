package Hashing.numberTheory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

public class FactorizationTest {
    private Factorization factorization;

    @Before
    public void setUp() {
        factorization = new Factorization();
    }

    @Test
    public void testGetEulerFuncWhenPrimeNumberThenPrimeMinusOne() {
        // Arrange
        int number = (int) 1e5 + 3;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(number - 1, eulerFunc);
    }

    @Test
    public void testGetEulerFuncWhenCompositeNumberThenLessThanNumber() {
        // Arrange
        int number = 18;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertTrue(eulerFunc < number);
    }

    @Test
    public void testGetEulerFuncWhenOneThenOne() {
        // Arrange
        int number = 1;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(1, eulerFunc);
    }

    @Test
    public void testGetEulerFuncWhenPrimeNumberThenReturnPrimeMinusOne() {
        // Arrange
        int number = 17;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(number - 1, eulerFunc);
    }

    @Test
    public void testGetEulerFuncWhenCompositeNumberThenReturnLessThanNumber() {
        // Arrange
        int number = 18;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertTrue(eulerFunc < number);
    }

    @Test
    public void testGetEulerFuncWhenOneThenReturnOne() {
        // Arrange
        int number = 1;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(1, eulerFunc);
    }

    @Test
    public void testGetEulerFuncAfterFactorization() {
        // Arrange
        int number = 10;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(4, eulerFunc);
    }

    @Test
    public void testGetEulerFuncWithoutFactorization() {
        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(0, eulerFunc);
    }

    @Test
    public void testGetEulerFuncWhenGetFactorizationCalledWithOneThenReturnOne() {
        // Arrange
        int number = 1;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(1, eulerFunc);
    }

    @Test
    public void testGetEulerFuncWhenGetFactorizationCalledWithTwoThenReturnOne() {
        // Arrange
        int number = 2;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(1, eulerFunc);
    }

    @Test
    public void testGetEulerFuncWhenGetFactorizationCalledWithTenThenReturnFour() {
        // Arrange
        int number = 10;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(4, eulerFunc);
    }

    @Test
    public void testGetEulerFuncWhenPrimeNumberThenReturnOne() {
        // Arrange
        int number = 17;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(16, eulerFunc);
    }

    @Test
    public void testGetEulerFuncWhenMultipleFactorsThenReturnLessThanNumber() {
        // Arrange
        int number = 18;
        factorization.getFactorization(number);

        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertTrue(eulerFunc < number);
    }

    @Test
    public void testGetEulerFuncWithoutCallingGetFactorizationThenReturnZero() {
        // Act
        int eulerFunc = factorization.getEulerFunc();

        // Assert
        Assert.assertEquals(0, eulerFunc);
    }

    @Test
    public void testGetFactorizationWhenPositiveIntegerThenReturnFactors() {
        // Arrange
        int number = 18;
        Collection<Integer> expectedFactors = Arrays.asList(2, 3, 3);

        // Act
        Collection<Integer> actualFactors = factorization.getFactorization(number);

        // Assert
        Assert.assertEquals(expectedFactors, actualFactors);
    }

    @Test
    public void testGetFactorizationWhenNegativeIntegerThenReturnEmptyCollection() {
        // Arrange
        int number = -10;
        Collection<Integer> expectedFactors = Arrays.asList();

        // Act
        Collection<Integer> actualFactors = factorization.getFactorization(number);

        // Assert
        Assert.assertEquals(expectedFactors, actualFactors);
    }

    @Test
    public void testGetFactorizationWhenZeroThenReturnEmptyCollection() {
        // Arrange
        int number = 0;
        Collection<Integer> expectedFactors = Arrays.asList();

        // Act
        Collection<Integer> actualFactors = factorization.getFactorization(number);

        // Assert
        Assert.assertEquals(expectedFactors, actualFactors);
    }

    @Test
    public void testGetFactorizationWhenOneThenReturnCollectionWithOne() {
        // Arrange
        int number = 1;
        Collection<Integer> expectedFactors = Arrays.asList(1);

        // Act
        Collection<Integer> actualFactors = factorization.getFactorization(number);

        // Assert
        Assert.assertEquals(expectedFactors, actualFactors);
    }

    @Test
    public void testGetFactorizationWhenTypicalNumberThenCorrectFactors() {
        // Arrange
        int number = 18;
        Collection<Integer> expectedFactors = Arrays.asList(2, 3, 3);

        // Act
        Collection<Integer> actualFactors = factorization.getFactorization(number);

        // Assert
        Assert.assertEquals(expectedFactors, actualFactors);
    }

    @Test
    public void testGetFactorizationWhenPrimeNumberThenOnlyItself() {
        // Arrange
        int number = 17;
        Collection<Integer> expectedFactors = Arrays.asList(17);

        // Act
        Collection<Integer> actualFactors = factorization.getFactorization(number);

        // Assert
        Assert.assertEquals(expectedFactors, actualFactors);
    }

    @Test
    public void testGetFactorizationWhenZeroThenEmpty() {
        // Arrange
        int number = 0;
        Collection<Integer> expectedFactors = Arrays.asList();

        // Act
        Collection<Integer> actualFactors = factorization.getFactorization(number);

        // Assert
        Assert.assertEquals(expectedFactors, actualFactors);
    }

    @Test
    public void testGetFactorizationWhenNegativeThenEmpty() {
        // Arrange
        int number = -10;
        Collection<Integer> expectedFactors = Arrays.asList();

        // Act
        Collection<Integer> actualFactors = factorization.getFactorization(number);

        // Assert
        Assert.assertEquals(expectedFactors, actualFactors);
    }
}