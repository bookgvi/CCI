package heap;

import java.util.Arrays;

public class Heap implements IHeap {

    public Heap() {
    }

    @Override
    public void siftUp(int[] arr, int v) {
        if (arr.length == 0) {
            return;
        }
        while (v > 1) {
            int p = arr[v >> 1];
            if (p < arr[v]) {
                this.swap(arr, v, p);
            }
            v >>= 1;
        }
    }

    @Override
    public void siftDown(int[] arr, int v) {
        int size = arr != null ? arr.length : 0;
        siftDown(arr, size, v);
    }

    public void siftDown(int[] arr, int size, int v) {
        if (arr == null || size <= 0 || arr.length < size || v < 0) {
            return;
        }
        while (v <= (size >> 1)) {
            int l = v << 1;
            int r = l + 1;
            int t = r < size && arr[r] < arr[l] ? r : l;
            if (arr[t] >= arr[v]) {
                break;
            }
            this.swap(arr, t, v);
            v = t;
        }
    }

    @Override
    public int[] build(int[] arr) {
        int size = arr != null ? arr.length : 0;
        int[] heap = size == 0 ? new int[size] : Arrays.copyOf(arr, size);
        for (int i = size; i >= 0; i -= 1) {
            siftDown(heap, size, i);
        }
        return heap;
    }

    private void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
