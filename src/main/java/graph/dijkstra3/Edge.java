package graph.dijkstra3;

import java.util.Objects;

public class Edge {
    private final int source;
    private final int dest;
    private final int weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return source == edge.source && dest == edge.dest && weight == edge.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, dest, weight);
    }
}
