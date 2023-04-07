package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr.
 * If there are duplicates in arr, count them separately.
 */
public class CountingElements {
    public int countElements(int[] arr) {
        int ans = 0;
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int elt : arr) {
            numToCountMap.put(elt, numToCountMap.containsKey(elt) ? numToCountMap.get(elt) + 1 : 1);
        }
        for (Map.Entry<Integer, Integer> entry : numToCountMap.entrySet()) {
            Integer v = numToCountMap.get(entry.getKey() + 1);
            if (v != null) {
                ans += entry.getValue();
            }
        }
        return ans;
    }
}
