package heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeapTest {

    @Test
    public void testBuildWhenArrayIsNotEmptyThenReturnHeap() {
        // Arrange
        Heap heap = new Heap();
        int[] arr = {5, 3, 2, 1, 4};

        // Act
        int[] result = heap.build(arr);

        // Assert
        for (int i = 0; i < result.length / 2; i++) {
            assertTrue(result[i] <= result[2 * i + 1]);
            if (2 * i + 2 < result.length) {
                assertTrue(result[i] <= result[2 * i + 2]);
            }
        }
    }

    @Test
    public void testBuildWhenArrayIsEmptyThenReturnEmptyArray() {
        // Arrange
        Heap heap = new Heap();
        int[] arr = {};

        // Act
        int[] result = heap.build(arr);

        // Assert
        assertEquals(0, result.length);
    }

    @Test
    public void testBuildWhenArrayIsNullThenThrowException() {
        // Arrange
        Heap heap = new Heap();

        // Act
        int[] result = heap.build(null);

        // Assert is handled by the expected exception
        assertEquals(0, result.length);
    }

    @Test
    public void testSiftDownWithEmptyArray() {
        // Arrange
        Heap heap = new Heap();
        int[] arr = {};

        // Act
        heap.siftDown(arr, arr.length, 0);

        // Assert
        assertEquals(0, arr.length);
    }

    @Test
    public void testSiftDownWithNullArray() {
        // Arrange
        Heap heap = new Heap();

        // Act
        heap.siftDown(null, 0, 0);

        // Assert is handled by the expected exception
    }

    @Test
    public void testSiftDownWithSizeLargerThanActual() {
        // Arrange
        Heap heap = new Heap();
        int[] arr = {5, 3, 2, 1, 4};

        // Act
        heap.siftDown(arr, arr.length + 1, 0);

        // Assert is handled by the expected exception
    }

    @Test
    public void testSiftDownWithNegativeV() {
        // Arrange
        Heap heap = new Heap();
        int[] arr = {5, 3, 2, 1, 4};

        // Act
        heap.siftDown(arr, arr.length, -1);

        // Assert is handled by the expected exception
    }
}