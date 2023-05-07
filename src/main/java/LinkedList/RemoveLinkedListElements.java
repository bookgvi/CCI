package LinkedList;

/**
 * <a href="https://leetcode.com/problems/remove-linked-list-elements/">...</a>
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list
 * that has Node.val == val, and return the new head.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1, null);
        ListNode dummy = sentinel;
        while (head != null) {
            if (head.val != val) {
                dummy.next = head;
                dummy = dummy.next;
            }
            head = head.next;
        }
        dummy.next = null;
        return sentinel.next;
    }
}
