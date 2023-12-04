package heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapV3Test {

    @Test
    public void testOfferWhenHeapIsEmptyThenAddElementToHeap() {
        // Arrange
        HeapV3<Integer> heap = new HeapV3<>(1);
        Integer element = 5;

        // Act
        boolean result = heap.offer(element);

        // Assert
        assertTrue(result);
        assertEquals(1, heap.getSize());
        assertArrayEquals(new Object[]{element}, heap.getHeap());
    }

    @Test
    public void testOfferWhenHeapIsNotEmptyThenAddElementsToHeap() {
        // Arrange
        HeapV3<Integer> heap = new HeapV3<>(3);
        Integer element1 = 5;
        Integer element2 = 3;
        Integer element3 = 7;

        // Act
        boolean result1 = heap.offer(element1);
        boolean result2 = heap.offer(element2);
        boolean result3 = heap.offer(element3);

        // Assert
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertEquals(3, heap.getSize());
        assertArrayEquals(new Object[]{element2, element1, element3}, heap.getHeap());
    }

    @Test
    public void testOfferWhenHeapNeedsToBeResizedThenAddElementsToHeap() {
        // Arrange
        HeapV3<Integer> heap = new HeapV3<>(2);
        Integer element1 = 5;
        Integer element2 = 3;
        Integer element3 = 7;

        // Act
        boolean result1 = heap.offer(element1);
        boolean result2 = heap.offer(element2);
        boolean result3 = heap.offer(element3);

        // Assert
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertEquals(3, heap.getSize());
        assertArrayEquals(new Object[]{element2, element1, element3}, heap.getHeap());
    }

    @Test
    public void testPollWhenHeapIsNotEmptyThenReturnSmallestElement() {
        // Arrange
        HeapV3<Integer> heap = new HeapV3<>(3);
        Integer element1 = 5;
        Integer element2 = 3;
        Integer element3 = 7;
        heap.offer(element1);
        heap.offer(element2);
        heap.offer(element3);

        // Act
        Integer result = heap.poll();

        // Assert
        assertEquals(element2, result);
        assertEquals(2, heap.getSize());
        assertArrayEquals(new Object[]{element1, element3}, heap.getHeap());
    }

    @Test
    public void testPollWhenHeapIsEmptyThenReturnNull() {
        // Arrange
        HeapV3<Integer> heap = new HeapV3<>(0);

        // Act
        Integer result = heap.poll();

        // Assert
        assertNull(result);
        assertEquals(0, heap.getSize());
        assertArrayEquals(new Object[]{}, heap.getHeap());
    }

    @Test
    public void testHeapGrow() {
        HeapV3<String> heap = new HeapV3<>(0);
        heap.offer("A");
        heap.offer("E");
        heap.offer("V");
        heap.offer("C");
        heap.offer("B");
        heap.offer("A");

        assertEquals(6, heap.getSize());
    }
}