package stack.genericStack;

import java.util.Objects;

/**
 * Immutable node for LinkedList
 * @param <T>
 */
public class ListNode<T> {
    private T val;
    ListNode<T> next;

    ListNode(T val) {
        this(val, null);
    }

    ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public ListNode<T> getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(getVal(), listNode.getVal()) && Objects.equals(getNext(), listNode.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal(), getNext());
    }
}
