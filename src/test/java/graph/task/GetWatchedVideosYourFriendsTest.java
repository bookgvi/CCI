package graph.task;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GetWatchedVideosYourFriendsTest {

    private GetWatchedVideosYourFriends g;

    @Before
    public void init() {
        g = new GetWatchedVideosYourFriends();
    }

    @Test
    public void watchedVideosByFriends() {
        List<List<String>> watchedVideos = Arrays.asList(
                Arrays.asList("A","B"),
                Collections.singletonList("C"),
                Arrays.asList("B","C"),
                Collections.singletonList("D"));
        int[][] friends = new int[][]{{1,2},{0,3},{0,3},{1,2}};
        int id = 0, level = 1;

        List<String> expected = Arrays.asList("B","C");

        List<String> result = g.watchedVideosByFriends(watchedVideos, friends, id, level);

        assertTrue(isArrayEquals(expected, result));
    }

    @Test
    public void watchedVideosByFriends2() {
        List<List<String>> watchedVideos = Arrays.asList(
                Arrays.asList("A","B"),
                Collections.singletonList("C"),
                Arrays.asList("B","C"),
                Collections.singletonList("D"));
        int[][] friends = new int[][]{{1,2},{0,3},{0,3},{1,2}};
        int id = 0, level = 2;

        List<String> expected = Collections.singletonList("D");

        List<String> result = g.watchedVideosByFriends(watchedVideos, friends, id, level);

        assertTrue(isArrayEquals(expected, result));
    }

    @Test
    public void watchedVideosByFriends3() {
        List<List<String>> watchedVideos = Arrays.asList(
                Arrays.asList("A","B"),
                Collections.singletonList("C"),
                Arrays.asList("B","C"),
                Collections.singletonList("D"));
        int[][] friends = new int[][]{{1,2},{0,3},{0,3},{1,2}};
        int id = 1, level = 1;

        List<String> expected = Arrays.asList("A","B","D");

        List<String> result = g.watchedVideosByFriends(watchedVideos, friends, id, level);

        assertTrue(isArrayEquals(expected, result));
    }

    private boolean isArrayEquals(List<String> list1, List<String> list2) {
        if (list1 == null || list2 == null || list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0, len = list1.size(); i < len; ++i) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}