package graph.task;

import java.util.*;
import java.util.stream.Collectors;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjMap = transformToAdjMapWithPrice(flights);
        List<List<int[]>> paths = getPaths(adjMap, src, dst, k);
        int totalPrice = Integer.MAX_VALUE;
        if (paths.isEmpty()) {
            return -1;
        }
        List<List<int[]>> filteredPaths = paths.stream().filter(list -> list.size() == k || list.size() == k + 2 || list.size() == k + 1).collect(Collectors.toList());
        if (!filteredPaths.isEmpty()) {
            paths = filteredPaths;
        }
        for (List<int[]> path : paths) {
            int curPrice = 0;
            for (int[] node : path) {
                curPrice += node[1];
            }
            totalPrice = Math.min(totalPrice, curPrice);
        }
        return totalPrice;
    }

    List<List<int[]>> getPaths(Map<Integer, List<int[]>> adjMap, int src, int dst, int k) {
        List<List<int[]>> paths = new ArrayList<>();
        LinkedList<List<int[]>> q = new LinkedList<>();
        boolean[] visited = new boolean[adjMap.size() + 1];
        q.offer(Collections.singletonList(new int[]{src, 0}));
        while(!q.isEmpty()) {
            List<int[]> curPath = q.poll();
            int cur = curPath.get(curPath.size() - 1)[0];

            if (cur == dst) {
                if (curPath.size() >= k + 1) {
                    paths.add(curPath);
                }
            }
            if (cur != dst) visited[cur] = true;
            for (int[] neighbour : adjMap.getOrDefault(cur, Collections.singletonList(new int[]{}))) {
                if (neighbour.length > 0) {
                    int node = neighbour[0];
                    if (!visited[node]) {
                        List<int[]> newPath = new ArrayList<>(curPath);
                        newPath.add(neighbour);
                        q.add(newPath);
                    }
                }
            }
        }
        return paths;
    }

    private Map<Integer, List<int[]>> transformToAdjMapWithPrice(int[][] graph) {
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int[] nodes : graph) {
            int src = nodes[0];
            int dst = nodes[1];
            int price = nodes[2];
            int[] dstWithPrice = new int[]{dst, price};
            List<int[]> dstList = adjMap.getOrDefault(src, new ArrayList<>());
            dstList.add(dstWithPrice);
            adjMap.putIfAbsent(src, dstList);
        }
        return adjMap;
    }

}
