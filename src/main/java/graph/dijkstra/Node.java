package graph.dijkstra;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Node<T> {
    private final T t;

    public Node(T t) {
        this.t = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(t, node.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t);
    }

    @Override
    public String toString() {
        return "Node{" +
                "t=" + t +
                '}';
    }
}
