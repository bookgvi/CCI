package heap;

import java.util.Arrays;
import java.util.Comparator;

public class HeapV8<T> {

    private static final int DEFAULT_SIZE = 1 << 4;
    private Object[] heap;
    private int size;
    private final Comparator<T> comparator;

    public HeapV8() {
        this(null);
    }

    public HeapV8(Comparator<T> comparator) {
        this.heap = new Object[DEFAULT_SIZE];
        this.comparator = comparator;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean add(T val) {
        return offer(val);
    }

    @SuppressWarnings("unchecked")

    public T poll() {
        if (size < 1) {
            return null;
        }
        T valToMove = (T) heap[--size];
        T valToReturn = (T) heap[0];
        if (size > 0) {
            siftDown(0, valToMove);
        }
        return valToReturn;
    }

    private boolean offer(T val) {
        if (++size <= heap.length) {
            grow();
        }
        return siftUp(size - 1, val);
    }

    private void siftDown(int pos, T val) {
        if (comparator == null) {
            siftDownComparable(pos, val);
        } else {
            siftDownComparator(pos, val);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(int pos, T val) {
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int right = child + 1;
            Object childVal = heap[child];
            if (right < size && comparator.compare((T) heap[right], (T) childVal) < 0) {
                childVal = heap[child = right];
            }
            if (comparator.compare(val, (T) childVal) <= 0) {
                break;
            }
            heap[pos] = childVal;
            pos = child;
        }
        heap[pos] = val;
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int pos, T val) {
        int half = size >>> 1;
        Comparable<? super T> comparableVal = (Comparable<? super T>) val;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int right = child + 1;
            Object childVal = heap[child];
            if (right < size && ((Comparable<? super T>) heap[right]).compareTo((T) childVal) < 0) {
                childVal = heap[child = right];
            }
            if (comparableVal.compareTo((T) childVal) <= 0) {
                break;
            }
            heap[pos] = childVal;
            pos = child;
        }
        heap[pos] = val;
    }

    private boolean siftUp(int pos, T val) {
        if (comparator == null) {
            return siftUpComparable(pos, val);
        }
        return siftUpComparator(pos, val);
    }

    @SuppressWarnings("unchecked")
    private boolean siftUpComparator(int pos, T val) {
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            Object parentVal = heap[parent];
            if (comparator.compare(val, (T) parentVal) >= 0) {
                break;
            }
            heap[pos] = parentVal;
            pos = parent;
        }
        heap[pos] = val;
        return true;
    }

    @SuppressWarnings("unchecked")
    private boolean siftUpComparable(int pos, T val) {
        Comparable<? super T> comparableVal = (Comparable<? super T>) val;
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            Object parentVal = heap[parent];
            if (comparableVal.compareTo((T) parentVal) >= 0) {
                break;
            }
            heap[pos] = parentVal;
            pos = parent;
        }
        heap[pos] = val;
        return true;
    }

    private void grow() {
        int s = heap.length;
        s = s < DEFAULT_SIZE ? DEFAULT_SIZE : s + (s >>> 1);
        heap = Arrays.copyOf(heap, s);
    }
}
