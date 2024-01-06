package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumProfitJobSchedulingTest {

    private MaximumProfitJobScheduling jobScheduling;
//    private MaximumProfitJobScheduling.MaximumProfitJobs jobScheduling;

    @Before
    public void init() {
        jobScheduling = new MaximumProfitJobScheduling();
//        jobScheduling = new MaximumProfitJobScheduling.MaximumProfitJobs();
    }
    @Test
    public void testExample1() {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        assertEquals(120, jobScheduling.jobScheduling(startTime, endTime, profit));
    }

    @Test
    public void testExample2() {
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        assertEquals(150, jobScheduling.jobScheduling(startTime, endTime, profit));
    }

    @Test
    public void testExample3() {
        int[] startTime = {1, 1, 1};
        int[] endTime = {2, 3, 4};
        int[] profit = {5, 6, 4};
        assertEquals(6, jobScheduling.jobScheduling(startTime, endTime, profit));
    }


}