package stack.genericStack;

import java.util.Objects;

/**
 * Thread safe stack based on LinkedList
 * @param <T>
 */
public class Stack<T> implements IStack<T> {
    private ListNode<T> head = null;
    private int size = 0;
    private final int MAX_SIZE;

    public Stack() {
        this(0);
    }

    public Stack(int size) {
        this.MAX_SIZE = size;
    }

    /**
     * Immutable node for LinkedList
     * @param <T>
     */
    private static class ListNode<T> {
        T val;
        ListNode<T> next;

        ListNode(T val) {
            this(val, null);
        }

        ListNode(T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }
    }


    @Override
    public synchronized void push(T val) throws StackOverflowException {
        if (val == null) {
            throw new IllegalStateException("bad value");
        } else if (size >= MAX_SIZE) {
            throw new StackOverflowException("Max size limit exceed");
        } else {
            head = new ListNode<T>(val, head);
            size += 1;
        }
    }

    @Override
    public synchronized T pop() {
        if (size == 0 || MAX_SIZE == 0) {
            return null;
        }
        T val = head != null ? head.val : null;
        head = head != null ? head.next : null;
        size -= 1;
        if (size < 0) {
            size = 0;
        }
        return val;
    }

    @Override
    public synchronized int size() {
        return this.size;
    }

    @Override
    public synchronized void reverse() {
        ListNode<T> newHead = null;
        while (head != null) {
            ListNode<T> next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        head = newHead;
    }

    /**
     * 0 index nearest position of element in the stack
     *
     * @param val find this value
     * @return position number of value or -1
     */
    @Override
    public synchronized int find(T val) {
        int pos = -1;
        ListNode<T> sentinel = new ListNode<>(null, head);
        while (head != null) {
            pos += 1;
            if (Objects.equals(val, head.val)) {
                head = sentinel.next;
                return pos;
            }
            head = head.next;
        }
        pos = pos == size - 1 ? -1 : pos;
        head = sentinel.next;
        return pos;
    }

    @Override
    public synchronized T peek() {
        if (size == 0 || MAX_SIZE == 0) {
            return null;
        }
        return head.val;
    }

    @Override
    public synchronized T peek(int index) {
        if (size == 0 || MAX_SIZE == 0 || index >= size || index < 0) {
            return null;
        }
        ListNode<T> sentinel = new ListNode<>(null, head);
        int i = 0;
        while (i < index && head.next != null) {
            head = head.next;
            i += 1;
        }
        T res = head.val;
        head = sentinel.next;
        return res;
    }
}
