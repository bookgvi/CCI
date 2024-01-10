package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AmountTimeBinaryTreeBeInfectedTest {

    private AmountTimeBinaryTreeBeInfected a;

    @Before
    public void init() {
        a = new AmountTimeBinaryTreeBeInfected();
    }

    @Test
    public void amountOfTime() {
        AmountTimeBinaryTreeBeInfected.TreeNode root = initTree();
        int start = 3;
        int res = a.amountOfTime(root, start);
        assertEquals(4, res);
    }

    private AmountTimeBinaryTreeBeInfected.TreeNode initTree() {
        AmountTimeBinaryTreeBeInfected.TreeNode root = new AmountTimeBinaryTreeBeInfected.TreeNode(1);
        root.left = new AmountTimeBinaryTreeBeInfected.TreeNode(5);
        root.right = new AmountTimeBinaryTreeBeInfected.TreeNode(3);

        root.left.right = new AmountTimeBinaryTreeBeInfected.TreeNode(4);
        root.left.right.left = new AmountTimeBinaryTreeBeInfected.TreeNode(9);
        root.left.right.right = new AmountTimeBinaryTreeBeInfected.TreeNode(2);

        root.right.left = new AmountTimeBinaryTreeBeInfected.TreeNode(10);
        root.right.right = new AmountTimeBinaryTreeBeInfected.TreeNode(6);
        return root;
    }
}