package graphUtils;

import graph.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BFSTest {

    @Test
    public void from_arr_to_treenode_test1() {
        Graph g = new Graph();
        Integer[] arr = new Integer[]{1, 2, 3, null, null, 4, 5};
        TreeNode root = g.construct(arr);
    }

    @Test
    public void from_arr_to_treenode_test2() {
        Graph g = new Graph();
        Integer[] arr = new Integer[]{1, 2, 3, null, 4, 5, 6, null, null, 7, 8, 9, 10, 11, 12, null, null, null, null, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        TreeNode root = g.construct(arr);
    }

    @Test
    public void from_arr_to_treenode_test3() {
        Graph g = new Graph();
        Integer[] arr = new Integer[]{1, 2, 3, null, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        TreeNode root = g.construct(arr);
    }

    @Test
    public void graphLevels_test() {
        Graph g = new Graph();
        TreeNode root = g.construct(new Integer[]{3, 9, 20, null, null, 15, 7});
        Integer[][] ansArr = new Integer[][]{{3}, {9, 20}, {15, 7}};
        List<List<Integer>> ans = Arrays.stream(ansArr)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        BFS bfs = new BFS();
        List<List<Integer>> res = bfs.levelOrder(root);
        assertEquals(ans, res);
    }

    @Test
    public void graphLevels_test2() {
        Graph g = new Graph();
        TreeNode root = g.construct(new Integer[]{3,9,20,null,null,15,7,1,1,1,2,3});
        Integer[][] ansArr = new Integer[][]{{3},{9,20},{15,7},{1,1,1,2},{3}};
        List<List<Integer>> ans = Arrays.stream(ansArr)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        BFS bfs = new BFS();
        List<List<Integer>> res = bfs.levelOrder(root);
        assertEquals(ans, res);
    }

    @Test
    public void graphLevels_test3() {
        Graph g = new Graph();
        TreeNode root = g.construct(new Integer[]{null});
        List<List<Integer>> ans = new ArrayList<>();
        BFS bfs = new BFS();
        List<List<Integer>> res = bfs.levelOrder(root);
        assertEquals(ans, res);
    }

    private void assertEquals(List<List<Integer>> ans, List<List<Integer>> res) {
        Assert.assertEquals(ans.size(), res.size());
        int p1 = 0, len1 = ans.size();
        while (p1 < len1) {
            List<Integer> arrFromAns = ans.get(p1);
            List<Integer> arrFromRes = res.get(p1);
            Assert.assertEquals(arrFromAns.size(), arrFromRes.size());
            for (int pp1 = 0, len = arrFromAns.size(); pp1 < len; pp1 += 1) {
                Assert.assertEquals(arrFromAns.get(pp1), arrFromRes.get(pp1));
            }
            p1 += 1;
        }
    }
}