package graph.task;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathWithMinimumEffortTest {

    @Test
    public void testMinimumEffortPath1() {
        PathWithMinimumEffort pathFinder = new PathWithMinimumEffort();

        // Test case 1: Minimum effort path exists
        int[][] heights1 = {
                {1,2,1,1,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,1,1,2,1}
        };
        int expected1 = 0;
        int result1 = pathFinder.minimumEffortPath(heights1);
        assertEquals(expected1, result1);
    }
    @Test
    public void testMinimumEffortPath2() {
        PathWithMinimumEffort pathFinder = new PathWithMinimumEffort();

        // Test case 1: Minimum effort path exists
        int[][] heights1 = {{1,10,6,7,9,10,4,9}};
        int expected1 = 2;
        int result1 = pathFinder.minimumEffortPath(heights1);
    }
    @Test
    public void testMinimumEffortPath() {
        PathWithMinimumEffort pathFinder = new PathWithMinimumEffort();

        // Test case 1: Minimum effort path exists
        int[][] heights1 = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        int expected1 = 2;
        int result1 = pathFinder.minimumEffortPath(heights1);
        assertEquals(expected1, result1);

        // Test case 2: Minimum effort path does not exist
        int[][] heights2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int expected2 = 3;
        int result2 = pathFinder.minimumEffortPath(heights2);
        assertEquals(expected2, result2);

        // Test case 3: Single cell grid
        int[][] heights3 = {{5}};
        int expected3 = 0;
        int result3 = pathFinder.minimumEffortPath(heights3);
        assertEquals(expected3, result3);

    }

    @Test
    public void testMinimumEffortPathScenario1() {
        // Test scenario 1
        PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
        int[][] heights = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int expectedPathEffort = 3;

        int actualPathEffort = pathWithMinimumEffort.minimumEffortPath(heights);

        assertEquals(expectedPathEffort, actualPathEffort);
    }

    @Test
    public void testMinimumEffortPathScenario2() {
        // Test scenario 2
        PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
        int[][] heights = {{3, 2}, {1, 3}};
        int expectedPathEffort = 1;

        int actualPathEffort = pathWithMinimumEffort.minimumEffortPath(heights);

        assertEquals(expectedPathEffort, actualPathEffort);
    }
}