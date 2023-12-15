package Queue.simpleQueue;

import lombok.*;

import java.util.Objects;

public class QueueImpl<T> implements Queue<T> {

    private Entry<T> head;
    private Entry<T> tail;

    private int size;

    public int getSize() {
        return size;
    }

    @Override
    public boolean add(T elt) {
        Entry<T> newNode = new Entry<>(elt);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }

        size += 1;
        return true;
    }

    @Override
    public boolean offer(T elt) {
        return add(elt);
    }

    @Override
    public T poll() {
        if (head != null) {
            T val = head.getVal();
            head = head.next;
            size -= 1;
            if (head == null) {
                tail = null;
            }
            return val;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Entry<T> reverse() {
        Entry<T> sentinel = null;
        while (head != null) {
            Entry<T> tmp = head.next;
            head.next = sentinel;
            sentinel = head;
            head = tmp;
        }
        head = sentinel;
        while(sentinel != null && sentinel.next != null) {
            sentinel = sentinel.next;
        }
        tail = sentinel;
        return head;
    }

    @Getter
    @Setter
    private static class Entry<T> {
        private T val;
        private Entry<T> next;

        Entry(T val) {
            this(val, null);
        }

        Entry(T val, Entry<T> next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?> entry = (Entry<?>) o;
            return Objects.equals(val, entry.val) && Objects.equals(next, entry.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
