package graph.task;

import java.util.Arrays;
import java.util.Stack;

public class SumSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n]; // stores the index of the previous smaller element
        int[] right = new int[n]; // stores the index of the next smaller element
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>(); // stores the indices of elements in non-decreasing order

        // Find the indices of the previous smaller elements
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        long sum = 0;
        int mod = (int) 1e9 + 7;

        // Calculate the sum of the minimum values for each subarray
        for (int i = 0; i < n; i++) {
            long count = (long) (i - left[i]) * (right[i] - i);
            sum = (sum + count * arr[i]) % mod;
        }

        return (int) sum;
    }
}
