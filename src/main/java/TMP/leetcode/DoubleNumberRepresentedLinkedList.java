package TMP.leetcode;

public class DoubleNumberRepresentedLinkedList {

    public ListNode doubleIt(ListNode head) {
        ListNode reverseList = reverse(head);
        ListNode newList = multiply(reverseList, 2);
        return reverse(newList);
    }

    private ListNode multiply(ListNode head, int mul) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode h = new ListNode(-1, head);
        int extraDigit = 0;
        while(head != null) {
            head.val = head.val * mul + extraDigit;
            extraDigit = head.val / 10;
            head.val %= 10;
            head = head.next;
            h = h.next;
        }
        if (extraDigit != 0) {
            h.next = new ListNode(extraDigit);
        }
        return sentinel.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode reverse = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = reverse;
            reverse = head;
            head = next;
        }
        return reverse;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
