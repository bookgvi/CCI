package graph.task;

import Queue.simpleQueue.QueueImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array arr[] of size N, the task is to find the minimum number of jumps to reach the last index of the array
 * starting from index 0. In one jump you can move from current index i to index j,
 * if arr[i] = arr[j] and i != j or you can jump to (i + 1) or (i – 1).
 * <p>
 * Note: You can not jump outside of the array at any time.
 * <p>
 * Examples:
 * <p>
 * Input: arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404}
 * Output: 3
 * Explanation: Valid jump indices are 0 -> 4 -> 3 -> 9.
 * <p>
 * Input: arr = {7, 6, 9, 6, 9, 6, 9, 7}
 * Output: 1
 */
public class MinimumJumps {

    public int minimizeJumps(int[] arr) {
        int count = 0;
        if (arr == null || arr.length < 1) {
            return count;
        }
        int size = arr.length;
        boolean[] visited = new boolean[size];
        Map<Integer, List<Integer>> valToIndexMap = initMap(arr, size);
        QueueImpl<Integer> q = new QueueImpl<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int qSize = q.getSize();
            for (int i = 0; i < qSize; i += 1) {
                int curIndex = q.poll();
                if (curIndex == size - 1) {
                    return count;
                }
                int prev = Math.max(0, curIndex - 1);
                int next = Math.min(size - 1, curIndex + 1);
                if (!visited[prev]) {
                    visited[prev] = true;
                    q.add(prev);
                }
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
                if (valToIndexMap.containsKey(arr[curIndex])) {
                    for (int index : valToIndexMap.get(arr[curIndex])) {
                        if (!visited[index]) {
                            visited[index] = true;
                            q.add(index);
                        }
                    }
                }
                valToIndexMap.remove(arr[curIndex]);
            }
            count += 1;
        }
        return count;
    }

    private Map<Integer, List<Integer>> initMap(int[] arr, int size) {
        Map<Integer, List<Integer>> valToIndexMap = new HashMap<>(size);
        for (int i = 0; i < size; i += 1) {
            List<Integer> indexesList = valToIndexMap.getOrDefault(arr[i], new ArrayList<>(size));
            indexesList.add(i);
            valToIndexMap.putIfAbsent(arr[i], indexesList);
        }
        return valToIndexMap;
    }
}
