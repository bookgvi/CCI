package ArraysAndStrings.Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/merge-intervals/">...</a>
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int j = 0, len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        int[][] res = new int[len][2];
        List<int[]> s = Arrays.stream(intervals).sorted(Comparator.comparingInt(arr -> arr[0])).collect(Collectors.toList());
        int start = s.get(0)[0];
        int end = s.get(0)[1];
        for (int i = 1; i < len; i += 1) {
            int startB = s.get(i)[0];
            int endB = s.get(i)[1];
            if (end >= startB) {
                end = Math.max(end, endB);
            } else {
                res[j++] = new int[]{start, end};
                start = startB;
                end = endB;
            }

        }
        res[j++] = new int[]{start, end};
        return Arrays.copyOf(res, Math.max(1, j));
    }
}
