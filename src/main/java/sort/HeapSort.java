package sort;

import heap.HeapV2;
import heap.HeapV3;

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

    /**
     * Sorts an array of integers using the HeapV3 algorithm.
     *
     * @param  nums  the array of integers to be sorted
     * @return       the sorted array of integers
     */public int[] sortByHeapV3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int size = nums.length;
        HeapV3<Integer> heap = new HeapV3<>(size + 1);
        for (int num : nums) {
            heap.offer(num);
        }
        int[] sorted = new int[size];
        for (int i = 0; i < size; i += 1) {
            sorted[i] = heap.poll();
        }
        return sorted;
    }
}
