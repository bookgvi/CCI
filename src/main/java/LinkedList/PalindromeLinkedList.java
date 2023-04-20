package LinkedList;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">...</a>
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        } else if (head.next == null) {
            return true;
        }
        ListNode halfReverse = head;
        ListNode reverseSentinel = halfReverse;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            ListNode newReverseHead = slow;
            slow = slow.next;
            newReverseHead.next = halfReverse;
            halfReverse = newReverseHead;
            fast = fast.next.next;
        }
        reverseSentinel.next = null;
        while (halfReverse != null && slow != null) {
            if (halfReverse.val != slow.val) {
                slow = slow.next;
            }
            if (slow == null || halfReverse.val != slow.val) {
                return false;
            }
            halfReverse = halfReverse.next;
            slow = slow.next;
        }
        return halfReverse == null && slow == null;
    }


    public ListNode from(int[] nums) {
        ListNode head = new ListNode(Integer.MIN_VALUE, null);
        ListNode dummy = head;
        ListNode sentinelForHead = new ListNode(Integer.MIN_VALUE, head);
        for (int num : nums) {
            head.val = num;
            head.next = new ListNode(Integer.MIN_VALUE, null);
            head = head.next;
            sentinelForHead = sentinelForHead.next;
        }
        sentinelForHead.next = null;
        return dummy;
    }
}
