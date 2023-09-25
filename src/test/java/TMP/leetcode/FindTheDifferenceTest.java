package TMP.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindTheDifferenceTest {

    private FindTheDifference findTheDifference;

    @Before
    public void setUp() {
        findTheDifference = new FindTheDifference();
    }

    @Test
    public void testFindTheDifference2WhenStringsAreIdenticalThenReturnZero() {
        // Arrange
        String s = "abcd";
        String t = "abcd";

        // Act
        char result = findTheDifference.findTheDifference2(s, t);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testFindTheDifference2WhenAdditionalCharacterAtEndThenReturnAdditionalCharacter() {
        // Arrange
        String s = "abcd";
        String t = "abcde";

        // Act
        char result = findTheDifference.findTheDifference2(s, t);

        // Assert
        assertEquals('e', result);
    }

    @Test
    public void testFindTheDifference2WhenAdditionalCharacterAtBeginningThenReturnAdditionalCharacter() {
        // Arrange
        String s = "abcd";
        String t = "eabcd";

        // Act
        char result = findTheDifference.findTheDifference2(s, t);

        // Assert
        assertEquals('e', result);
    }

    @Test
    public void testFindTheDifference2WhenAdditionalCharacterInMiddleThenReturnAdditionalCharacter() {
        // Arrange
        String s = "abcd";
        String t = "abecd";

        // Act
        char result = findTheDifference.findTheDifference2(s, t);

        // Assert
        assertEquals('e', result);
    }

    @Test
    public void testFindTheDifferenceWhenAdditionalCharacterAtEndThenReturnAdditionalCharacter() {
        // Arrange
        String s = "abcd";
        String t = "abcde";

        // Act
        char result = findTheDifference.findTheDifference(s, t);

        // Assert
        assertEquals('e', result);
    }

    @Test
    public void testFindTheDifferenceWhenAdditionalCharacterAtBeginningThenReturnAdditionalCharacter() {
        // Arrange
        String s = "abcd";
        String t = "eabcd";

        // Act
        char result = findTheDifference.findTheDifference(s, t);

        // Assert
        assertEquals('e', result);
    }

    @Test
    public void testFindTheDifferenceWhenAdditionalCharacterInMiddleThenReturnAdditionalCharacter() {
        // Arrange
        String s = "abcd";
        String t = "abecd";

        // Act
        char result = findTheDifference.findTheDifference(s, t);

        // Assert
        assertEquals('e', result);
    }
}