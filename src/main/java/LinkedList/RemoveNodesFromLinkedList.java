package LinkedList;

/**
 * <a href="https://leetcode.com/problems/remove-nodes-from-linked-list/">...</a>
 * <p>
 * You are given the head of a linked list.
 * <p>
 * Remove every node which has a node with a strictly greater value anywhere to the right side of it.
 * <p>
 * Return the head of the modified linked list.
 */
public class RemoveNodesFromLinkedList {

    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode prev = new ListNode(-1, head);
        ListNode sentinel = prev;
        while(head != null) {
            if (prev.val <= head.val) {
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
        }
        prev.next = null;
        return reverse(sentinel.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode reverseHead = head;
        ListNode prev = new ListNode(-1, head);
        while (head != null) {
            ListNode curHead = reverseHead;
            reverseHead = head;
            head = head.next;
            reverseHead.next = curHead;
            prev = prev.next;
        }
        prev.next = null;
        return reverseHead;
    }
}
