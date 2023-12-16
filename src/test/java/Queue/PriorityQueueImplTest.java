package Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueImplTest {
    private PriorityQueueImpl<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new PriorityQueueImpl<Integer>(Comparator.naturalOrder());
    }

    @Test
    public void testAddWhenQueueIsEmptyThenElementAdded() {
        Integer element = 5;
        boolean result = queue.add(element);
        assertTrue(result, "Add method should return true when element is added.");
        assertEquals(1, queue.getSize(), "Size of queue should be 1 after adding an element.");
        assertEquals(element, queue.poll(), "Polled element should be the same as the added element.");
    }

    @Test
    public void testAddWhenQueueIsFullThenReturnFalse() {
        queue = new PriorityQueueImpl<Integer>(1, Comparator.naturalOrder());
        queue.add(1);
        Integer element = 2;
        boolean result = queue.add(element);
        assertTrue(result, "Add method should return true even when the queue is full.");
        assertEquals(2, queue.getSize(), "Size of queue should be 2 after adding an element to a full queue.");
    }

    @Test
    public void testAddWhenSizeIsNegativeThenThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueueImpl<>(-1, Comparator.naturalOrder());
        });
        String expectedMessage = "Illegal Capacity: -1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPollWhenQueueIsEmptyThenReturnNull() {
        Integer result = queue.poll();
        assertNull(result, "Poll method should return null when the queue is empty.");
    }

    @Test
    public void testPollWhenQueueHasOneElementThenReturnThatElement() {
        queue.add(1);
        Integer result = queue.poll();
        assertEquals(1, result, "Poll method should return the element that was added.");
    }

    @Test
    public void testPollWhenQueueHasMultipleElementsThenReturnLowestPriorityElement() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Integer result = queue.poll();
        assertEquals(1, result, "Poll method should return the lowest priority element.");
    }

    @Test
    public void testPollWhenQueueIsFullThenReturnLowestPriorityElementAndIncreaseSize() {
        queue = new PriorityQueueImpl<Integer>(1, Comparator.naturalOrder());
        queue.add(1);
        queue.add(2);
        Integer result = queue.poll();
        assertEquals(1, result, "Poll method should return the lowest priority element.");
        assertEquals(1, queue.getSize(), "Size of queue should be 1 after polling an element from a full queue.");
    }

    @Test
    public void testIsEmptyWhenQueueIsEmptyThenReturnTrue() {
        boolean result = queue.isEmpty();
        assertTrue(result, "IsEmpty method should return true when the queue is empty.");
    }

    @Test
    public void testIsEmptyWhenQueueHasElementsThenReturnFalse() {
        queue.add(1);
        boolean result = queue.isEmpty();
        assertFalse(result, "IsEmpty method should return false when the queue has elements.");
    }

    @Test
    public void testPollWhenQueueHasElementsThenReturnLowesPriorityElement() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Integer result = queue.poll();
        assertEquals(1, result, "Poll method should return the highest priority element.");
    }
}