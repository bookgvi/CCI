package graph.dijkstra;

import java.util.Arrays;
import java.util.Objects;

public class PriorityQueueCustom {
    private int[] heap;
    private int size;

    public PriorityQueueCustom(int size) {
        this.size = 0;
        this.heap = new int[size];
    }

    public PriorityQueueCustom(int[] arr) {
        this(arr.length);
        for (int elt : arr) {
            offer(elt);
        }
    }

    public int[] getHeap() {
        return Arrays.copyOf(heap, size);
    }

    public int getSize() {
        return size;
    }

    public boolean offer(int val) {
        int tmpSize = size;
        if (size >= heap.length) {
            grow();
        }
        size += 1;
        siftUp(val, tmpSize);
        return true;
    }

    public int poll() {
        if (Objects.equals(0, size)) {
            return 0;
        }
        int newSize = --size;
        int polledElt = heap[0];
        int moved = heap[newSize];
        heap[newSize] = 0;
        if (newSize > 0) {
            siftDown(moved, 0);
        }
        return polledElt;
    }

    private void grow() {
        int size = heap.length;
        size += (size << 1);
        heap = Arrays.copyOf(heap, size);
    }

    private void siftUp(int val, int pos) {
        while(pos > 0) {
            int parent = (pos - 1) >>> 1;
            int parentVal = heap[parent];
            if (parentVal <= val) {
                break;
            }
            heap[pos] = parentVal;
            pos = parent;
        }
        heap[pos] = val;
    }

    private void siftDown(int val, int pos) {
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            child = r < size && heap[r] < heap[child] ? r : child;
            int childVal = heap[child];
            if (childVal >= val) {
                break;
            }
            heap[pos] = childVal;
            pos = child;
        }
        heap[pos] = val;
    }
}
