package graphUtils;

import graph.TreeNode;
import org.junit.Test;

import java.util.List;

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
        Integer[] arr = new Integer[]{1, 2,3, null,4,5,6, null,null,7, 8, 9,10,11,12, null,null,null,null,13,14,15,16,17,18,19,20,21,22,23,24};
        TreeNode root = g.construct(arr);
    }

    @Test
    public void from_arr_to_treenode_test3() {
        Graph g = new Graph();
        Integer[] arr = new Integer[]{1, 2,3, null,4,5,6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
        TreeNode root = g.construct(arr);
    }

    @Test
    public void graphLevels_test() {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode(2, null, new TreeNode(4));
        root.right = new TreeNode(3, new TreeNode(5), new TreeNode(6));
        BFS bfs = new BFS();
        List<List<Integer>> res = bfs.levelOrder(root);
    }
}