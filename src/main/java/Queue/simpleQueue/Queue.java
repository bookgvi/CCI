package Queue.simpleQueue;

public interface Queue<T> {
    boolean add(T elt);
    boolean offer(T elt);
    T poll();
    boolean isEmpty();
}
