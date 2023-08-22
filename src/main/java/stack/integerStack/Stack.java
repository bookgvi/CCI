package stack.integerStack;

/**
 * Thread safe stack based on LinkedList
 */
public class Stack implements IStack {
    private ListNode head = null;
    private int size = 0;

    @Override
    public synchronized void push(Integer val) {
        if (val == null) {
            throw new IllegalStateException("null is not proper value");
        }
        head = new ListNode(val, head);
        size += 1;
    }

    @Override
    public synchronized Integer pop() {
        Integer headVal = head != null ? head.getVal() : null;
        head = head != null ? head.getNext() : null;
        size -= 1;
        if (size < 0) {
            size = 0;
        }
        return headVal;
    }

    @Override
    public synchronized int size() {
        return this.size;
    }
}
