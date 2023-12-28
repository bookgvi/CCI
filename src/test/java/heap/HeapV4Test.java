package heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class HeapV4Test {

    private HeapV4<Integer> heap;

    @BeforeEach
    public void setUp() {
        heap = new HeapV4<>(Comparator.naturalOrder());
    }

    @Test
    public void testPollWhenHeapIsEmptyThenReturnNull() {
        Integer result = heap.poll();
        assertNull(result, "Expected poll to return null when heap is empty");
    }

    @Test
    public void testPollWhenHeapHasOneElementThenReturnElementAndHeapIsEmpty() {
        heap.add(1);
        Integer result = heap.poll();
        assertEquals(1, result, "Expected poll to return the only element in the heap");
        assertTrue(heap.isEmpty(), "Expected heap to be empty after polling the only element");
    }

    @Test
    public void testPollWhenHeapHasMultipleElementsThenReturnElementsInPriorityOrderAndHeapIsUpdated() {
        heap.add(3);
        heap.add(1);
        heap.add(2);
        heap.add(-1);
        assertEquals(-1, heap.poll(), "Expected poll to return the smallest element in the heap");
        assertEquals(1, heap.poll(), "Expected poll to return the next smallest element in the heap");
        assertEquals(2, heap.poll(), "Expected poll to return the next smallest element in the heap");
        assertEquals(3, heap.poll(), "Expected poll to return the largest element in the heap");
        assertTrue(heap.isEmpty(), "Expected heap to be empty after polling all elements");
    }

    @Test
    public void testOfferWhenHeapIsEmptyThenAddElement() {
        boolean result = heap.offer(1);
        assertTrue(result, "Expected offer to return true when element is added to the heap");
        assertEquals(1, heap.getSize(), "Expected size of heap to be 1 after adding element");
        assertArrayEquals(new Object[]{1}, heap.getHeap(), "Expected heap to contain the added element");
    }

    @Test
    public void testOfferWhenHeapIsFullThenAddElement() {
        for (int i = 0; i < 10; i++) {
            heap.offer(i);
        }
        boolean result = heap.offer(10);
        assertTrue(result, "Expected offer to return true when element is added to the full heap");
        assertEquals(11, heap.getSize(), "Expected size of heap to be increased by 1 after adding element to the full heap");
        assertArrayEquals(new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, heap.getHeap(), "Expected heap to contain the added element");
    }

    @Test
    public void testOfferWhenHeapIsNotEmptyThenAddElement() {
        heap.offer(1);
        boolean result = heap.offer(2);
        assertTrue(result, "Expected offer to return true when element is added to the non-empty heap");
        assertEquals(2, heap.getSize(), "Expected size of heap to be increased by 1 after adding element to the non-empty heap");
        assertArrayEquals(new Object[]{1, 2}, heap.getHeap(), "Expected heap to contain the added element");
    }
}