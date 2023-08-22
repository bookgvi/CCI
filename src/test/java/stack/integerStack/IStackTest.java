package stack.integerStack;

import org.junit.Test;

import static org.junit.Assert.*;

public class IStackTest {

    @Test
    public void testPushWhenValidIntegerThenSizeIncreasesAndHeadIsInteger() {
        // Arrange
        Stack stack = new Stack();
        Integer val = 5;

        // Act
        stack.push(val);

        // Assert
        assertEquals(1, stack.size());
        assertEquals(val, stack.pop());
    }

    @Test
    public void testPushWhenNullThenIllegalStateException() {
        // Arrange
        Stack stack = new Stack();

        // Act
        Exception ex = assertThrows(IllegalStateException.class, () -> {
            stack.push(null);
        });
        assertEquals("null is not proper value", ex.getMessage());
    }

    @Test
    public void testPopWhenStackNotEmptyThenReturnLastPushedInteger() {
        // Arrange
        Stack stack = new Stack();
        Integer val1 = 1;
        Integer val2 = 2;
        stack.push(val1);
        stack.push(val2);

        // Act
        Integer poppedVal = stack.pop();

        // Assert
        assertEquals(val2, poppedVal);
        assertEquals(1, stack.size());
    }

    @Test
    public void testPopWhenStackEmptyThenReturnNull() {
        // Arrange
        Stack stack = new Stack();

        // Act
        Integer poppedVal = stack.pop();

        // Assert
        assertNull(poppedVal);
        assertEquals(0, stack.size());
    }

    @Test
    public void testPopWhenStackHasOneElementThenReturnThatElement() {
        // Arrange
        Stack stack = new Stack();
        Integer val = 3;
        stack.push(val);

        // Act
        Integer poppedVal = stack.pop();

        // Assert
        assertEquals(val, poppedVal);
        assertEquals(0, stack.size());
    }
}