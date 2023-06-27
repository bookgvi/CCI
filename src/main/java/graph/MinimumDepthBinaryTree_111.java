package graph;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">...</a>
 * <p>
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthBinaryTree_111 {

    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null) {
            return minDepthDFS(root.left) + 1;
        } else if (root.left == null) {
            return minDepthDFS(root.right) + 1;
        }
        return Math.min(minDepthDFS(root.left), minDepthDFS(root.right)) + 1;
    }

    public int minDepthBFS(TreeNode root) {
        Queue<TreeNode> q = new Queue<>();
        int minDepth = 0;
        q.add(root);
        while (q.isNotEmpty()) {
            for (int i = 0, len = q.size(); i < len; i += 1) {
                TreeNode cur = q.poll();
                if (cur != null) {
                    if (cur.left == null && cur.right == null) {
                        return minDepth + 1;
                    }
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            minDepth += 1;
        }
        return minDepth;
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
