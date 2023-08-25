package Queue.genericQueue;

public class Queue<T> implements IQueue<T> {
    private ListNode<T> head = null;
    private ListNode<T> tail = null;
    private int size = 0;

    public Queue() {

    }

    @Override
    public T peek() {
        T val = null;
        if (size > 0) {
            val = head.val;
        }
        return val;
    }

    @Override
    public T poll() {
        T val = null;
        if (size > 0) {
            val = head.val;
            head = head.next;
        }
        if (head == null) {
            tail = null;
        }
        decSize();
        return val;
    }

    @Override
    public void add(T val) {
        if (tail == null) {
            head = tail = new ListNode<>(val);
        } else {
            tail.next = new ListNode<>(val);
            tail = tail.next;
        }
        incSize();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    private void decSize() {
        size = Math.max(size - 1, 0);
    }

    private void incSize() {
        size += 1;
    }

    private static class ListNode<T> {
        T val;
        ListNode<T> next;

        ListNode() {
            this(null, null);
        }

        ListNode(T val) {
            this(val, null);
        }

        ListNode(T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }
    }
}
