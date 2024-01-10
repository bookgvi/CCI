package graph.task;

import java.util.*;

class AmountTimeBinaryTreeBeInfected {

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        convertToGraph(root, -1, graph);
        Queue<Set<Integer>> q = new LinkedList<>();
        q.add(Collections.singleton(start));
        boolean[] visited = new boolean[(int) 1e5 + 1];
        int lvl = -1;
        while (!q.isEmpty()) {
            ++lvl;
            Set<Integer> vList = q.poll();
            Set<Integer> newVList = new HashSet<>(3);
            for (int v : vList) {
                visited[v] = true;
            }
            for (int v : vList) {
                for (int u : graph.get(v)) {
                    if (!visited[u]) {
                        newVList.add(u);
                    }
                }
            }
            if (!newVList.isEmpty()) {
                q.add(newVList);
            }
        }
        return lvl;
    }

    private void convertToGraph(TreeNode root, int rootVal, Map<Integer, List<Integer>> graph) {
        if (root == null) {
            return;
        }
        graph.putIfAbsent(root.val, new ArrayList<>(3));
        if (rootVal != -1) {
            graph.computeIfAbsent(root.val, v -> new ArrayList<>()).add(rootVal);
        }
        if (root.left != null) {
            graph.computeIfAbsent(root.val, v -> new ArrayList<>()).add(root.left.val);
            convertToGraph(root.left, root.val, graph);
        }
        if (root.right != null) {
            graph.computeIfAbsent(root.val, v -> new ArrayList<>()).add(root.right.val);
            convertToGraph(root.right, root.val, graph);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}