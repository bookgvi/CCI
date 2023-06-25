package graphUtils;

import graph.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Breadth first search
 */
public class BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> graph = new ArrayList<>();
        Queue<TreeNode> q = new Queue<>();
        q.add(root);
        while (q.size() > 0) {
            int qLen = q.size();
            graph.add(new ArrayList<>());
            for (int j = 0; j < qLen; j += 1) {
                TreeNode curNode = q.poll();
                graph.get(graph.size() - 1).add(curNode.val);
                q.add(curNode.left);
                q.add(curNode.right);
            }
        }
        return graph;
    }

    public static class Queue<E> {
        private final LinkedList<E> queue = new LinkedList<>();

        public Queue() {
        }

        public boolean add(E elt) {
            boolean res = false;
            if (elt != null) {
                res = queue.add(elt);
            }
            return res;
        }
        public E poll() {
            return queue.size() > 0 ? queue.poll() : null;
        }
        public int size() {
            return queue.size();
        }
    }
}
