package LinkedList;

/**
 * <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/">...</a>
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * <p>
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋
 * denotes the largest integer less than or equal to x.
 * <p>
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 */
public class DeleteMiddleNodeLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        ListNode prevNode = head;
        ListNode slow = head.next;
        if (slow == null) {
            return null;
        }
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            prevNode = prevNode.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != null) {
            prevNode.next = slow.next;
        }
        return head;
    }
}
