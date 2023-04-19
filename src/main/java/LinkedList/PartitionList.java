package LinkedList;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/partition-list/description/">...</a>
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLessThenX = new ListNode(Integer.MIN_VALUE, null);
        ListNode lesThenXsentinel = dummyLessThenX;
        ListNode dummyMoreThenX = new ListNode(Integer.MIN_VALUE, null);
        ListNode moreThenXsentinel = dummyMoreThenX;
        while (head != null) {
            if (head.val < x) {
                dummyLessThenX.next = head;
                dummyLessThenX = dummyLessThenX.next;
            } else {
                dummyMoreThenX.next = head;
                dummyMoreThenX = dummyMoreThenX.next;
            }
            head = head.next;
        }
        dummyMoreThenX.next = null;
        moreThenXsentinel = moreThenXsentinel.next; // первый элемент в списке больший или равный X

        dummyLessThenX.next = moreThenXsentinel;
        dummyLessThenX = dummyLessThenX.next; // даже при сортировке этот указатель будет на последнем элементе в списке
        if (moreThenXsentinel != null) {
            moreThenXsentinel = moreThenXsentinel.next;
        }
        if (dummyLessThenX != null) {
            dummyLessThenX.next = moreThenXsentinel;
        }
        return lesThenXsentinel.next;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = split(head);
        ListNode sortHead = sort(head);
        ListNode sortMid = sort(mid);
        return merge(sortHead, sortMid);
    }

    private ListNode split(ListNode head) {
        ListNode dummy = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            dummy = dummy.next;
        }
        dummy.next = null;
        return slow;
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode merge = new ListNode(Integer.MIN_VALUE, null);
        ListNode sentinelForMerge = merge;
        while (l != null && r != null) {
            if (l.val < r.val) {
                merge.next = l;
                l = l.next;
            } else {
                merge.next = r;
                r = r.next;
            }
            merge = merge.next;
        }
        if (l != null) {
            merge.next = l;
        }
        if (r != null) {
            merge.next = r;
        }
        return sentinelForMerge.next;
    }

    private int[] listToArr(ListNode head) {
        int[] arr = new int[200];
        int i = 0;
        while (head != null) {
            arr[i++] = head.val;
            head = head.next;
        }
        return Arrays.copyOf(arr, i);
    }

    private ListNode arrToList(int[] nums) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, null);
        ListNode dummy = new ListNode(Integer.MIN_VALUE, null);
        ListNode head = new ListNode(Integer.MIN_VALUE, null);
        sentinel.next = dummy;
        dummy.next = head;
        for (int num : nums) {
            head.val = num;
            head.next = new ListNode(Integer.MIN_VALUE, null);
            head = head.next;
            dummy = dummy.next;
        }
        dummy.next = null;
        return sentinel.next.next;
    }
}
