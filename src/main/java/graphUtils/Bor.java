package graphUtils;

import Queue.genericQueue.*;
import Queue.genericQueue.Queue;

import java.util.*;
import java.util.stream.Collectors;

public class Bor {
    public static final Bor INSTANCE = new Bor();

    private volatile boolean isInit = false;
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
        if (this.isInit) {
            return;
        }
        root = new Node<>("root", "");
        for (String word : words) {
            addWord(word);
        }
        prepSuffixTree();
        this.isInit = true;
    }

    public Map<String, List<Integer>> findKeyWordsInText(String text) {
        return findKeyWordsInText(text, Collections.emptyList());
    }

    public Map<String, List<Integer>> findKeyWordsInText(String text, String[] words) {
        return findKeyWordsInText(text, Arrays.stream(words).collect(Collectors.toList()));
    }

    public Map<String, List<Integer>> findKeyWordsInText(String text, Collection<String> words) {
        Map<String, List<Integer>> wordAndPositionsMap = new HashMap<>();
        if (Objects.equals(text, "")) {
            return wordAndPositionsMap;
        }
        if (!this.isInit) {
            if (words == null || words.size() < 1) {
                return wordAndPositionsMap;
            }
            init(words);
        }
        Node<String> cur = root;
        int pos = 0;
        for (char ch : text.toCharArray()) {
            pos += 1;
            cur = findNodeByChar(cur, ch);
            if (cur == root) {
                if (cur.children.get(String.valueOf(ch)) != null) {
                    cur = cur.children.get(String.valueOf(ch));
                } else {
                    continue;
                }
            }
            fillWordAndPositionsMap(wordAndPositionsMap, cur, pos);
        }
        return wordAndPositionsMap;
    }

    public void dfs() {
        clearVisitedFlag(root);
        proceedDFS(root);
        System.out.println();
    }

    private void proceedDFS(Node<String> cur) {
        Map<String, Node<String>> childrenMap = cur.children;
        for (Map.Entry<String, Node<String>> childEntry : childrenMap.entrySet()) {
            if (!childEntry.getValue().isVisited) {
                String parent = childEntry.getValue().parent != null
                        ? childEntry.getValue().parent.val
                        : "";
                System.out.print(parent + "->" + childEntry.getKey() + " ");
                childEntry.getValue().isVisited = true;
                proceedDFS(childEntry.getValue());
            }
        }
    }

    /**
     * Преобразование бора в префикс-автомат. В каждой ноде будем хранить суффиксную ссылку на состояние, соответствующее
     * максимальному суффиксу строки в текущей вершине.
     */
    private void prepSuffixTree() {
        clearVisitedFlag(root);
        IQueue<Node<String>> q = new Queue<>();
        setRootSuffixLink();
        q.add(root);
        while (!q.empty()) {
            Node<String> cur = q.poll();
            Map<String, Node<String>> childrenMap = cur.children;
            for (Map.Entry<String, Node<String>> childEntry : childrenMap.entrySet()) {
                if (!childEntry.getValue().isVisited) {
                    childEntry.getValue().isVisited = true;
                    setSuffixLink(childEntry.getValue(), cur);
                    q.add(childEntry.getValue());
                }
            }
        }
        setGoBySuffixLink(root);
    }

    /**
     * Поиск ноды с текущей буквой по прямому совпадению в потомках или по суффиксной ссылке
     *
     * @param cur - текущая нода
     * @param ch  - символ из входного текста
     * @return - нода, содержащая букву или root
     */
    private Node<String> findNodeByChar(Node<String> cur, char ch) {
        String val = String.valueOf(ch);
        if (cur.children.get(val) == null && cur.suffixLink.children.get(val) != null) {
            return cur.suffixLink.children.get(val);
        } else if (cur.children.get(val) != null) {
            return cur.children.get(val);
        }
        return root;
    }

    /**
     * Заполнение коллекции для ответа на запрос анализа текста на предмет наличия ключевых слов
     *
     * @param wordAndPositionsMap - хэш-мап с результатом (слово и позиции в тексте, в которых оно начинается)
     * @param cur                 - текущая нода
     * @param pos                 - позиция в тексте
     */
    private void fillWordAndPositionsMap(Map<String, List<Integer>> wordAndPositionsMap, Node<String> cur, int pos) {
        for (Node<String> node : cur.goBySuffixLink) {
            List<Integer> positions = wordAndPositionsMap.getOrDefault(node.prefix, new ArrayList<>());
            positions.add(pos - node.prefix.length());
            wordAndPositionsMap.putIfAbsent(node.prefix, positions);
        }
    }


    private void setRootSuffixLink() {
        root.suffixLink = root;
        for (Map.Entry<String, Node<String>> rootChildEntry : root.children.entrySet()) {
            rootChildEntry.getValue().suffixLink = root;
        }
    }

    private void setSuffixLink(Node<String> cur, Node<String> parent) {
        Node<String> parentSuffixLink = parent.suffixLink;
        if (cur.suffixLink == null) {
            cur.suffixLink = parentSuffixLink.children.get(cur.val);
            if (cur.suffixLink == null) {
                cur.suffixLink = root;
            }
        }
    }

    /**
     * Формируем массив сжатых суффиксных ссылок (даст увеличение производительности при поиске)
     *
     * @param cur - текущая нода
     */
    private void setGoBySuffixLink(Node<String> cur) {
        for (Map.Entry<String, Node<String>> childEntry : cur.children.entrySet()) {
            fillGoBySuffixLink(childEntry.getValue(), childEntry.getValue().goBySuffixLink);
            setGoBySuffixLink(childEntry.getValue());
        }
    }

    private void fillGoBySuffixLink(Node<String> cur, List<Node<String>> goBySuffixLink) {
        if (cur.isFinish) {
            goBySuffixLink.add(cur);
        }
        if (Objects.equals(root, cur.suffixLink)) {
            return;
        }
        fillGoBySuffixLink(cur.suffixLink, goBySuffixLink);
    }

    private void addWord(String word) {
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

    private void clearVisitedFlag(Node<String> cur) {
        cur.isVisited = false;
        if (cur.isFinish) {
            return;
        }
        for (Map.Entry<String, Node<String>> childEntry : cur.children.entrySet()) {
            clearVisitedFlag(childEntry.getValue());
        }
    }

    ////////////////////////////////////////////////////////////////
    private static class Node<T> {
        T val;
        String prefix;
        Map<T, Node<T>> children = new HashMap<>();
        Node<T> parent;
        Node<T> suffixLink;
        List<Node<T>> goBySuffixLink = new ArrayList<>();
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
