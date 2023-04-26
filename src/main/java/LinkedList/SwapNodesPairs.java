package LinkedList;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">...</a>
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying
 * the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
public class SwapNodesPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(-1, head);
        int len = 0, i = 0;
        while (head != null) {
            head = head.next;
            len += 1;
        }
        if (len == 0) {
            return null;
        }
        head = sentinel.next;
        ListNode[] arr = new ListNode[len];
        int k = 2, j = 0;
        while(head != null) {
            ListNode reverseHead = head;
            ListNode prev = head;
            while (head != null && i < k) {
                ListNode curHead = reverseHead;
                reverseHead = head;
                head = head.next;
                reverseHead.next = curHead;
                i += 1;
            }
            i = 0;
            arr[j++] = reverseHead;
            prev.next = null;
        }
        ListNode res = arr[0];
        ListNode dummy = res;
        for (i = 1; i < len && arr[i] != null; i += 1) {
            while(res.next != null) {
                res = res.next;
            }
            res.next = arr[i];
        }
        return dummy;
    }
}
