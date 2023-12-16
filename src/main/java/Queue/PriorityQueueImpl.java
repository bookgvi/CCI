package Queue;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueueImpl<T> implements IQueue<T> {
    private Object[] heap;
    private int size;
    private Comparator<? super T> comparator;


    public PriorityQueueImpl() {
        this(0, null);

    }
    public PriorityQueueImpl(Comparator<? super T> comparator) {
        this(0, comparator);
    }
    public PriorityQueueImpl(int size, Comparator<? super T> comparator) {
        if (size < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + size);
        }
        this.heap = new Object[size];
        this.comparator = comparator;
    }

    public int getSize() {
        return size;
    }

    public Object[] getHeap() {
        return Arrays.copyOf(heap, size);
    }

    @Override
    public boolean add(T elt) {
        return offer(elt);
    }

    @Override
    public boolean offer(T elt) {
        int s = size++;
        if (s >= heap.length) {
            grow();
        }
        siftUp(elt, s);
        return true;
    }

    @Override
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

    private void siftDown(T val, int pos) {
        if (comparator == null) {
            siftDownComparable(val, pos);
        } else {
            siftDownComparator(val, pos);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(T val, int pos) {
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            Object childVal = heap[child];
            if (r < size && comparator.compare((T) childVal, (T) heap[r]) > r) {
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
            Comparable<? super T> childValC = (Comparable<? super T>) childVal;
            if (r < size && childValC.compareTo((T) heap[r]) > 0) {
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

    private void siftUp(T val, int pos) {
        if (comparator == null) {
            siftUpComparable(val, pos);
        } else {
            siftUpComparator(val, pos);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparator(T val, int pos) {
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            Object pVal = heap[parent];
            if (comparator.compare(val, (T) pVal) >= 0) {
                break;
            }
            heap[pos] = pVal;
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
        int s = heap.length;
        int newS = s + 1 + (s >>> 1);
        heap = Arrays.copyOf(heap, newS);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
