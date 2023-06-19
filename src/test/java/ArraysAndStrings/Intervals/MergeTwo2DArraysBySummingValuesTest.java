package ArraysAndStrings.Intervals;

import org.junit.Assert;
import org.junit.Test;

public class MergeTwo2DArraysBySummingValuesTest {

    @Test
    public void mergeArrays_test1() {
        int[][] nums1 = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{9, 18}
        };
        int[][] nums2 = new int[][]{
                new int[]{1, 6},
                new int[]{8, 18}
        };

        int[][] ans = new int[][]{
                new int[]{1, 9},
                new int[]{2, 6},
                new int[]{8, 28},
                new int[]{9, 18}
        };
        MergeTwo2DArraysBySummingValues m = new MergeTwo2DArraysBySummingValues();
        int[][] res = m.mergeArrays(nums1, nums2);
        Assert.assertArrayEquals(ans, res);
    }

    @Test
    public void mergeArrays_test2() {
        int[][] nums1 = new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{4, 5}
        };
        int[][] nums2 = new int[][]{
                new int[]{1, 4},
                new int[]{3, 2},
                new int[]{4, 1}
        };

        int[][] ans = new int[][]{
                new int[]{1, 6},
                new int[]{2, 3},
                new int[]{3, 2},
                new int[]{4, 6}
        };
        MergeTwo2DArraysBySummingValues m = new MergeTwo2DArraysBySummingValues();
        int[][] res = m.mergeArrays(nums1, nums2);
        Assert.assertArrayEquals(ans, res);
    }
}