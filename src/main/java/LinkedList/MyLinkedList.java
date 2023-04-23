package LinkedList;

/**
 * <a href="https://leetcode.com/problems/design-linked-list/">...</a>
 * <p>
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node,
 * and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node
 * in the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * <p>
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion,
 * the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list.
 * If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 */
public class MyLinkedList {

    private ListNode sentinel;
    private int size; // 0-index

    public MyLinkedList() {
        this.sentinel = new ListNode();
        this.size = 0;
    }

    public int get(int index) {
        int i = -1, res = -1;
        if (index >= size || index < 0) {
            return res;
        }
        ListNode dummy = sentinel;
        while (dummy != null && i <= index) {
            res = dummy.val;
            i += 1;
            dummy = dummy.next;
        }
        return res;
    }

    public void addAtHead(int val) {
        ListNode newSentinel = new ListNode();
        ListNode dummy = sentinel;
        sentinel.val = val;
        sentinel = newSentinel;
        newSentinel.next = dummy;
        size += 1;
    }

    public void addAtTail(int val) {
        ListNode dummy = sentinel;
        while (dummy.next != null) {
            dummy = dummy.next;
        }
        dummy.next = new ListNode();
        dummy.next.val = val;
        size += 1;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        } else if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            ListNode dummy = sentinel;
            int i = 0; // we need prev val to change
            while (dummy.next != null && i < index) {
                dummy = dummy.next;
                i += 1;
            }
            ListNode saveNext = dummy.next;
            ListNode newNode = new ListNode();
            newNode.val = val;
            newNode.next = saveNext;
            dummy.next = newNode;
            size += 1;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        int i = 0; // we need prev node
        ListNode dummy = sentinel;
        while(dummy.next != null && i < index) {
            i += 1;
            dummy = dummy.next;
        }
        dummy.next = dummy.next != null ? dummy.next.next : null;
        size -= 1;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode() {
            this.val = -1;
            this.next = null;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
