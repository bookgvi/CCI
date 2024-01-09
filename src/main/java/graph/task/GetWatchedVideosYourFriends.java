package graph.task;

import java.util.*;

public class GetWatchedVideosYourFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];
        Deque<Set<Integer>> workQueue = new LinkedList<>();
        workQueue.add(Collections.singleton(id));
        while (!workQueue.isEmpty() && level > 0) {
            Set<Integer> curFriends = workQueue.poll();
            for (int curFriend : curFriends) {
                visited[curFriend] = true;
            }
            --level;
            Set<Integer> adjacencySet = new HashSet<>(n);
            workQueue.add(adjacencySet);
            for (int curFriend : curFriends) {
                for (int adj : friends[curFriend]) {
                    if (!visited[adj]) {
                        adjacencySet.add(adj);
                    }
                }
            }
        }
        List<String> videos = new ArrayList<>();
        Map<String, Integer> frequencyMap = new HashMap<>();

        if (!workQueue.isEmpty()) {
            Set<Integer> friendsOnLevel = workQueue.getLast();
            for (int friend : friendsOnLevel) {
                for (String video : watchedVideos.get(friend)) {
                    frequencyMap.put(video, frequencyMap.getOrDefault(video, 0) + 1);
                }
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> Objects.equals(a.getValue(), b.getValue()) ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue()
        );

        pq.addAll(frequencyMap.entrySet());

        while (!pq.isEmpty()) {
            videos.add(pq.poll().getKey());
        }

        return videos;
    }
}
