package graphUtils;

import Queue.genericQueue.*;
import Queue.genericQueue.Queue;

import java.util.*;
import java.util.stream.Collectors;

public class Bor {
    public static final Bor INSTANCE = new Bor();

    private Node<String> root = new Node<>("root", "");

    private Bor() {
        // empty
    }

    public static Bor getInstance() {
        return INSTANCE;
    }

    public void init(String[] words) {
        init(Arrays.stream(words).collect(Collectors.toList()));
    }

    public void init(Collection<String> words) {
        root = new Node<>("root", "");
        for (String word : words) {
            addWord(word);
        }
    }

    public void addWord(String word) {
        if (word == null) {
            return;
        }
        StringBuilder prefix = new StringBuilder();
        Node<String> cur = root;
        for (char ch : word.toCharArray()) {
            prefix.append(ch);
            Node<String> node = cur.children.get(String.valueOf(ch));
            if (node == null) {
                node = new Node<>();
                node.prefix = prefix.toString();
                node.val = String.valueOf(ch);
                node.parent = cur;
                cur.children.put(node.val, node);
            }
            cur = cur.children.get(node.val);
        }
        cur.isFinish = true;
    }

    public void bfs() {
        IQueue<Node<String>> q = new Queue<>();
        q.add(root);
        System.out.println("BFS:");
        while (!q.empty()) {
            Node<String> cur = q.poll();
            String parent = cur.parent != null
                    ? cur.parent.val + "->"
                    : "";
            System.out.print(parent + cur.val + " ");
            Map<String, Node<String>> childrenMap = cur.children;
            for (Map.Entry<String, Node<String>> child : childrenMap.entrySet()) {
                if (!child.getValue().isVisited) {
                    child.getValue().isVisited = true;
                    q.add(child.getValue());
                }
            }
        }
        System.out.println();
    }

    public void dfs() {
        dfs(root);
        System.out.println();
    }

    private void dfs(Node<String> cur) {
        Map<String, Node<String>> childrenMap = cur.children;
        for (Map.Entry<String, Node<String>> child : childrenMap.entrySet()) {
            if (!child.getValue().isVisited) {
                String parent = child.getValue().parent != null
                        ? child.getValue().parent.val
                        : "";
                System.out.print(parent + "->" + child.getKey() + " ");
                child.getValue().isVisited = true;
                dfs(child.getValue());
            }
        }
    }

    private static class Node<T> {
        T val;
        String prefix;
        Map<T, Node<T>> children = new HashMap<>();
        Node<T> parent;
        boolean isFinish = false;
        boolean isVisited = false;

        Node() {
            this(null, null, null);
        }

        Node(T val) {
            this(val, null, null);
        }

        Node(T val, String prefix) {
            this(val, prefix, null);
        }

        Node(T val, String prefix, Node<T> parent) {
            this.val = val;
            this.prefix = prefix;
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(val, node.val) && Objects.equals(prefix, node.prefix) && Objects.equals(parent, node.parent);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, prefix, parent);
        }
    }
}
