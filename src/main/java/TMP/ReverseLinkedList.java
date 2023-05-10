package TMP;

import LinkedList.ListNode;

public class ReverseLinkedList {
    public ListNode[] reverseHalf(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode[]{head, head};
        }
        ListNode reverse = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            ListNode newHead = slow;
            slow = slow.next;
            fast = fast.next.next;
            newHead.next = reverse;
            reverse = newHead;
        }
        return new ListNode[]{reverse, slow};
    }
}
