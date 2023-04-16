package LinkedList;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">...</a>
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinelForReverse = new ListNode(Integer.MIN_VALUE, null);
        ListNode dummyForReverse = sentinelForReverse;
        ListNode sentinelForHead = new ListNode(Integer.MIN_VALUE, null);
        sentinelForHead.next = head;
        ListNode dummyForHead = sentinelForHead;
        int pos = 1;
        while (head.next != null) {
            ListNode prev = sentinelForHead;
            while (left <= pos && pos <= right) {
                ListNode curReverse = sentinelForReverse.next;
                sentinelForReverse.next = head;
                head = head.next;
                sentinelForReverse.next.next = curReverse;
                pos += 1;
            }
            if (sentinelForReverse.next != null) {
                while (dummyForReverse.next != null) {
                    dummyForReverse = dummyForReverse.next;
                }
                dummyForReverse.next = head;
                prev.next = sentinelForReverse.next;
                break;
            } else {
                pos += 1;
                head = head.next;
                sentinelForHead = sentinelForHead.next;
            }
        }
        return dummyForHead.next;
    }
}
