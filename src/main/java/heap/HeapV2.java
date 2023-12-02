package heap;

import java.util.Arrays;

public class HeapV2 {

    private final int[] heap;
    private final int heapSize;

    public HeapV2(int heapSize) {
        if (heapSize < 1) {
            throw new IllegalArgumentException("Heap size must be greater then 0");
        }
        this.heapSize = heapSize;
        this.heap = new int[heapSize];
        Arrays.fill(this.heap, Integer.MAX_VALUE);
    }

    public int[] getHeap() {
        return Arrays.copyOf(heap, heapSize);
    }

    public void siftUp(int newVal, int pos) {
        if (pos >= heapSize || pos < 0) {
            throw new IllegalArgumentException("position must be less then heap size and greater or equals 0");
        }
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            int parentVal = heap[parent];
            if (parentVal < newVal) {
                break;
            }
            heap[pos] = parentVal;
            pos = parent;
        }
        heap[pos] = newVal;
    }

    public void siftDown(int newVal, int pos) {
        if (pos >= heapSize || pos < 0) {
            throw new IllegalArgumentException("position must be less then heap size and greater or equals 0");
        }
        int half = heapSize >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int right = child + 1;
            int childVal = heap[child];
            if (right < heapSize && childVal > heap[right]) {
                childVal = heap[child = right];
            }
            if (childVal >= newVal) {
                newVal = setNewVal(pos, newVal);
            }
            pos = child;
        }

    }

    int setNewVal(int pos, int newVal) {
        int prevVal = heap[pos];
        heap[pos] = newVal;
        return prevVal;
    }
}
