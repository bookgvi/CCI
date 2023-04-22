package LinkedList;

/**
 * <a href="https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/">...</a>
 * <p>
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until
 * there are no such sequences.
 * <p>
 * After doing so, return the head of the final linked list.  You may return any such answer.
 * <p>
 * <p>
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        int sum = head.val, incrementSum = head.val;
        while (head != null) {
            ListNode dummy = sentinel.next;
            ListNode prevDummy = sentinel;
            while (dummy != head && sum != 0) {
                prevDummy = dummy;
                sum -= dummy.val;
                dummy = sum != 0 ? dummy.next : dummy;
            }
            if (sum == 0) {
                prevDummy.next = head.next;
            }
            head = head.next;
            if (head != null) {
                incrementSum += head.val;
            }
            sum = incrementSum;
        }
        return sentinel.next;
    }
}
