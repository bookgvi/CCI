package stack.genericStack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StackTest {

    @Test
    public void testPushWhenElementAddedThenSizeIncreases() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act
        try {
            stack.push(1);
        } catch (StackOverflowException e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(0, stack.size());
    }

    @Test(expected = StackOverflowException.class)
    public void testPushWhenStackFullThenThrowsException() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(1);

        // Act
        stack.push(1);
        stack.push(2); // This should throw StackOverflowException
    }

    @Test(expected = IllegalStateException.class)
    public void testPushWhenNullElementThenThrowsException() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(1);

        // Act
        stack.push(null); // This should throw IllegalStateException
    }

    @Test(expected = IllegalStateException.class)
    public void testPushWhenNullEndMaxSizeIsZeroElementThenThrowsException() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act
        stack.push(null); // This should throw IllegalStateException
    }

    @Test
    public void testPopWhenStackIsNotEmptyThenReturnLastPushedItem() {
        // Arrange
        Stack<Integer> stack = new Stack<>();
        try {
            stack.push(1);
        } catch (StackOverflowException e) {
            e.printStackTrace();
        }

        // Act
        Integer poppedItem = stack.pop();

        // Assert
        assertNull(poppedItem);
        assertEquals(0, stack.size());
    }

    @Test
    public void testPopWhenStackIsEmptyThenReturnNull() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act
        Integer poppedItem = stack.pop();

        // Assert
        assertNull(poppedItem);
        assertEquals(0, stack.size());
    }

    @Test
    public void testPopWhenStackHasMoreThanOneItemThenReturnLastPushedItem() {
        // Arrange
        Stack<Integer> stack = new Stack<>();
        try {
            stack.push(1);
            stack.push(2);
        } catch (StackOverflowException e) {
            e.printStackTrace();
        }

        // Act
        Integer poppedItem = stack.pop();

        // Assert
        assertNull(poppedItem);
        assertEquals(0, stack.size());
    }
}