package heap;

import java.util.Arrays;
import java.util.Comparator;

public class HeapV3<E> {
    private final Comparator<? super E> comparator;
    private Object[] heap;
    private int size;

    public HeapV3() {
        this(1);
    }

    public HeapV3(int size) {
        this(size, null);
    }

    public HeapV3(int size, Comparator<? super E> comparator) {
        this.size = 0;
        this.heap = new Object[size];
        this.comparator = comparator;
    }

    public Object[] getHeap() {
        return Arrays.copyOf(heap, size);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E elt) {
        return offer(elt);
    }

    public boolean offer(E elt) {
        int s = size++;
        if (s >= heap.length) {
            grow();
        }
        if (comparator == null) {
            siftUpComparable(elt, s);
        } else {
            siftUpComparator(elt, s);
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        int s = --size;
        if (s < 0) {
            size = 0;
            return null;
        }
        E returnElt = (E) heap[0];
        E movedElt = (E) heap[s];
        heap[s] = null;
        if (comparator == null) {
            siftDownComparable(movedElt, 0);
        } else {
            siftDownComparator(movedElt, 0);
        }
        return returnElt;
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(E elt, int pos) {
        int half = size >>> 1;
        while(pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            Object childVal = heap[child];
            if (r < size && comparator.compare((E) childVal, (E) heap[r]) > 0) {
                childVal = heap[child = r];
            }
            if (comparator.compare(elt, (E) childVal) <= 0) {
                break;
            }
            heap[pos] = childVal;
            pos = child;
        }
        heap[pos] = elt;
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(E elt, int pos) {
        Comparable<? super E> eltC = (Comparable<? super E>) elt;
        int half = size >> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            Object childVal = heap[child];
            Comparable<? super E> childValC = (Comparable<? super E>) childVal;
            if (r < size && childValC.compareTo((E) heap[r]) > 0) {
                childVal = heap[child = r];
            }
            if (eltC.compareTo((E) childVal) <= 0) {
                break;
            }
            heap[pos] = childVal;
            pos = child;
        }
        heap[pos] = elt;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparator(E elt, int pos) {
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            if (comparator.compare(elt, (E) heap[parent]) >= 0) {
                break;
            }
            heap[pos] = heap[parent];
            pos = parent;
        }
        heap[pos] = elt;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(E elt, int pos) {
        Comparable<? super E> eltC = (Comparable<? super E>) elt;
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            if (eltC.compareTo((E) heap[parent]) >= 0) {
                break;
            }
            heap[pos] = heap[parent];
            pos = parent;
        }
        heap[pos] = elt;
    }

    private void grow() {
        int l = heap.length;
        int k = l <= 1 ? 1 : l >>> 1;
        int newSize = l + k;
        heap = Arrays.copyOf(heap, newSize);
    }
}
