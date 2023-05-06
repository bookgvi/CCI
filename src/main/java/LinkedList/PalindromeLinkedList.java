package LinkedList;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">...</a>
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode reverseHead = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        ListNode next;
        while (fast != null && fast.next != null) {
            next = slow;
            slow = slow.next;
            next.next = reverseHead;
            reverseHead = next;
            fast = fast.next.next;
        }
        head.next = null;
        while (reverseHead != null && slow != null) {
            if (reverseHead.val != slow.val) {
                slow = slow.next;
            }
            if (slow == null || reverseHead.val != slow.val) {
                return false;
            }
            reverseHead = reverseHead.next;
            slow = slow.next;
        }
        return reverseHead == null && slow == null;
    }

    public boolean isPalindrome1(ListNode head) {
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

    // worse then previous
    public boolean isPalindrome2(ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode reverseMiddle = reverse(middle);
        while (head != null && reverseMiddle != null) {
            if (head.val != reverseMiddle.val) {
                return false;
            }
            head = head.next;
            reverseMiddle = reverseMiddle.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode reverseHead = head;
        ListNode prev = new ListNode(-1, head);
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

    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        int i = 0;
        ListNode slow = head.next;
        if (slow == null) {
            return head;
        }
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode getMiddleAndReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = head;
        ListNode curHead = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            ListNode newHead = slow;
            slow = slow.next;
            curHead = reverse;
            newHead.next = curHead;
            reverse = newHead;
            fast = fast.next.next;
        }
        head.next = null;
        return slow;
    }
}
