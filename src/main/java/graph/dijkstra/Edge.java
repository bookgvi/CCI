package graph.dijkstra;

import lombok.Getter;

@Getter
class Edge<T> {
    private final T source;
    private final T destination;
    private final Integer weight;

    Edge(T source, T destination, Integer weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
