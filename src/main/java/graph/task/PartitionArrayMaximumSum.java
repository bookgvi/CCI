package graph.task;

public class PartitionArrayMaximumSum {

    private int sum = 0;
    private int count = 0;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length - 1;
        count = k;
        recursion(arr, 1, k);
        return sum;
    }

    private void recursion(int[] arr, int j, int k) {
        if (j >= arr.length) {
            return;
        }
        if (k == 0) {
            recursion(arr, j + 1, count);
        }
        recursion(arr, j - 1, k - 1);
        recursion(arr, j, k - 1);
    }
}
