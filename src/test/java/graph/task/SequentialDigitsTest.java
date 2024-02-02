package graph.task;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SequentialDigitsTest {

    @Test
    public void testSequentialDigits() {
        SequentialDigits sequentialDigits = new SequentialDigits();

        // Test case 1: low = 100, high = 300
        int low1 = 100;
        int high1 = 300;
        List<Integer> expected1 = Arrays.asList(123, 234);
        assertArrayEquals(expected1, sequentialDigits.sequentialDigits(low1, high1));

        // Test case 2: low = 1000, high = 13000
        int low2 = 1000;
        int high2 = 13000;
        List<Integer> expected2 = Arrays.asList(1234, 2345, 3456, 4567, 5678, 6789, 12345);
        assertArrayEquals(expected2, sequentialDigits.sequentialDigits(low2, high2));

        // Test case 3: low = 10, high = 100000
        int low3 = 10;
        int high3 = 100000;
        List<Integer> expected3 = Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789);
        assertArrayEquals(expected3, sequentialDigits.sequentialDigits(low3, high3));

        // Test case 4: low = 1, high = 9
        int low4 = 10;
        int high4 = 90;
        List<Integer> expected4 = Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89);
        assertArrayEquals(expected4, sequentialDigits.sequentialDigits(low4, high4));

        // Test case 5: low = 100, high = 1000
        int low5 = 100;
        int high5 = 1000;
        List<Integer> expected5 = Arrays.asList(123, 234, 345, 456, 567, 678, 789);
        assertArrayEquals(expected5, sequentialDigits.sequentialDigits(low5, high5));

        int low6 = 10;
        int high6 = 10;
        List<Integer> expected6 = Arrays.asList();
        assertArrayEquals(expected6, sequentialDigits.sequentialDigits(low6, high6));

        int low7 = 99;
        int high7 = 160;
        List<Integer> expected7 = Arrays.asList(123);
        assertArrayEquals(expected7, sequentialDigits.sequentialDigits(low7, high7));
    }

    private void assertArrayEquals(List<Integer> l1, List<Integer> l2) {
        int n1 = l1.size(), n2 = l2.size();
        assertEquals(n1, n2);
        for (int i = 0; i < n1; ++i) {
            assertEquals(l1.get(i), l2.get(i));
        }
    }
}