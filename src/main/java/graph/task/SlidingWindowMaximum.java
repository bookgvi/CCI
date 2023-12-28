package graph.task;

import java.util.Arrays;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length, p = 0;
        if (k > len) {
            return new int[]{};
        }
        if (len == 1 || k == 1) {
            return nums;
        }
        int[] res = new int[len - k + 1];
        for (int j = 0; j <= len - k; j += 1) {
            Heap heap = new Heap(k);
            for (int i = j; i < j + k; i += 1) {
                heap.add(nums[i]);
            }
            res[p++] = heap.peek();
        }

        return res;
    }

    private static class Heap {

        private int size = 0;
        private final int[] heap;

        Heap(int k) {
            heap = new int[k + 1];
            Arrays.fill(heap, Integer.MIN_VALUE);
        }

        void add(int val) {
            int s = size++;
            siftUp(val, s);
        }

        void push(int val) {
            siftUp(val, size);
        }

        int peek() {
            return heap[0];
        }

        int poll() {
            int s = --size;
            int res = heap[0];
            int moved = heap[s];
            heap[s] = Integer.MIN_VALUE;
            if (s != 0) {
                siftDown(moved, 0);
            }
            return res;
        }

        private void siftDown(int val, int pos) {
            int half = size >>> 1;
            while (pos < half) {
                int child = (pos << 1) + 1;
                int r = child + 1;
                int childVal = heap[child];
                if (r < size && heap[child] < heap[r]) {
                    childVal = heap[child = r];
                }
                if (val >= childVal) {
                    break;
                }
                heap[pos] = childVal;
                pos = child;
            }
            heap[pos] = val;
        }

        private void siftUp(int val, int pos) {
            while (pos > 0) {
                int parent = (pos - 1) >>> 1;
                if (val <= heap[parent]) {
                    break;
                }
                heap[pos] = heap[parent];
                pos = parent;
            }
            heap[pos] = val;
        }

        public boolean remove(int val) {
            int i = indexOf(val);
            if (i == -1)
                return false;
            else {
                removeAt(i);
                return true;
            }
        }

        private int removeAt(int i) {
            int s = --size;
            if (s == i) // removed last element
                heap[i] = Integer.MIN_VALUE;
            else {
                int moved = heap[s];
                heap[i] = Integer.MIN_VALUE;
                siftDown(moved, i);
                if (heap[i] == moved) {
                    siftUp(moved, i);
                    if (heap[i] != moved)
                        return moved;
                }
            }
            return Integer.MIN_VALUE;
        }

        private int indexOf(Object o) {
            if (o != null) {
                for (int i = 0; i < size; i++)
                    if (o.equals(heap[i]))
                        return i;
            }
            return -1;
        }
    }
}
