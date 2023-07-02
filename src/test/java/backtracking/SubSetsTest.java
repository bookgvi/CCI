package backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SubSetsTest {

    @Test
    public void getSubsets_test1() {
        int[] set = new int[]{1,2,3,4};
        int ssCount = (1 << set.length) - 1;
        SubSets s = new SubSets();
        List<List<Integer>> res = s.getSubsets(set);
        Assert.assertEquals(ssCount, res.size());
    }

    @Test
    public void getSubsets_test2() {
        int[] set = new int[]{1,2,3};
        int ssCount = (1 << set.length) - 1;
        SubSets s = new SubSets();
        List<List<Integer>> res = s.getSubsets(set);
        Assert.assertEquals(ssCount, res.size());
    }

    @Test
    public void getSubsets_test3() {
        int[] set = new int[]{1,2,3,4,5};
        int ssCount = (1 << set.length) - 1;
        SubSets s = new SubSets();
        List<List<Integer>> res = s.getSubsets(set);
        Assert.assertEquals(ssCount, res.size());
    }
}