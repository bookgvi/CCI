package heap;

import java.util.Arrays;
import java.util.Comparator;

public class HeapV5<T> {

    private Object[] heap;
    private final Comparator<? super T> comparator;
    private int size;

    public HeapV5() {
        this(null, 10);
    }

    public HeapV5(Comparator<? super T> comparator, int size) {
        this.comparator = comparator;
        this.heap = new Object[size];
    }

    public int getHeapSize() {
        return heap.length;
    }

    public boolean add(T val) {
        return offer(val);
    }

    public boolean offer(T val) {
        int s = size;
        size += 1;
        if (s >= heap.length) {
            grow();
        }
        siftUp(val, s);
        return true;
    }


    @SuppressWarnings("unchecked")
    public T poll() {
        if (size == 0) {
            return null;
        }
        int s = --size;
        T returnVal = (T) heap[0];
        T movedVal = (T) heap[s];
        heap[s] = null;
        if (s != 0) {
            siftDown(movedVal, 0);
        }
        return returnVal;
    }

    private void siftUp(T val, int pos) {
        if (comparator == null) {
            siftUpComparable(val, pos);
        } else {
            siftUpCompare(val, pos);
        }
    }

    private void siftDown(T val, int pos) {
        if (comparator == null) {
            siftDownComparable(val, pos);
        } else {
            siftDownComparator(val, pos);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(T val, int pos) {
        int half = size >> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            Object childVal = heap[child];
            if (r < size && comparator.compare((T) childVal, (T) heap[r]) > 0) {
                childVal = heap[child = r];
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
    private void siftDownComparable(T val, int pos) {
        Comparable<? super T> valC = (Comparable<? super T>) val;
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            Object childVal = heap[child];
            if (r < size && ((Comparable<? super T>) childVal).compareTo((T) heap[r]) > 0) {
                childVal = heap[child = r];
            }
            if (valC.compareTo((T) childVal) <= 0) {
                break;
            }
            heap[pos] = childVal;
            pos = child;
        }
        heap[pos] = val;
    }


    @SuppressWarnings("unchecked")
    private void siftUpCompare(T val, int pos) {
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            if (comparator.compare(val, (T) heap[parent]) >= 0) {
                break;
            }
            heap[pos] = heap[parent];
            pos = parent;
        }
        heap[pos] = val;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(T val, int pos) {
        Comparable<? super T> valC = (Comparable<? super T>) val;
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            if (valC.compareTo((T) heap[parent]) >= 0) {
                break;
            }
            heap[pos] = heap[parent];
            pos = parent;
        }
        heap[pos] = val;
    }


    private void grow() {
        int size = Math.max(1, heap.length);
        size += size >>> 1;
        heap = Arrays.copyOf(heap, size);
    }
}
