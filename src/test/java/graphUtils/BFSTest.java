package graphUtils;

import graph.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BFSTest {

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