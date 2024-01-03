package heap;

import java.util.Arrays;
import java.util.Comparator;

public class HeapV6<E> {

    private final int DEFAULT_SIZE = 16;
    private int size;
    private Object[] heap;
    private final Comparator<? super E> comparator;

    public HeapV6() {
        this(null);
    }

    public HeapV6(Comparator<? super E> comparator) {
        this.comparator = comparator;
        heap = new Object[DEFAULT_SIZE];
    }

    Object[] getHeap() {
        return heap;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E val) {
        return offer(val);
    }

    public boolean offer(E val) {
        int s = size++;
        if (s >= heap.length) {
            grow();
        }
        siftUp(val, s);
        return true;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if (size == 0) {
            return null;
        }
        int s = --size;
        E res = (E) heap[0];
        E moved = (E) heap[s];
        if (s != 0) {
            siftDown(moved, 0);
        }
        return res;
    }

    private void siftDown(E val, int pos) {
        if (comparator == null) {
            siftDownComparable(val, pos);
        } else {
            siftDownComparator(val, pos);
        }
    }

    private void siftUp(E val, int pos) {
        if (comparator == null) {
            siftUpComparable(val, pos);
        } else {
            siftUpComparator(val, pos);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparator(E val, int pos) {
        while(pos > 0) {
            int parent = (pos - 1) >>> 1;
            Object parentVal = heap[parent];
            if (comparator.compare(val, (E) parentVal) >= 0) {
                break;
            }
            heap[pos] = parentVal;
            pos = parent;
        }
        heap[pos] = val;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(E val, int pos) {
        Comparable<? super E> valC = (Comparable<? super E>) val;
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            Object parentVal = heap[parent];
            if (valC.compareTo((E) parentVal) >= 0) {
                break;
            }
            heap[pos] = parentVal;
            pos = parent;
        }
        heap[pos] = val;
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(E val, int pos) {
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            Object childVal = heap[child];
            if (r < size && comparator.compare((E) heap[r], (E) childVal) < 0) {
                childVal = heap[child = r];
            }
            if (comparator.compare(val, (E) childVal) <= 0) {
                break;
            }
            heap[pos] = childVal;
            pos = child;
        }
        heap[pos] = val;
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(E val, int pos) {
        Comparable<? super E> valC = (Comparable<? super E>) val;
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            Object childVal = heap[child];
            if (r < size && ((Comparable<? super E>) childVal).compareTo((E) heap[r]) > 0) {
                childVal = heap[child = r];
            }
            if (valC.compareTo((E) childVal) <= 0) {
                break;
            }
            heap[pos] = childVal;
            pos = child;
        }
        heap[pos] = val;
    }

    private void grow() {
        int s = heap.length;
        int newS = s + (s >>> 1);
        heap = Arrays.copyOf(heap, newS);
    }
}
