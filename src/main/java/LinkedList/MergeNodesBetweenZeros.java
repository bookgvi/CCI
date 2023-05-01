package LinkedList;

/**
 * <a href="https://leetcode.com/problems/merge-nodes-in-between-zeros/">...</a>
 * You are given the head of a linked list, which contains a series of integers separated by 0's.
 * The beginning and end of the linked list will have Node.val == 0.
 * <p>
 * For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum
 * of all the merged nodes. The modified list should not contain any 0's.
 * <p>
 * Return the head of the modified linked list.
 */
public class MergeNodesBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode sentinelRes = res;
        head = head.next;
        int sum = 0;
        while (head != null) {
            while (head.val != 0) {
                sum += head.val;
                head = head.next;
            }
            res.next = new ListNode(sum);
            res = res.next;
            head = head.next; // skip 0 value
            sum = 0;
        }
        return sentinelRes.next;
    }

    public ListNode mergeNodes2(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode sentinel = res;
        head = head.next;
        int sum = 0;
        while (head != null) {
            if (head.val != 0) {
                sum += head.val;
            } else {
                res.next = new ListNode(sum);
                res = res.next;
                sum = 0;
            }
            head = head.next;
        }
        return sentinel.next;
    }
}
