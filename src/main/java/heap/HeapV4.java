package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class HeapV4<E> {

    private static final int DEFAULT_HEAP_SIZE = 10;

    private final Comparator<? super E> comparator;
    private Object[] heap;
    private int size;

    public HeapV4() {
        this(null, DEFAULT_HEAP_SIZE);
    }

    public HeapV4(Comparator<? super E> comparator) {
        this(comparator, DEFAULT_HEAP_SIZE);
    }

    public HeapV4(Comparator<? super E> comparator, int size) {
        if (size < 1) {
            throw new IllegalArgumentException("size must be gt 1");
        }
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
        siftUp(elt, s);
        return true;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if (size == 0) {
            return null;
        }
        int s = --size;
        E returnElt = (E) heap[0];
        E movedElt = (E) heap[s];
        heap[s] = null;
        if (s > 0) {
            siftDown(movedElt, 0);
        }
        return returnElt;
    }

    private void siftDown(E movedElt, int pos) {
        if (Objects.isNull(comparator)) {
            siftDownComparable(movedElt, pos);
        } else {
            siftDownComparator(movedElt, pos);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(E elt, int pos) {
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos >> 1) + 1;
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
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child | 1;
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

    private void siftUp(E elt, int pos) {
        if (Objects.isNull(comparator)) {
            siftUpComparable(elt, pos);
        } else {
            siftUpComparator(elt, pos);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparator(E elt, int pos) {
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            E pVal = (E) heap[parent];
            if (comparator.compare(elt, pVal) >= 0) {
                break;
            }
            heap[pos] = pVal;
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
        int newSize = size + (size >>> 1);
        heap = Arrays.copyOf(heap, newSize);
    }
}
