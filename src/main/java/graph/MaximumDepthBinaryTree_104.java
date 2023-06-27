package graph;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">...</a>
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new Queue<>();
        int depth = 0;
        q.add(root);
        while (q.isNotEmpty()) {
            for (int i = 0, qLen = q.size(); i < qLen; i += 1) {
                TreeNode cur = q.poll();
                if (cur != null) {
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            depth += 1;
        }
        return depth;
    }

    private static class Queue<E> {
        private final LinkedList<E> queue = new LinkedList<>();

        boolean add(E elt) {
            if (elt != null) {
                return queue.add(elt);
            }
            return false;
        }

        E poll() {
            return isEmpty() ? null : queue.poll();
        }

        int size() {
            return queue.size();
        }

        boolean isEmpty() {
            return size() < 1;
        }

        boolean isNotEmpty() {
            return !isEmpty();
        }
    }
}
