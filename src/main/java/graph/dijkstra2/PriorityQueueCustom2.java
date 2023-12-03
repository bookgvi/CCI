package graph.dijkstra2;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueueCustom2<E> {

    private Object[] heap;
    private int size;
    private final Comparator<? super E> comparator;

    public PriorityQueueCustom2(Comparator<? super E> comparator) {
        this(1, comparator);
    }
    public PriorityQueueCustom2() {
        this(1);
    }

    public PriorityQueueCustom2(int size) {
        this(size, null);
    }

    public PriorityQueueCustom2(int size, Comparator<? super E> comparator) {
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
        if (size > 0) {
            siftDown(movedElt, 0);
        }
        return returnElt;
    }

    private void grow() {
        int size = heap.length;
        size += (size << 1);
        heap = Arrays.copyOf(heap, size);
    }

    @SuppressWarnings("unchecked")
    private void siftUp(E newVal, int pos) {
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            Object parentVal = heap[parent];
            if (comparator == null) {
                if (((Comparable<? super E>) newVal).compareTo((E) parentVal) >= 0) {
                    break;
                }
            } else {
                if (comparator.compare(newVal, (E) parentVal) >= 0) {
                    break;
                }
            }
            heap[pos] = parentVal;
            pos = parent;
        }
        heap[pos] = newVal;
    }

    private void siftDown(E val, int pos) {
        if (comparator == null) {
            siftDownComparable(val, pos);
        } else {
            siftDownComparator(val, pos);
        }
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
        Comparable<? super E> keyVal = (Comparable<? super E>) val;
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            Object childVal = heap[child];
            if (r < size && ((Comparable<? super E>) heap[r]).compareTo((E) childVal) < 0) {
                childVal = heap[child = r];
            }
            if (keyVal.compareTo((E) childVal) <= 0) {
                break;
            }
            heap[pos] = childVal;
            pos = child;
        }
        heap[pos] = val;
    }

}
