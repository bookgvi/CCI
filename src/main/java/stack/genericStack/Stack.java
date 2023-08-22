package stack.genericStack;

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

    @Override
    public synchronized void push(T val) throws StackOverflowException {
        if (val == null) {
            throw new IllegalStateException("bad value");
        }
        if (size >= MAX_SIZE) {
            throw new StackOverflowException("Max size limit exceed");
        }
        head = new ListNode<T>(val, head);
        size += 1;
    }

    @Override
    public synchronized T pop() {
        T val = head != null ? head.getVal() : null;
        head = head != null ? head.getNext() : null;
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
}
