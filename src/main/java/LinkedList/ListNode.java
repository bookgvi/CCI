package LinkedList;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    private ListNode() {
        this(Integer.MIN_VALUE, null);
    }
    private ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getInstance() {
        return new ListNode();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode divide() {
        ListNode head = this;
        ListNode secondHalf = head;
        ListNode fast = head;
        ListNode sentinel = getInstance();
        sentinel.setNext(head);
        while (fast != null && fast.getNext() != null) {
            sentinel = sentinel.getNext();
            secondHalf = secondHalf.getNext();
            fast = fast.getNext().getNext();
        }
        sentinel.setNext(null);
        return secondHalf;
    }

    public ListNode reverse() {
        ListNode sentinel = getInstance();
        ListNode ll = this;
        while (ll != null) {
            ListNode cur = sentinel.getNext();
            ListNode next = ll;
            sentinel.setNext(next);
            ll = ll.getNext();
            sentinel.getNext().setNext(cur);
        }
        return sentinel.getNext();
    }

    public ListNode reverseSubList(ListNode start, ListNode end) {
        ListNode sentinel = getInstance();
        ListNode head = this;
        while (head != null && !Objects.equals(head, start)) {
            head = head.getNext();
        }
        while (head != null && !Objects.equals(head, end)) {
            ListNode curHead = sentinel.getNext();
            ListNode newHead = head;
            sentinel.setNext(newHead);
            head = head.getNext();
            sentinel.getNext().setNext(curHead);
        }
        return sentinel.getNext();
    }

    public ListNode from(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) < 1) {
            throw new RuntimeException("Nothing to convert");
        }
        ListNode head = getInstance();
        ListNode next = getInstance();
        head.setVal(nums[0]);
        if (len > 1) {
            head.setNext(next);
        }
        for (int i = 1; i < len; i += 1) {
            ListNode cur = next;
            cur.setVal(nums[i]);
            if (i < len - 1) {
                next = getInstance();
                cur.setNext(next);
            }
        }
        return head;
    }

    public ListNode from(String s) {
        int len;
        if (s == null || (len = s.length()) < 1) {
            throw new RuntimeException("Nothing to convert");
        }
        ListNode head = getInstance();
        ListNode next = getInstance();
        char[] chars = s.toCharArray();
        head.setVal(chars[0]);
        if (len > 1) {
            head.setNext(next);
        }
        for (int i = 1; i < len; i += 1) {
            ListNode cur = next;
            cur.setVal(chars[i]);
            if (i < len - 1) {
                next = getInstance();
                cur.setNext(next);
            }
        }
        return head;
    }
}
