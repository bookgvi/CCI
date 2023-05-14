package TMP;

import LinkedList.ListNode;

public class MergeSortLInkedList {
    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = split(head);
        return merge(sort(head), sort(tail));
    }

    private ListNode split(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = new ListNode(-1, head);
        ListNode slow = head;
        ListNode fast = head;
        do {
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && fast.next != null);
        prev.next = null;
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode(-1);
        ListNode sentinel = merge;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                merge.next = l1;
                l1 = l1.next;
            } else {
                merge.next = l2;
                l2 = l2.next;
            }
            merge = merge.next;
        }
        if (l1 != null) {
            merge.next = l1;
        }
        if (l2 != null) {
            merge.next = l2;
        }
        return sentinel.next;
    }
}
