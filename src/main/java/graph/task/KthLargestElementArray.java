package graph.task;

public class KthLargestElementArray {


    private int[] nums;
    private int size;

    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        if (k > size) {
            return Integer.MIN_VALUE;
        }
        this.nums = new int[size + 1];
        int[] r = new int[size];
        for (int val : nums) {
           add(val);
        }
        add(Integer.MIN_VALUE);
//        add(Integer.MAX_VALUE);
        for (int i = 0; i < size; i += 1) {
            r[i] = poll();
        }
        return r[k - 1];
    }

    void add(int val) {
        int s = size++;
        siftUp(val, s);
    }

    private void siftUp(int val, int pos) {
        while (pos > 0) {
            int parent = (pos - 1) >>> 1;
            if (nums[parent] >= val) {
                break;
            }
            nums[pos] = nums[parent];
            pos = parent;
        }
        nums[pos] = val;
    }

    int poll() {
        int s = --size;
        int returnVal = nums[0];
        int movedVal = nums[s];
        if (s != 0) {
            siftDown(movedVal, 0);
        }
        return returnVal;
    }


    void siftDown(int val, int pos) {
        int half = size >>> 1;
        while (pos < half) {
            int child = (pos << 1) + 1;
            int r = child + 1;
            int childVal = nums[child];
            if (r < size && nums[child] < nums[r]) {
                childVal = nums[child = r];
            }
            if (childVal <= val) {
                break;
            }
            nums[pos] = childVal;
            pos = child;
        }
        nums[pos] = val;
    }
}
