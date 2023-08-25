package Queue.genericQueue;

public interface IQueue<T> {
    T peek();

    T poll();

    void add(T val);

    int size();

    boolean empty();

    void reverse();
}
