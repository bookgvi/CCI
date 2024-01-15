package graph.task;

import java.util.*;

public class FindPlayersWithZeroOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losesCounterMap = new HashMap<>();
        Map<Integer, List<Integer>> losesMap = new HashMap<>();
        for (int[] match : matches) {
            losesMap.computeIfAbsent(match[1], v -> new ArrayList<>()).add(match[0]);
            losesMap.computeIfAbsent(match[0], v -> new ArrayList<>());
            int curCount = losesCounterMap.getOrDefault(match[1], 0);
            losesCounterMap.put(match[1], ++curCount);
            losesCounterMap.putIfAbsent(match[0], 0);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneLoseList = new ArrayList<>();
        List<Integer> noLoseList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : losesMap.entrySet()) {
            int player = entry.getKey();
            if (losesCounterMap.get(player) == 1) {
                oneLoseList.add(player);
            } else if (losesCounterMap.get(player) == 0) {
                noLoseList.add(player);
            }
        }
        oneLoseList.sort(Comparator.comparingInt(a -> a));
        noLoseList.sort(Comparator.comparingInt(a -> a));
        result.add(noLoseList);
        result.add(oneLoseList);
        return result;
    }
}
