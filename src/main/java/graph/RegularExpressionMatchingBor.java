package graph;

import java.util.*;

public class RegularExpressionMatchingBor {


    static class Bor {
        Node root = new Node("root", "");
        Map<Character, Integer> specSymbols = new HashMap<>();

        {
            specSymbols.put('*', 1);
            specSymbols.put('.', 1);
        }

        boolean match(String text, String exp) {
            boolean res = true;
            if (text == null || exp == null) {
                return res;
            }
            init(exp);
            createAutomata();
            int index = 0;
            Node cur = this.root;
            for (char ch : exp.toCharArray()) {
                index += 1;
                if (Objects.equals('*', ch)) {
                    break;
                }
                String letter = String.valueOf(ch);
                cur = findByChar(cur, letter);
                if (Objects.equals(root, cur)) {
                    Node next = cur.children.get(letter);
                    if (next == null) {
                        continue;
                    }
                    cur = next;
                }
//                fillResultMap(resMap, cur, index);

            }
            return res;
        }

        Map<String, List<Integer>> analyzeText(String text, List<String> words) {
            Map<String, List<Integer>> resMap = new HashMap<>();
            if (text == null || words == null) {
                return resMap;
            }
            for (String word : words) {
                init(word, false);
            }
            createAutomata();
            int index = 0;
            Node cur = this.root;
            for (char ch : text.toCharArray()) {
                index += 1;
                String letter = String.valueOf(ch);
                cur = findByChar(cur, letter);
                if (Objects.equals(root, cur)) {
                    Node next = cur.children.get(letter);
                    if (next == null) {
                        continue;
                    }
                    cur = next;
                }
                fillResultMap(resMap, cur, index);
            }
            return resMap;
        }

        private void fillResultMap(Map<String, List<Integer>> resMap, Node cur, int index) {
            if (cur == null || resMap == null) {
                return;
            }
            for(Node node : cur.goBySuffixLink) {
                int pos = index - node.prefix.length();
                List<Integer> positions = resMap.getOrDefault(node.prefix, new ArrayList<>());
                positions.add(pos);
                resMap.put(node.prefix, positions);
            }
        }

        Node findByChar(Node cur, String letter) {
            if (cur.children.get(letter) == null && cur.suffixLink.children.get(letter) != null) {
                return cur.suffixLink.children.get(letter);
            } else if (cur.children.get(letter) != null) {
                return cur.children.get(letter);
            }
            return this.root;
        }

        void init(String word) {
            init(word, true);
        }

        void init(String word, boolean isReInit) {
            if (word == null) {
                return;
            }

            this.root = isReInit ? new Node("root", "") : this.root;
            Node cur = this.root;
            StringBuilder prefix = new StringBuilder();
            for (char ch : word.toCharArray()) {
                String letter = String.valueOf(ch);
                prefix.append(ch);
                if (cur.children.get(letter) == null) {
                    Node next = new Node(letter, prefix.toString());
                    cur.children.put(letter, next);
                    next.parent = cur;
                }
                cur = cur.children.get(letter);
            }
            cur.isTerminal = true;
        }

        void createAutomata() {
            setUnvisited(this.root);
            Queue<Node> q = new Queue<>();
            setRootSuffixLink();
            q.add(this.root);
            while (!q.empty()) {
                Node parent = q.poll();
                parent.isVisited = true;
                for (Map.Entry<String, Node> childEntry : parent.children.entrySet()) {
                    Node child = childEntry.getValue();
                    if (!child.isVisited) {
                        q.add(child);
                        setSuffixLink(child, parent);
                    }
                }
            }
            setGoBySuffix(this.root);
        }

        void setGoBySuffix(Node root) {
            for (Map.Entry<String, Node> childEntry : root.children.entrySet()) {
                Node child = childEntry.getValue();
                fillGoBySuffix(child, child.goBySuffixLink);
                setGoBySuffix(child);
            }
        }

        void fillGoBySuffix(Node cur, List<Node> goBySuffixMap) {
            if (cur.isTerminal) {
                goBySuffixMap.add(cur);
            }
            if (Objects.equals(this.root, cur)) {
                return;
            }
            fillGoBySuffix(cur.suffixLink, goBySuffixMap);
        }

        void setSuffixLink(Node cur, Node parent) {
            Node parentSuffixLink = parent.suffixLink;
            if (cur.suffixLink == null) {
                cur.suffixLink = parentSuffixLink.children.get(cur.val);
                if (cur.suffixLink == null) {
                    cur.suffixLink = root;
                }
            }
        }

        void setRootSuffixLink() {
            this.root.suffixLink = root;
            for (Map.Entry<String, Node> childEntry : this.root.children.entrySet()) {
                childEntry.getValue().suffixLink = this.root;
            }
        }

        void setUnvisited(Node cur) {
            if (cur == null) {
                return;
            }
            cur.isVisited = false;
            for (Map.Entry<String, Node> childEntry : cur.children.entrySet()) {
                setUnvisited(childEntry.getValue());
            }
        }

        static class Node {
            String val;
            String prefix;
            Node parent;
            Node suffixLink;
            Map<String, Node> children = new HashMap<>();
            List<Node> goBySuffixLink = new ArrayList<>();
            boolean isTerminal;
            boolean isVisited;

            Node() {
                this(null, null);
            }

            Node(String val, String prefix) {
                this.val = val;
                this.prefix = prefix;
            }
        }

        private static class Queue<T> {
            private ListNode<T> head = null;
            private ListNode<T> tail = null;
            private int size = 0;

            public Queue() {
                // empty
            }

            public boolean empty() {
                return size == 0;
            }

            public void add(T val) {
                if (tail == null) {
                    head = tail = new ListNode<>(val);
                } else {
                    tail.next = new ListNode<>(val);
                    tail = tail.next;
                }
                incSize();
            }

            public T poll() {
                T val = null;
                if (size > 0) {
                    val = head.val;
                    head = head.next;
                }
                if (head == null) {
                    tail = null;
                }
                decSize();
                return val;
            }

            private void decSize() {
                size = Math.max(size - 1, 0);
            }

            private void incSize() {
                size += 1;
            }

            private static class ListNode<T> {
                T val;
                ListNode<T> next;

                ListNode() {
                    this(null, null);
                }

                ListNode(ListNode<T> next) {
                    this(null, next);
                }

                ListNode(T val) {
                    this(val, null);
                }

                ListNode(T val, ListNode<T> next) {
                    this.val = val;
                    this.next = next;
                }
            }
        }
    }
}
