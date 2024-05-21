package TMP.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SubsetsTest {

    @Test
    public void test1() {
        Subsets s = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> result = List.of(
                List.of(1), List.of(2), List.of(3),
                List.of(1,2), List.of(1,3), List.of(2,3),
                List.of(1,2,3)
                );
        List<List<Integer>> ans = s.subsets(nums);
    }
    @Test
    public void test2() {
        Subsets s = new Subsets();
        int[] nums = {0};
        List<List<Integer>> result = List.of(
                new ArrayList<>(), List.of(0)
                );
        List<List<Integer>> ans = s.subsets(nums);
    }
}