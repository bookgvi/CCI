package graph.task.permutation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PermutationBacktrackingTest {

    @Before
    public void setUp() throws Exception {
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    @Test
    public void proceed() {
        PermutationBacktracking permutation = new PermutationBacktracking();
        int n = 4;
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{0, 1, 2, 3});
        expected.add(new int[]{0, 1, 3, 2});
        expected.add(new int[]{0, 2, 1, 3});
        expected.add(new int[]{0, 2, 3, 1});
        expected.add(new int[]{0, 3, 1, 2});
        expected.add(new int[]{0, 3, 2, 1});
        expected.add(new int[]{1, 0, 2, 3});
        expected.add(new int[]{1, 0, 3, 2});
        expected.add(new int[]{1, 2, 0, 3});
        expected.add(new int[]{1, 2, 3, 0});
        expected.add(new int[]{1, 3, 0, 2});
        expected.add(new int[]{1, 3, 2, 0});
        expected.add(new int[]{2, 0, 1, 3});
        expected.add(new int[]{2, 0, 3, 1});
        expected.add(new int[]{2, 1, 0, 3});
        expected.add(new int[]{2, 1, 3, 0});
        expected.add(new int[]{2, 3, 0, 1});
        expected.add(new int[]{2, 3, 1, 0});
        expected.add(new int[]{3, 0, 1, 2});
        expected.add(new int[]{3, 0, 2, 1});
        expected.add(new int[]{3, 1, 0, 2});
        expected.add(new int[]{3, 1, 2, 0});
        expected.add(new int[]{3, 2, 0, 1});
        expected.add(new int[]{3, 2, 1, 0});

        List<int[]> result = permutation.proceed(n);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testPermutationBacktrackingWithZero() {
        PermutationBacktracking permutation = new PermutationBacktracking();
        int n = 0;
        List<int[]> expected = new ArrayList<>();
        List<int[]> result = permutation.proceed(n);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testPermutationBacktrackingWithNegativeNumber() {
        PermutationBacktracking permutation = new PermutationBacktracking();
        int n = -5;
        List<int[]> expected = new ArrayList<>();
        List<int[]> result = permutation.proceed(n);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testPermutationBacktrackingWithLargeNumber() {
        PermutationBacktracking permutation = new PermutationBacktracking();
        int n = 10;
        List<int[]> result = permutation.proceed(n);
        assertEquals(factorial(n), result.size());
    }



    @Test
    public void testPermutationBacktrackingWithOne() {
        PermutationBacktracking permutation = new PermutationBacktracking();
        int n = 1;
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{0});
        List<int[]> result = permutation.proceed(n);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testPermutationBacktrackingWithTwo() {
        PermutationBacktracking permutation = new PermutationBacktracking();
        int n = 2;
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{0, 1});
        expected.add(new int[]{1, 0});
        List<int[]> result = permutation.proceed(n);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testPermutationBacktrackingWithThree() {
        PermutationBacktracking permutation = new PermutationBacktracking();
        int n = 3;
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{0, 1, 2});
        expected.add(new int[]{0, 2, 1});
        expected.add(new int[]{1, 0, 2});
        expected.add(new int[]{1, 2, 0});
        expected.add(new int[]{2, 0, 1});
        expected.add(new int[]{2, 1, 0});
        List<int[]> result = permutation.proceed(n);
        assertArrayEquals(expected.toArray(), result.toArray());
    }
}