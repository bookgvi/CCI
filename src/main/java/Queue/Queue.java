package Queue;

import java.util.LinkedList;

public class Queue<E> {
    private final LinkedList<E> queue = new LinkedList<>();

    public Queue() {
    }

    public boolean add(E elt) {
        boolean res = false;
        if (elt != null) {
            res = queue.add(elt);
        }
        return res;
    }

    public E poll() {
        return queue.size() > 0 ? queue.poll() : null;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean isNotEmpty() {
        return !isEmpty();
    }
}
