package graph.task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ConvertArrayIntoArrayWithConditionsTest {

    private ConvertArrayIntoArrayWithConditions c;

    @Before
    public void init() {
        c = new ConvertArrayIntoArrayWithConditions();
    }

    @Test
    public void findMatrix() {
        int[] nums = new int[]{1, 3, 4, 1, 2, 3, 1};
        int[][] expected = new int[][]{{1, 3, 4, 2}, {1, 3}, {1}};
        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(Arrays.asList(1, 3, 4, 2));
        expectedList.add(Arrays.asList(1, 3));
        expectedList.add(Arrays.asList(1));
        List<List<Integer>> res = c.findMatrix(nums);
        assertListEquals(expectedList, res);
    }

    @Test
    public void findMatrix1() {
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(Arrays.asList(1, 2, 3, 4));
        List<List<Integer>> res = c.findMatrix(nums);
        assertListEquals(expectedList, res);
    }

    @Test
    public void findMatrix2() {
        int[] nums = new int[]{1, 1, 1, 1};
        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(Arrays.asList(1));
        expectedList.add(Arrays.asList(1));
        expectedList.add(Arrays.asList(1));
        expectedList.add(Arrays.asList(1));
        List<List<Integer>> res = c.findMatrix(nums);
        assertListEquals(expectedList, res);
    }

    @Test
    public void findMatrix3() {
        int[] nums = new int[]{4, 5, 3, 3, 3};
        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(Arrays.asList(4, 5, 3));
        expectedList.add(Arrays.asList(3));
        expectedList.add(Arrays.asList(3));
        List<List<Integer>> res = c.findMatrix(nums);
        assertListEquals(expectedList, res);
    }


    private void assertListEquals(List<List<Integer>> l1, List<List<Integer>> l2) {
        assertEquals(l1.size(), l2.size());
        int n1 = l1.size();
        for (int i = 0; i < n1; ++i) {
            if (l1.get(i).size() == l2.get(i).size()) {
                assertTrue(true);
            }
            int n2 = l1.get(i).size();
            for (int j = 0; j < n2; ++j) {
                assertEquals(l1.get(i).get(j), l2.get(i).get(j));
            }
        }
    }
}