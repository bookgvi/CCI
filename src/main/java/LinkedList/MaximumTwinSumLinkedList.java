package LinkedList;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">...</a>
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of
 * the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * <p>
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2.
 * These are the only nodes with twins for n = 4. The twin sum is defined as the sum of a node and its twin.
 * <p>
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 */
public class MaximumTwinSumLinkedList {
    public int pairSum(ListNode head) {
        ListNode sentinelForReverse = head;
        ListNode next = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            ListNode reverseHead = next;
            next = next.next;
            fast = fast.next.next;
            reverseHead.next = sentinelForReverse;
            sentinelForReverse = reverseHead;
        }
        head.next = null;
        int res = -1;
        while (next != null) {
            res = Math.max(res, next.val + sentinelForReverse.val);
            next = next.next;
            sentinelForReverse = sentinelForReverse.next;
        }
        return res;
    }

    private ListNode splitAndReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinelForReverse = head;
        ListNode next = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            ListNode reverseHead = next;
            next = next.next;
            fast = fast.next.next;
            reverseHead.next = sentinelForReverse;
            sentinelForReverse = reverseHead;
        }
        head.next = null;
        return sentinelForReverse;
    }

    public int pairSum1(ListNode head) {
        ListNode reverseHead = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        int res = Integer.MIN_VALUE;
        while (fast != null) {
            ListNode curHead = reverseHead;
            reverseHead = slow;
            slow = slow.next;
            fast = fast.next.next;
            reverseHead.next = curHead;
        }
        head.next = null;
        while (reverseHead != null && slow != null) {
            res = Math.max(res, reverseHead.val + slow.val);
            reverseHead = reverseHead.next;
            slow = slow.next;
        }
        return res;
    }

    private static class FirstSolution {
        public int pairSum(ListNode head) {
            int[] nums = listToArr(head);
            int len = nums.length, p1 = 0, p2 = len - 1, res = Integer.MIN_VALUE;
            int[] twinSums = new int[len >> 1];
            while (p1 < p2) {
                twinSums[p1] = nums[p2] + nums[p1];
                res = Math.max(res, twinSums[p1]);
                p1 += 1;
                p2 -= 1;
            }
            return res;
        }

        private int[] listToArr(ListNode listNode) {
            int[] nums = new int[(int) 1e5 + 1];
            int len = 0;
            while (listNode != null) {
                nums[len++] = listNode.val;
                listNode = listNode.next;
            }
            return Arrays.copyOf(nums, len);
        }
    }
}
