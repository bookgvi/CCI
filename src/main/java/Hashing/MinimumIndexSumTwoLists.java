package Hashing;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/">...</a>
 * <p>
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 * A common string is a string that appeared in both list1 and list2.
 * A common string with the least index sum is a common string such that if
 * it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
 * <p>
 * Return all the common strings with the least index sum. Return the answer in any order.
 */
public class MinimumIndexSumTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> strToSumIndexMap1 = new HashMap<>();
        Map<String, Integer> strToSumIndexMap2 = new HashMap<>();
        Map<Integer, Set<String>> minIndexToStrArrMap = new HashMap<>();
        for (int i = 0, len = list1.length; i < len; i += 1) {
            strToSumIndexMap1.put(list1[i], i); // cause of all string in list1 and list2 are unique
        }
        for (int i = 0, len = list2.length; i < len; i += 1) {
            strToSumIndexMap2.put(list2[i], i); // cause of all string in list1 and list2 are unique
        }
        String[] ans = new String[strToSumIndexMap1.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : strToSumIndexMap1.entrySet()) {
            if (strToSumIndexMap2.containsKey(entry.getKey())) {
                Set<String> strSet = minIndexToStrArrMap.getOrDefault(entry.getValue() + strToSumIndexMap2.get(entry.getKey()), new HashSet<>());
                strSet.add(entry.getKey());
                minIndexToStrArrMap.put(entry.getValue() + strToSumIndexMap2.get(entry.getKey()), strSet);
            }
        }
        List<Integer> indexList = minIndexToStrArrMap.keySet().stream().sorted().collect(Collectors.toList());
        int minIndex = indexList.size() > 0 ? indexList.get(0) : -1;
        if (minIndex == -1) {
            return new String[]{};
        }
        for (String str : minIndexToStrArrMap.get(minIndex)) {
            ans[i++] = str;
        }
        return Arrays.copyOf(ans, i);
    }
}
