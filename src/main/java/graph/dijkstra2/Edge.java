package graph.dijkstra2;

import java.util.Objects;

public class Edge<T> {
    private final T source;
    private final T dest;
    private final int weight;

    public Edge(T source, T dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public T getSource() {
        return source;
    }

    public T getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return weight == edge.weight && Objects.equals(source, edge.source) && Objects.equals(dest, edge.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, dest, weight);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", dest=" + dest +
                ", weight=" + weight +
                '}';
    }
}