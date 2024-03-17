package TMP.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertIntervalTest {
    @Test
    public void testInsert() {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] expected1 = {{1, 5}, {6, 9}};
        assertArrayEquals(expected1, insertInterval.insert(intervals1, newInterval1));

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] expected2 = {{1, 2}, {3, 10}, {12, 16}};
        assertArrayEquals(expected2, insertInterval.insert(intervals2, newInterval2));

        int[][] intervals3 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval3 = {4, 6};
        int[][] expected3 = {{1, 2}, {3, 7}, {8, 10}, {12, 16}};
        assertArrayEquals(expected3, insertInterval.insert(intervals3, newInterval3));

        int[][] intervals4 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval4 = {4, 11};
        int[][] expected4 = {{1, 2}, {3, 11}, {12, 16}};
        assertArrayEquals(expected4, insertInterval.insert(intervals4, newInterval4));

        int[][] intervals5 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval5 = {18, 20};
        int[][] expected5 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}, {18, 20}};
        assertArrayEquals(expected5, insertInterval.insert(intervals5, newInterval5));
    }


}