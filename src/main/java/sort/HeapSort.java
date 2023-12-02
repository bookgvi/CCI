package sort;

import heap.HeapV2;

import java.util.Arrays;

public class HeapSort {
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return arr;
        }
        int size = arr.length;
        int[] tmpArr = Arrays.copyOf(arr, size);
        int[] res = new int[size];
        HeapV2 heap = new HeapV2(size);
        for (int i = size - 1; i >= 0; i -= 1) {
            heap.siftDownArr(tmpArr, i);
        }
        res[0] = tmpArr[0];
        for(int i = 1; i < size; i += 1) {
            tmpArr[0] = Integer.MAX_VALUE;
            heap.siftDownArr(tmpArr, 0);
            res[i] = tmpArr[0];
        }
        return res;
    }
}
