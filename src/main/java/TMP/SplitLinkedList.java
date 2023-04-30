package TMP;

import LinkedList.ListNode;

public class SplitLinkedList {
    public ListNode proceed(ListNode head, int pos) {
        ListNode dummy = head;
        ListNode prev = new ListNode(-1, head);
        int i = 0;
        while (dummy != null && pos > i) {
            dummy = dummy.next;
            prev = prev.next;
            i += 1;
        }
        prev.next = null;
        return dummy;
    }
}
