package ArraysAndStrings.Intervals;

import org.junit.Assert;
import org.junit.Test;

public class MergeIntervalsTest {

    @Test
    public void merge_test1() {
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };
        int[][] ans = new int[][]{
                new int[]{1, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };

        MergeIntervals m = new MergeIntervals();
        int[][] res = m.merge(intervals);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void merge_test2() {
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6}
        };
        int[][] ans = new int[][]{
                new int[]{1, 6}
        };

        MergeIntervals m = new MergeIntervals();
        int[][] res = m.merge(intervals);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void merge_test3() {
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{3, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };
        int[][] ans = new int[][]{
                new int[]{1, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };

        MergeIntervals m = new MergeIntervals();
        int[][] res = m.merge(intervals);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void merge_test4() {
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{4, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };
        int[][] ans = new int[][]{
                new int[]{1, 3},
                new int[]{4, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };

        MergeIntervals m = new MergeIntervals();
        int[][] res = m.merge(intervals);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void merge_test5() {
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{9, 18}
        };
        int[][] ans = new int[][]{
                new int[]{1, 6},
                new int[]{8, 18}
        };

        MergeIntervals m = new MergeIntervals();
        int[][] res = m.merge(intervals);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void merge_test6() {
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6}
        };
        int[][] ans = new int[][]{
                new int[]{1, 6}
        };

        MergeIntervals m = new MergeIntervals();
        int[][] res = m.merge(intervals);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void merge_test7() {
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{4, 6}
        };
        int[][] ans = new int[][]{
                new int[]{1, 3},
                new int[]{4, 6}
        };

        MergeIntervals m = new MergeIntervals();
        int[][] res = m.merge(intervals);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void merge_test8() {
        int[][] intervals = new int[][]{
                new int[]{4, 6}
        };
        int[][] ans = new int[][]{
                new int[]{4, 6}
        };

        MergeIntervals m = new MergeIntervals();
        int[][] res = m.merge(intervals);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void merge_test9() {
        int[][] intervals = new int[][]{
                new int[]{1, 4},
                new int[]{0, 2},
                new int[]{3, 5}
        };
        int[][] ans = new int[][]{
                new int[]{0, 5}
        };

        MergeIntervals m = new MergeIntervals();
        int[][] res = m.merge(intervals);
        Assert.assertArrayEquals(ans, res);
    }

}