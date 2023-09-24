package Hashing.numberTheory;

public class BinarySearch {
    public int find(int[] sortedArr, int val) {
        return find(sortedArr, 0, sortedArr.length - 1, val);
    }

    public int find(int[] sortedArr, int fromIndex, int toIndex, int val) {
        int low = fromIndex, high = toIndex;
        while (low <= high) {
            int mid = (high + low) >>> 1;
            if (sortedArr[mid] < val) {
                low = mid + 1;
            } else {
                if (sortedArr[mid] == val) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
}
