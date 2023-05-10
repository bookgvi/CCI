package LinkedList;

/**
 * <a href="https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/">...</a>
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 * <p>
 * The most significant bit is at the head of the linked list.
 */
public class ConvertBinaryNumberLinkedListInteger {
    public int getDecimalValue(ListNode head) {
        if (head.next == null) {
            return head.val;
        }
        int val = 0;
        while (head != null && head.val == 0) {
            head = head.next;
        }
        head = reverse(head);
        int i = 0;
        while(head != null) {
            val += head.val << i++;
            head = head.next;
        }
        return val;
    }

    private ListNode reverse(ListNode head) {
        ListNode reverse = null;
        while (head != null) {
            ListNode newHead = head;
            head = head.next;
            newHead.next = reverse;
            reverse = newHead;
        }
        return reverse;
    }
}
