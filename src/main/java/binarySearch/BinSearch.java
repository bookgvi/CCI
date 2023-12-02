package binarySearch;

public class BinSearch {
    /**
     * Binary search realization work with sorted arrays only
     *
     * @param k - value to looking for
     * @param nums - arrays of integers for looking for
     * @return - index of finding value in array or negative index if 'k' value is absent in nums
     * negative index represents the position where the 'k' value should be inserted to maintain the sorted order of the 'nums' array.
     */
    public int proceed(int k, int[] nums) {
        int len = nums.length, l = 0, r = len - 1;
        while (r - l >= 0) {
            int mid = (r + l) >>> 1;
            if (k < nums[mid]) {
                r = mid - 1;
            } else if (k > nums[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -(l + 1);
    }
}
