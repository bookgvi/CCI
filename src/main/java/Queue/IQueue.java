package Queue;

public interface IQueue<T> {
    boolean add(T elt);
    boolean offer(T elt);
    T poll();
    boolean isEmpty();
}
