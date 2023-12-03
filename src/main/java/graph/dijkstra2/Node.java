package graph.dijkstra2;

import java.util.Objects;

public class Node {
    private final String title;

    public Node(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(title, node.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Node{" +
                "title='" + title + '\'' +
                '}';
    }
}
