package heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HeapV2Test {

    private HeapV2 heap;

    @BeforeEach
    public void setup() {
        heap = new HeapV2(5);
    }

    // Existing tests...

    @Test
    public void testSiftDownArrWhenHeapArrayIsNotInValidHeapStateThenSiftDown() {
        int[] arr = new int[]{40, 20, 30, 10, 50};
        heap.siftDownArr(arr, 0);
        int[] expectedArr = new int[]{10, 20, 30, 40, 50};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSiftDownArrWhenIndexIsGreaterThanOrEqualToHeapSizeThenThrowException() {
        int[] arr = new int[]{10, 20, 30, 40, 50};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> heap.siftDownArr(arr, 5));
        assertEquals("position must be less then heap size and greater or equals 0", exception.getMessage());
    }

    @Test
    public void testSiftDownArrWhenIndexIsNegativeThenThrowException() {
        int[] arr = new int[]{10, 20, 30, 40, 50};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> heap.siftDownArr(arr, -1));
        assertEquals("position must be less then heap size and greater or equals 0", exception.getMessage());
    }

    @Test
    public void testSiftDownArrPerformanceForLargeHeapArrays() {
        int[] arr = new int[1000000];
        Arrays.fill(arr, Integer.MAX_VALUE);
        long startTime = System.currentTimeMillis();
        heap.siftDownArr(arr, 0);
        long endTime = System.currentTimeMillis();
        assertTrue(endTime - startTime < 1000);
    }

    @Test
    public void testSiftUp() {
        int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        HeapV2 heap = new HeapV2(arr.length);
        for (int i = 0; i < arr.length; i += 1) {
            heap.siftUpArr(arr, i);
        }
        int[] expectedArr = new int[]{0, 1, 5, 4, 2, 9, 6, 10, 7, 8, 3};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSiftUpArrWhenNewValueIsSmallerThanParentValueThenMoveUp() {
        int[] arr = new int[]{10, 20, 30, 40, 50};
        heap.siftUpArr(arr, 2);
        int[] expectedArr = new int[]{10, 20, 30, 40, 50};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSiftUpArrWhenNewValueIsLargerThanParentValueThenStayInSamePosition() {
        int[] arr = new int[]{10, 50, 30, 40, 20};
        heap.siftUpArr(arr, 4);
        int[] expectedArr = new int[]{10, 20, 30, 40, 50};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSiftUpArrWhenNewValueIsEqualToParentValueThenStayInSamePosition() {
        int[] arr = new int[]{10, 20, 10, 40, 50};
        heap.siftUpArr(arr, 2);
        int[] expectedArr = new int[]{10, 20, 10, 40, 50};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSiftUpArrWhenIndexIsGreaterThanOrEqualToHeapSizeThenThrowException() {
        int[] arr = new int[]{10, 20, 30, 40, 50};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> heap.siftUpArr(arr, 5));
        assertEquals("position must be less then heap size and greater or equals 0", exception.getMessage());
    }

    @Test
    public void testSiftUpArrWhenIndexIsNegativeThenThrowException() {
        int[] arr = new int[]{10, 20, 30, 40, 50};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> heap.siftUpArr(arr, -1));
        assertEquals("position must be less then heap size and greater or equals 0", exception.getMessage());
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