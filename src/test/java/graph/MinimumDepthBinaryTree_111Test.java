package graph;

import graphUtils.Graph;
import org.junit.Assert;
import org.junit.Test;

public class MinimumDepthBinaryTree_111Test {

    @Test
    public void minDepth_test1() {
        Graph g = new Graph();
        TreeNode root = g.construct(new Integer[]{3,9,20,null,null,15,7});

        MinimumDepthBinaryTree_111 m = new MinimumDepthBinaryTree_111();
        int res = m.minDepthDFS(root);
        int ans = 2;
        Assert.assertEquals(ans, res);
    }

    @Test
    public void minDepth_test2() {
        Graph g = new Graph();
        TreeNode root = g.construct(new Integer[]{2,null,3,null,4,null,5,null,6});

        MinimumDepthBinaryTree_111 m = new MinimumDepthBinaryTree_111();
        int res = m.minDepthDFS(root);
        int ans = 5;
        Assert.assertEquals(ans, res);
    }

}