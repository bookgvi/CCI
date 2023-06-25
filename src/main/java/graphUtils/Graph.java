package graphUtils;

import Queue.Queue;
import graph.TreeNode;

public class Graph {
    /**
     * Assemble tree from array
     * algorithm base on BFS
     * </p>
     *                           0  (1)     (2)   (3)    (4)   (5)   (6)      (7)    (8)     (9)   (10)   (11)   (12)
     * Integer[] arr = new Integer[]{1, 2,3, null,4, 5, 6,  7, 8, 9,10, 11,12,   13,14, 15,16, 17,18, 19,20, 21,22, 23,24}
     * </p>
     *   0)                                  1
     *                                 /           \
     *                             /                  \
     *   1)                    2                         3
     *                     /       \                   /   \
     *                  /            \              /        \
     *   3)         null              4           5           6
     *                              /  \        /  \        /  \
     *   7)                       7     8     9     10    11    12
     *                           / \   / \   / \   / \   / \   / \
     *   15)                    13 14 15 16 17 18 19 20 21 22 23 24
     *
     * @param arr - array of values for tree nodes
     * @return root of the tree
     */
    public TreeNode construct(Integer[] arr) {
        TreeNode root = new TreeNode();
        int arrLen;
        if (arr == null || (arrLen = arr.length) < 1 || arr[0] == null) {
            return null;
        }
        root.val = arr[0];
        Queue<TreeNode> q = new Queue<TreeNode>();
        q.add(root);
        int index = 0;
        while (q.isNotEmpty()) {
            index = ((index + 1) << 1) - 1;
            int nextIndex = ((index + 1) << 1) - 1;
            for (int j = index; j < nextIndex && q.isNotEmpty(); j += 2) {
                TreeNode cur = q.poll();
                if (j < arrLen && arr[j] != null) {
                    cur.left = new TreeNode(arr[j]);
                }
                if (j < arrLen - 1 && arr[j + 1] != null) {
                    cur.right = new TreeNode(arr[j + 1]);
                }
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return root;
    }
}
