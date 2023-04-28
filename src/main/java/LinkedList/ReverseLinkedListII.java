package LinkedList;

import java.util.Arrays;
import java.util.Iterator;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">...</a>
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode sentinelForReverse = new ListNode(Integer.MIN_VALUE, null);
        ListNode dummyForReverse = sentinelForReverse;
        ListNode sentinelForHead = new ListNode(Integer.MIN_VALUE, null);
        sentinelForHead.next = head;
        ListNode dummyForHead = sentinelForHead;
        int pos = 1;
        while (head.next != null) {
            ListNode prev = sentinelForHead;
            while (left <= pos && pos <= right) {
                ListNode curReverse = sentinelForReverse.next;
                sentinelForReverse.next = head;
                head = head.next;
                sentinelForReverse.next.next = curReverse;
                pos += 1;
            }
            if (sentinelForReverse.next != null) {
                while (dummyForReverse.next != null) {
                    dummyForReverse = dummyForReverse.next;
                }
                dummyForReverse.next = head;
                prev.next = sentinelForReverse.next;
                break;
            } else {
                pos += 1;
                head = head.next;
                sentinelForHead = sentinelForHead.next;
            }
        }
        return dummyForHead.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode part1 = null;
        ListNode part2;
        ListNode part3;
        if (left == 1) {
            part3 = getRest(head, right);
            part2 = reverse(head);
        } else {
            part2 = getRest(head, left - 1);
            part1 = head;
            part3 = getRest(part2, right - left + 1);
            part2 = reverse(part2);
        }
        return mergeLists(part1, part2, part3);
    }

    private ListNode mergeLists(ListNode... parts) {
        Iterator<ListNode> iterator = Arrays.stream(parts).iterator();
        ListNode dummy = null;
        while (iterator.hasNext() && dummy == null) {
            dummy = iterator.next();
        }
        ListNode mergeRes = dummy;
        while (iterator.hasNext()) {
            ListNode head = iterator.next();
            if (head == null) {
                continue;
            }
            while (dummy.next != null) {
                dummy = dummy.next;
            }
            dummy.next = head;
        }
        return mergeRes;
    }

    private ListNode getRest(ListNode head, int bound) {
        ListNode dummy = new ListNode(-1, head);
        ListNode part = null;
        int p2 = 1;
        while (dummy != null && p2 <= bound) {
            dummy = dummy.next;
            p2 += 1;
        }
        if (dummy != null) {
            part = dummy.next;
            dummy.next = null;
        }
        return part;
    }

    private ListNode reverse(ListNode head) {
        ListNode reverse = head;
        ListNode prev = new ListNode(-1, reverse);
        while (head != null) {
            ListNode curHead = reverse;
            reverse = head;
            head = head.next;
            prev = prev.next;
            reverse.next = curHead;
        }
        prev.next = null;
        return reverse;
    }
}
