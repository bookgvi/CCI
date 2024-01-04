package graph.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MinimumNumberOperationsMakeArrayEmpty {

    public int minOperations(int[] nums) {
        int len = nums.length;
        Map<Integer, List<Integer>> valueToIndeciesMap = new HashMap<>(len);
        for (int i = 0; i < len; i += 1) {
            valueToIndeciesMap.putIfAbsent(nums[i], new ArrayList<>());
            valueToIndeciesMap.get(nums[i]).add(i);
        }
        int counter = 0;
        for (Map.Entry<Integer, List<Integer>> entry : valueToIndeciesMap.entrySet()) {
            List<Integer> indecies = entry.getValue();
            int tmpLen = indecies.size();
            if (tmpLen < 2) {
                return -1;
            }
            while (tmpLen > 1) {
                if (tmpLen >= 5) {
                    tmpLen -= 3;
                    counter += 1;
                } else if (tmpLen % 3 == 0) {
                    tmpLen -= 3;
                    counter += 1;
                } else {
                    tmpLen -= 2;
                    counter += 1;
                }
            }
            if (tmpLen != 0) {
                return -1;
            }
        }
        return counter;
    }

    public int minOperations1(int[] nums) {
        int len = nums.length;
        Map<Integer, List<Integer>> valueToIndeciesMap = new HashMap<>(len);
        for (int i = 0; i < len; i += 1) {
            valueToIndeciesMap.putIfAbsent(nums[i], new ArrayList<>());
            valueToIndeciesMap.get(nums[i]).add(i);
        }
        int operations = 0;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i += 1) {
            if (!visited[i]) {
                int count = dfs(i, valueToIndeciesMap, nums, visited);
                if (count == -1) {
                    return -1;
                }
                count = count % 5 == 0
                        ? count / 5
                        : count % 3 == 0
                            ? count / 3
                            : count % 2 == 0
                                ? count / 2
                                : count;
                operations += count;
            }
        }
        return operations;
    }

    private int dfs(int index, Map<Integer, List<Integer>> valueToIndeciesMap, int[] nums, boolean[] visited) {
        int val = nums[index];
        int count = 0;
        visited[index] = true;
        List<Integer> indecies = valueToIndeciesMap.get(val);
        int indeciesSize = indecies.size();
        if (indeciesSize < 2) {
            return -1;
        } else if (indeciesSize % 2 == 0) {
            count += 1;
        } else if (indeciesSize % 3 == 0) {
            count += 1;
        } else if (indeciesSize % 5 == 0) {
            count += 2;
        }

        for (int i : indecies) {
            if (!visited[i]) {
                int operations = dfs(i, valueToIndeciesMap, nums, visited);
                if (operations == -1) {
                    return -1;
                }
                count += operations;
            }
        }
        return count;
    }
}
