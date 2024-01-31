package graph.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DailyTemperaturesTest {

    @Test
    public void testDailyTemperatures() {
        DailyTemperatures dt = new DailyTemperatures();

        // Test case 1: temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected1 = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expected1, dt.dailyTemperatures(temperatures1));

        // Test case 2: temperatures = [89, 62, 70, 58, 47, 91, 82, 77]
        int[] temperatures2 = {89, 62, 70, 58, 47, 91, 82, 77};
        int[] expected2 = {5, 1, 3, 2, 1, 0, 0, 0};
        assertArrayEquals(expected2, dt.dailyTemperatures(temperatures2));

        // Test case 3: temperatures = [100, 90, 80, 70, 60, 50, 40, 30]
        int[] temperatures3 = {100, 90, 80, 70, 60, 50, 40, 30};
        int[] expected3 = {0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected3, dt.dailyTemperatures(temperatures3));

        // Test case 4: temperatures = [30, 40, 50, 60, 70, 80, 90, 100]
        int[] temperatures4 = {30, 40, 50, 60, 70, 80, 90, 100};
        int[] expected4 = {1, 1, 1, 1, 1, 1, 1, 0};
        assertArrayEquals(expected4, dt.dailyTemperatures(temperatures4));
    }
}