package heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeapV2Test {

    private HeapV2 heap;

    @BeforeEach
    public void setup() {
        heap = new HeapV2(5);
    }

    @Test
    public void testSiftUpWhenNewValueChangePreviousValueTwoTimesCauseOfEqualPositionSet() {
        heap.siftUp(10, 2);
        heap.siftUp(5, 0);
        int[] expectedHeap = new int[]{5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertArrayEquals(expectedHeap, heap.getHeap());
    }

    @Test
    public void testSiftUpWhenNewValueIsSmallerThanParentValueThenMoveUp() {
        heap.siftUp(10, 2);
        heap.siftUp(5, 1);
        int[] expectedHeap = new int[]{5, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertArrayEquals(expectedHeap, heap.getHeap());
    }

    @Test
    public void testSiftUpWhenNewValueIsLargerThanParentValueThenStayInSamePosition() {
        heap.siftUp(10, 2);
        heap.siftUp(15, 3);
        int[] expectedHeap = new int[]{10, 15, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertArrayEquals(expectedHeap, heap.getHeap());
    }

    @Test
    public void testSiftUpWhenNewValueIsEqualToParentValueThenStayInSamePosition() {
        heap.siftUp(10, 2);
        heap.siftUp(10, 3);
        int[] expectedHeap = new int[]{10, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertArrayEquals(expectedHeap, heap.getHeap());
    }

    @Test
    public void testSiftUpWhenPositionIsGreaterThanOrEqualToHeapSizeThenThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> heap.siftUp(10, 5));
        assertEquals("position must be less then heap size and greater or equals 0", exception.getMessage());
    }

    @Test
    public void testSiftUpWhenPositionIsLessThan0ThenThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> heap.siftUp(10, -1));
        assertEquals("position must be less then heap size and greater or equals 0", exception.getMessage());
    }

    @Test
    public void testSiftDownWhenNewValueIsSmallerThanChildValueThenMoveDown() {
        heap.siftUp(10, 0);
        heap.siftDown(5, 0);
        int[] expectedHeap = new int[]{5, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertArrayEquals(expectedHeap, heap.getHeap());
    }

    @Test
    public void testSiftDownWhenNewValueIsLargerThanChildValueThenStayInSamePosition() {
        heap.siftUp(10, 0);
        heap.siftDown(15, 0);
        int[] expectedHeap = new int[]{15, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertArrayEquals(expectedHeap, heap.getHeap());
    }

    @Test
    public void testSiftDownWhenNewValueIsEqualToChildValueThenStayInSamePosition() {
        heap.siftUp(10, 0);
        heap.siftDown(10, 0);
        int[] expectedHeap = new int[]{10, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertArrayEquals(expectedHeap, heap.getHeap());
    }
}