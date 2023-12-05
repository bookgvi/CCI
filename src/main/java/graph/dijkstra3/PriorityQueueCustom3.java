package graph.dijkstra3;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueueCustom3 {
    private int[] heap;
    private int size;
    private final Comparator<? super Integer> comparator;

    public PriorityQueueCustom3(Comparator<? super Integer> comparator) {
        this(0, comparator);
    }

    public PriorityQueueCustom3(int size, Comparator<? super Integer> comparator) {
        this.comparator = comparator;
        this.size = 0;
        this.heap = new int[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean offer(int elt) {
        int s = size++;
        if (s >= heap.length) {
            grow();
        }
        siftUp(elt, s);
        return true;
    }

    public int poll() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        int s = --size;
        int returnElt = heap[0];
        int movedElt = heap[s];
        heap[s] = Integer.MAX_VALUE;
        if (size > 0) {
            siftDown(movedElt, 0);
        }
        return returnElt;
    }

    private void siftDown(int elt, int pos) {
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            int childVal = heap[child];
            if (r < size && comparator.compare(heap[r], heap[child]) < 0) {
                childVal = heap[child = r];
            }
            if (comparator.compare(elt, heap[child]) <= 0) {
                break;
            }
            heap[pos] = childVal;
            pos = child;
        }
        heap[pos] = elt;
    }

    private void siftUp(int elt, int pos) {
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            if (comparator.compare(elt, heap[parent]) >= 0) {
                break;
            }
            heap[pos] = heap[parent];
            pos = parent;
        }
        heap[pos] = elt;
    }

    private void grow() {
        int s = heap.length;
        int k = s <= 1 ? 1 : s >>> 1;
        s += k;
        heap = Arrays.copyOf(heap, s);
    }
}
