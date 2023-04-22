package LinkedList;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers-ii/">...</a>
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extraDigit = 0;
        ListNode reverseL1 = reverseList(l1);
        ListNode reverseL2 = reverseList(l2);
        ListNode reverseAns = new ListNode(Integer.MIN_VALUE, null);
        ListNode dummyReverseAns = reverseAns;
        ListNode prevReverseAns = new ListNode(Integer.MIN_VALUE, reverseAns);
        while (reverseL1 != null && reverseL2 != null) {
            int sum = reverseL1.val + reverseL2.val + extraDigit;
            int digit = sum % 10;
            extraDigit = sum / 10;
            reverseAns.val = digit;
            reverseAns.next = new ListNode(digit, null);
            reverseAns = reverseAns.next;
            prevReverseAns = prevReverseAns.next;
            reverseL1 = reverseL1.next;
            reverseL2 = reverseL2.next;
        }
        while (reverseL1 != null) {
            int sum = reverseL1.val + extraDigit;
            int digit = sum % 10;
            extraDigit = sum / 10;
            reverseAns.val = digit;
            reverseAns.next = new ListNode(digit, null);
            reverseAns = reverseAns.next;
            prevReverseAns = prevReverseAns.next;
            reverseL1 = reverseL1.next;
        }
        while (reverseL2 != null) {
            int sum = reverseL2.val + extraDigit;
            int digit = sum % 10;
            extraDigit = sum / 10;
            reverseAns.val = digit;
            reverseAns.next = new ListNode(digit, null);
            reverseAns = reverseAns.next;
            prevReverseAns = prevReverseAns.next;
            reverseL2 = reverseL2.next;
        }
        prevReverseAns.next = extraDigit != 0 ? new ListNode(extraDigit, null) : null;
        return reverseList(dummyReverseAns);
    }

    private ListNode reverseList(ListNode head) {
        ListNode reverseHead = head;
        ListNode prev = new ListNode(Integer.MIN_VALUE, head);
        while (head != null) {
            ListNode curHead = reverseHead;
            reverseHead = head;
            head = head.next;
            reverseHead.next = curHead;
            prev = prev.next;
        }
        prev.next = null;
        return reverseHead;
    }
}
