package graph.task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class VariableDivisionTest {
    private final VariableDivision v = new VariableDivision();

    @Test
    public void testCalcEquation() {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));

        double[] expected = {6.0, 0.5};

        double[] result = v.calcEquation(equations, values, queries);

        assertArrayEquals(expected, result, 0.0001);
    }

    @Test
    public void testCalcEquation2() {
        // Test case 1
        List<List<String>> equations1 = new ArrayList<>();
        equations1.add(Arrays.asList("a", "b"));
        equations1.add(Arrays.asList("b", "c"));
        equations1.add(Arrays.asList("c", "d"));

        double[] values1 = {2.0, 3.0, 4.0};

        List<List<String>> queries1 = new ArrayList<>();
        queries1.add(Arrays.asList("a", "d"));
        queries1.add(Arrays.asList("b", "d"));

        double[] expected1 = {24.0, 12.0};

        double[] result1 = v.calcEquation(equations1, values1, queries1);

        assertArrayEquals(expected1, result1, 0.0001);

        // Test case 2
        List<List<String>> equations2 = new ArrayList<>();
        equations2.add(Arrays.asList("x", "y"));

        double[] values2 = {0.5};

        List<List<String>> queries2 = new ArrayList<>();
        queries2.add(Arrays.asList("x", "y"));
        queries2.add(Arrays.asList("y", "x"));

        double[] expected2 = {0.5, 2.0};

        double[] result2 = v.calcEquation(equations2, values2, queries2);

        assertArrayEquals(expected2, result2, 0.0001);
    }
}