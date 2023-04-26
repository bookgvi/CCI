package LinkedList;

/**
 *
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode solution(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head != null ? head.next : null;
        int duplicate = 1;
        while (ptr2 != null) {
            if (ptr1.val == ptr2.val) {
                duplicate += 1;
                ptr1.next = null;
            } else {
                duplicate = 1;
            }
            if (duplicate <= 1) {
                ptr1.next = ptr2;
                ptr1 = ptr1.next;
            }
            ptr2 = ptr2.next;
        }
        return head;
    }
}
