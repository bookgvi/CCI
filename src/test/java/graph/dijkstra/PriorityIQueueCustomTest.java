package graph.dijkstra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueCustomTest {
    private PriorityQueueCustom priorityQueue;

    @BeforeEach
    public void setUp() {
        priorityQueue = new PriorityQueueCustom(5);
    }

    @Test
    public void testOfferWhenHeapNotFullThenAddToHeap() {
        int valueToAdd = 10;
        boolean result = priorityQueue.offer(valueToAdd);
        assertTrue(result, "Offer method should return true when value is added to the heap");
        assertEquals(1, priorityQueue.getSize(), "Heap size should be increased by 1");
        assertArrayEquals(new int[]{valueToAdd}, priorityQueue.getHeap(), "Heap should contain the added value");
    }

    @Test
    public void testOfferWhenHeapFullThenAddToHeap() {
        PriorityQueueCustom fullPriorityQueue = new PriorityQueueCustom(1);
        int valueToAdd = 10;
        boolean result = fullPriorityQueue.offer(valueToAdd);
        assertTrue(result, "Offer method should return true when value is added to the heap");
        assertEquals(1, fullPriorityQueue.getSize(), "Heap size should be increased by 1");
        assertArrayEquals(new int[]{valueToAdd}, fullPriorityQueue.getHeap(), "Heap should contain the added value");
    }

    @Test
    public void testOfferWhenHeapFullThenGrowHeap() throws Exception {
        PriorityQueueCustom fullPriorityQueue = new PriorityQueueCustom(1);
        fullPriorityQueue.offer(10);
        fullPriorityQueue.offer(20);
        assertEquals(2, fullPriorityQueue.getSize(), "Heap size should be increased by 2");
        assertArrayEquals(new int[]{10, 20}, fullPriorityQueue.getHeap(), "Heap should contain the added values");

        // Use reflection to test private method 'grow'
        Method growMethod = PriorityQueueCustom.class.getDeclaredMethod("grow");
        growMethod.setAccessible(true);
        growMethod.invoke(fullPriorityQueue);
        assertTrue(fullPriorityQueue.getHeap().length >= 2, "Heap size should be increased after calling 'grow' method");
    }

    @Test
    public void testOfferWhenHeapEmptyThenAddToHeap() {
        int valueToAdd = 10;
        boolean result = priorityQueue.offer(valueToAdd);
        assertTrue(result, "Offer method should return true when value is added to the heap");
        assertEquals(1, priorityQueue.getSize(), "Heap size should be increased by 1");
        assertArrayEquals(new int[]{valueToAdd}, priorityQueue.getHeap(), "Heap should contain the added value");
    }

    @Test
    public void testPollWhenHeapNotEmptyThenRemoveAndReturnSmallestElement() {
        priorityQueue.offer(10);
        priorityQueue.offer(20);
        priorityQueue.offer(30);
        priorityQueue.offer(3);
        priorityQueue.offer(5);
        int polledValue = priorityQueue.poll();
        assertEquals(3, polledValue, "Poll method should return the smallest value from the heap");
        polledValue = priorityQueue.poll();
        assertEquals(5, polledValue, "Poll method should return the smallest value from the heap");
        polledValue = priorityQueue.poll();
        assertEquals(10, polledValue, "Poll method should return the smallest value from the heap");
        assertEquals(2, priorityQueue.getSize(), "Heap size should be decreased by 1");
        assertArrayEquals(new int[]{20, 30}, priorityQueue.getHeap(), "Heap should not contain the polled value");
    }

    @Test
    public void testPollWhenHeapEmptyThenDoNothing() {
        int initialSize = priorityQueue.getSize();
        int polledValue = priorityQueue.poll();
        assertEquals(0, polledValue, "Poll method should return 0 when heap is empty");
        assertEquals(initialSize, priorityQueue.getSize(), "Heap size should remain the same");
        assertArrayEquals(new int[]{}, priorityQueue.getHeap(), "Heap should remain empty");
    }

    @Test
    public void testGeneratePriorityQueueFromArray() {
        int[] arr = new int[]{10, 20, 30, 3, 5};
        PriorityQueueCustom fullPriorityQueue = new PriorityQueueCustom(arr);
        int[] heap = fullPriorityQueue.getHeap();
        assertArrayEquals(new int[]{3, 5, 30, 20, 10}, heap, "heap should contained all elements with minimum on top");
    }
}