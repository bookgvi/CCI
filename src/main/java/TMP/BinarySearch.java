package TMP;

public class BinarySearch {
    public int proceed(int[] nums, int elt) {
        int len = nums.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (elt > nums[mid]) {
                l = mid + 1;
            } else if (elt < nums[mid]){
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -(l + 1);
    }
}
