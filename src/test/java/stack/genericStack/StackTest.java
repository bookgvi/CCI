package stack.genericStack;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPushWhenValidValueThenSizeIncreases() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);
        int initialSize = stack.size();

        // Act
        stack.push(5);
        int finalSize = stack.size();

        // Assert
        assertEquals(initialSize + 1, finalSize);
    }

    @Test(expected = IllegalStateException.class)
    public void testPushWhenNullValueThenExceptionThrown() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);

        // Act
        stack.push(null);
    }

    @Test(expected = StackOverflowException.class)
    public void testPushWhenStackFullThenExceptionThrown() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(1);

        // Act
        stack.push(1);
        stack.push(2);
    }

    @Test(expected = StackOverflowException.class)
    public void testPushWhenStackIsZeroSizeThenExceptionThrown() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act
        stack.push(1);
    }

    @Test
    public void testPopWhenStackIsEmptyThenReturnNull() {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);

        // Act
        Integer result = stack.pop();

        // Assert
        assertNull(result);
    }

    @Test
    public void testPopWhenStackHasOneElementThenReturnElement() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);
        stack.push(5);

        // Act
        Integer result = stack.pop();

        // Assert
        assertEquals(Integer.valueOf(5), result);
    }

    @Test
    public void testPopWhenStackHasMultipleElementsThenReturnLastPushedElement() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);
        stack.push(5);
        stack.push(10);

        // Act
        Integer result = stack.pop();

        // Assert
        assertEquals(Integer.valueOf(10), result);
    }

    @Test
    public void testPopWhenStackHasReachedMaxSizeThenReturnLastPushedElement() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(2);
        stack.push(5);
        stack.push(10);

        // Act
        Integer result = stack.pop();

        // Assert
        assertEquals(Integer.valueOf(10), result);
    }

    @Test
    public void testReverseWhenElementsPushedThenOrderReversed() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act
        stack.reverse();

        // Assert
        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(3), stack.pop());
    }

    @Test
    public void testReverseWhenStackEmptyThenRemainEmpty() {
        // Arrange
        Stack<Integer> stack = new Stack<>(3);

        // Act
        stack.reverse();

        // Assert
        assertEquals(0, stack.size());
    }

    @Test
    public void testReverseWhenOneElementThenRemainSame() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(3);
        stack.push(1);

        // Act
        stack.reverse();

        // Assert
        assertEquals(Integer.valueOf(1), stack.pop());
    }

    @Test
    public void testFindWhenStackIsEmptyThenReturnMinusOne() {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);

        // Act
        int result = stack.find(5);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testFindWhenValueNotInStackThenReturnMinusOne() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act
        int result = stack.find(5);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testFindWhenValueInStackThenReturnPosition() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act
        int result = stack.find(2);

        // Assert
        assertEquals(1, result);
        assertEquals(3, (int) stack.peek());
    }

    @Test
    public void testFindWhenMultipleInstancesInStackThenReturnFirstPosition() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(3);

        // Act
        int result = stack.find(2);

        // Assert
        assertEquals(1, result);
        assertEquals(3, (int) stack.peek());
    }

    @Test
    public void testPeekWhenStackIsEmptyThenReturnNull() {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);

        // Act
        Integer result = stack.peek();

        // Assert
        assertNull(result);
    }

    @Test
    public void testPeekWhenStackHasOneElementThenReturnThatElement() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);
        stack.push(5);

        // Act
        Integer result = stack.peek();

        // Assert
        assertEquals(Integer.valueOf(5), result);
    }

    @Test
    public void testPeekWhenStackHasMultipleElementsThenReturnLastPushedElement() throws StackOverflowException {
        // Arrange
        Stack<Integer> stack = new Stack<>(10);
        stack.push(5);
        stack.push(10);

        // Act
        Integer result = stack.peek();

        // Assert
        assertEquals(Integer.valueOf(10), result);
    }
}