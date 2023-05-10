package LinkedList;

/**
 * <a href="https://leetcode.com/problems/odd-even-linked-list/description/">...</a>
 * Given the head of a singly linked list, group all the nodes with odd indices together followed
 * by the nodes with even indices, and return the reordered list.
 * <p>
 * The first node is considered odd, and the second node is even, and so on.
 * <p>
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * <p>
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resOdd = head;
        ListNode resOddSentinel = resOdd;
        ListNode resEven = head.next;
        ListNode resEvenSentinel = resEven;
        while (resOdd.next != null && resEven.next != null) {
            resOdd.next = resOdd.next.next;
            resEven.next = resEven.next.next;
            resEven = resEven.next;
            resOdd = resOdd.next;
        }
        resOdd.next = resEvenSentinel;
        return resOddSentinel;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resOdd = new ListNode(-1);
        ListNode resOddSentinel = resOdd;
        ListNode resEven = new ListNode(-1);
        ListNode resEvenSentinel = resEven;
        ListNode ptr = head;
        while (ptr != null) {
            resOdd.val = ptr.val;
            resOdd.next = new ListNode(-1);
            resOdd = ptr.next != null && ptr.next.next != null ? resOdd.next : resOdd;

            ptr = ptr.next;
            if (ptr != null) {
                resEven.val = ptr.val;
                resEven.next = new ListNode(-1);
                resEven = ptr.next != null && ptr.next.next != null ? resEven.next : resEven;
            }

            ptr = ptr != null ? ptr.next : null;
        }
        resOdd.next = resEvenSentinel;
        resEven.next = null;
        return resOddSentinel;
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resOdd = new ListNode(-1);
        ListNode resOddSentinel = resOdd;
        ListNode resEven = new ListNode(-1);
        ListNode resEvenSentinel = resEven;
        ListNode odd = head;
        ListNode even = head.next;
        while (odd != null || even != null) {
            if (odd != null) {
                resOdd.val = odd.val;
                odd = odd.next != null ? odd.next.next : null;
                resOdd.next = new ListNode(-1);
                resOdd = odd != null ? resOdd.next : resOdd;
            }
            if (even != null) {
                resEven.val = even.val;
                even = even.next != null ? even.next.next : null;
                resEven.next = new ListNode(-1);
                resEven = even != null ? resEven.next : resEven;
            }
        }
        resOdd.next = resEvenSentinel;
        resEven.next = null;
        return resOddSentinel;
    }
}
