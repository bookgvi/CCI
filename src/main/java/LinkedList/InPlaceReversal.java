package LinkedList;

import java.util.Queue;

public class InPlaceReversal {
    public ListNode proceed(ListNode head) {
        ListNode reverse = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = reverse;
            reverse = head;
            head = next;
        }
        return reverse;
    }

    public ListNode proceed(int[] nums) {
        ListNode head = new ListNode().from(nums);
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode from(int[] nums) {
            if (nums == null || nums.length < 1) {
                return null;
            }
            ListNode head = new ListNode(-1, null);
            ListNode sentinel = new ListNode(-1, head);
            ListNode prev = head;
            for (int num : nums) {
                head.val = num;
                head.next = new ListNode(-1, null);
                prev = head;
                head = head.next;
            }
            prev.next = null;
            return sentinel.next;
        }
    }
}
