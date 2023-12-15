package Queue.simpleQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueImplTest {

    private QueueImpl<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueImpl<>();
    }

    @Test
    public void testAddWhenQueueIsEmptyThenElementAdded() {
        // Arrange
        Integer element = 1;

        // Act
        boolean isAdded = queue.add(element);

        // Assert
        assertTrue(isAdded, "Element should be added");
        assertEquals(1, queue.getSize(), "Size of queue should be 1 after adding an element");
        assertEquals(element, queue.poll(), "The added element should be the same as the polled element");
    }

    @Test
    public void testAddWhenQueueIsNotEmptyThenElementAdded() {
        // Arrange
        Integer firstElement = 1;
        Integer secondElement = 2;
        queue.add(firstElement);

        // Act
        boolean isAdded = queue.add(secondElement);

        // Assert
        assertTrue(isAdded, "Element should be added");
        assertEquals(2, queue.getSize(), "Size of queue should be 2 after adding a second element");
        assertEquals(firstElement, queue.poll(), "The first added element should be the same as the first polled element");
        assertEquals(secondElement, queue.poll(), "The second added element should be the same as the second polled element");
    }

    @Test
    public void testOfferWhenQueueIsEmptyThenElementAdded() {
        // Arrange
        Integer element = 1;

        // Act
        boolean isAdded = queue.offer(element);

        // Assert
        assertTrue(isAdded, "Element should be added");
        assertEquals(1, queue.getSize(), "Size of queue should be 1 after offering an element");
        assertEquals(element, queue.poll(), "The offered element should be the same as the polled element");
    }

    @Test
    public void testPollWhenQueueIsEmptyThenReturnNull() {
        // Act
        Integer polledElement = queue.poll();

        // Assert
        assertNull(polledElement, "Polled element should be null when queue is empty");
    }

    @Test
    public void testIsEmptyWhenQueueIsEmptyThenReturnTrue() {
        // Act
        boolean isEmpty = queue.isEmpty();

        // Assert
        assertTrue(isEmpty, "Queue should be empty");
    }

    @Test
    public void testIsEmptyWhenQueueIsNotEmptyThenReturnFalse() {
        // Arrange
        Integer element = 1;
        queue.add(element);

        // Act
        boolean isEmpty = queue.isEmpty();

        // Assert
        assertFalse(isEmpty, "Queue should not be empty");
    }

    @Test
    public void testReverseWhenQueueIsNotEmptyThenReversed() {
        // Arrange
        Integer firstElement = 1;
        Integer secondElement = 2;
        Integer thirdElement = 3;
        queue.add(firstElement);
        queue.add(secondElement);
        queue.add(thirdElement);

        // Act
        queue.reverse();

        // Assert
        assertEquals(thirdElement, queue.poll(), "The third added element should be the same as the first polled element after reverse");
        assertEquals(secondElement, queue.poll(), "The second added element should be the same as the second polled element after reverse");
        assertEquals(firstElement, queue.poll(), "The first added element should be the same as the third polled element after reverse");
    }

    @Test
    public void testReverseWhenQueueIsEmptyThenEmpty() {
        // Act
        queue.reverse();

        // Assert
        assertTrue(queue.isEmpty(), "Queue should be empty after reverse");
    }
}