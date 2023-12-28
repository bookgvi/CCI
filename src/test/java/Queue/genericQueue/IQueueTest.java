package Queue.genericQueue;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class IQueueTest {

    @Test
    public void testPeekWhenQueueIsEmptyThenReturnNull() {
        Queue<Integer> queue = new Queue<>();
        Integer result = queue.peek();
        assertNull(result);
    }

    @Test
    public void testPeekWhenQueueHasOneElementThenReturnThatElement() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        Integer result = queue.peek();
        assertNotNull(result);
        assertEquals(Integer.valueOf(1), result);
    }

    @Test
    public void testPeekWhenQueueHasMultipleElementsThenReturnHeadElement() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Integer result = queue.peek();
        assertNotNull(result);
        assertEquals(Integer.valueOf(1), result);
    }

    @Test
    public void testPollWhenQueueNotEmptyThenReturnCorrectValue() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        Integer result = queue.poll();
        assertNotNull(result);
        assertEquals(Integer.valueOf(1), result);
        assertEquals(0, queue.size());
    }

    @Test
    public void testPollWhenQueueEmptyThenReturnNull() {
        Queue<Integer> queue = new Queue<>();
        Integer result = queue.poll();
        assertNull(result);
        assertEquals(0, queue.size());
    }

    @Test
    public void testPollWhenMultipleElementsThenReturnFirstElement() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Integer result = queue.poll();
        assertNotNull(result);
        assertEquals(Integer.valueOf(1), result);
        assertEquals(2, queue.size());
    }

    @Test
    public void testAddWhenQueueIsEmptyThenSizeIncreasesAndHeadAndTailAreSet() throws Exception {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        assertEquals(1, queue.size());
        Field headField = Queue.class.getDeclaredField("head");
        Field tailField = Queue.class.getDeclaredField("tail");
        headField.setAccessible(true);
        tailField.setAccessible(true);
        assertNotNull(headField.get(queue));
        assertNotNull(tailField.get(queue));
        assertEquals(headField.get(queue), tailField.get(queue));
    }

    @Test
    public void testAddWhenQueueIsNotEmptyThenSizeIncreasesAndTailIsSetButHeadRemainsUnchanged() throws Exception {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        Field headField = Queue.class.getDeclaredField("head");
        headField.setAccessible(true);
        Object oldHead = headField.get(queue);
        queue.add(2);
        assertEquals(2, queue.size());
        Field tailField = Queue.class.getDeclaredField("tail");
        tailField.setAccessible(true);
        assertNotNull(tailField.get(queue));
        assertNotEquals(headField.get(queue), tailField.get(queue));
        assertEquals(oldHead, headField.get(queue));
    }

    @Test
    public void testReverseWhenQueueIsNotEmptyThenElementsAreInReverseOrder() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.reverse();
        assertEquals(Integer.valueOf(3), queue.poll());
        assertEquals(Integer.valueOf(2), queue.poll());
        assertEquals(Integer.valueOf(1), queue.poll());
    }

    @Test
    public void testReverseWhenQueueIsEmptyThenStateRemainsUnchanged() {
        Queue<Integer> queue = new Queue<>();
        queue.reverse();
        assertTrue(queue.empty());
    }

    @Test
    public void testGetLastWhenQueueIsEmptyThenReturnNull() {
        Queue<Integer> queue = new Queue<>();
        Integer result = queue.getLast();
        assertNull(result);
    }

    @Test
    public void testGetLastWhenQueueHasOneElementThenReturnThatElement() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        Integer result = queue.getLast();
        assertNotNull(result);
        assertEquals(Integer.valueOf(1), result);
    }

    @Test
    public void testGetLastWhenQueueHasMultipleElementsThenReturnLastElement() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Integer result = queue.getLast();
        assertNotNull(result);
        assertEquals(Integer.valueOf(3), result);
    }
}