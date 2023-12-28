package graph.task;
import org.junit.Test;
import static org.junit.Assert.*;

public class SlidingWindowMaximumTest {

    @Test
    public void testMaxSlidingWindow() {
        SlidingWindowMaximum slidingWindow = new SlidingWindowMaximum();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        int[] result = slidingWindow.maxSlidingWindow(nums, k);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSlidingWindow2() {
        SlidingWindowMaximum slidingWindow = new SlidingWindowMaximum();

        int[] nums = {1, -1};
        int k = 1;
        int[] expected = {1,-1};
        int[] result = slidingWindow.maxSlidingWindow(nums, k);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSlidingWindow3() {
        SlidingWindowMaximum slidingWindow = new SlidingWindowMaximum();

        int[] nums = {7,2,4};
        int k = 2;
        int[] expected = {7,4};
        int[] result = slidingWindow.maxSlidingWindow(nums, k);
        assertArrayEquals(expected, result);
    }
    @Test
    public void testMaxSlidingWindow4() {
        SlidingWindowMaximum slidingWindow = new SlidingWindowMaximum();

        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int k = 5;
        int[] expected = {10,10,9,2};
        int[] result = slidingWindow.maxSlidingWindow(nums, k);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSlidingWindow_EmptyArray() {
        SlidingWindowMaximum slidingWindow = new SlidingWindowMaximum();

        int[] nums = {};
        int k = 3;
        int[] expected = {};
        int[] result = slidingWindow.maxSlidingWindow(nums, k);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSlidingWindow_KGreaterThanArraySize() {
        SlidingWindowMaximum slidingWindow = new SlidingWindowMaximum();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 10;
        int[] expected = {};
        int[] result = slidingWindow.maxSlidingWindow(nums, k);
        assertArrayEquals(expected, result);
    }
}