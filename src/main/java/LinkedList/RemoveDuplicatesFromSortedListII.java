package LinkedList;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">...</a>
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        if (head != null && head.next == null) {
            return head;
        }

        // check first node
        if (head != null && head.next != null && head.val != head.next.val) {
            dummy.next = new ListNode(head.val);
            dummy = dummy.next;
        }

        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            head = head.next;
            if (head != null && head.next != null && head.val != head.next.val) {
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
            } else if (head != null && head.next == null && dummy.val != head.val) { // check last node
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
            }
        }
        return res.next;
    }
}
