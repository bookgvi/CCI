package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">...</a>
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not
 * a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        List<Map<ListNode, ListNode>> parts = new ArrayList<>();
        ListNode dummyForSentinelForHead = head;

        int i = 1;
        while (head != null) {
            ListNode reverseHead = head;
            ListNode sentinelForReverse = reverseHead;
            ListNode lastNode = head;

            ListNode fHead = new ListNode(head.val, head.next);
            ListNode sentinelForFHead = fHead;

            Map<ListNode, ListNode> headAndTailNodes = new HashMap<>();
            while (head != null && k >= i) {
                i += 1;
                ListNode curHead = reverseHead;
                dummyForSentinelForHead = dummyForSentinelForHead.next;
                reverseHead = head;
                head = head.next;
                reverseHead.next = curHead;

                if (head!= null) {
                    fHead.next = new ListNode(head.val, head.next);
                    fHead = fHead.next;
                }
            }
            sentinelForReverse.next = null;
            fHead.next = null;
            if (k < i) {
                headAndTailNodes.put(reverseHead, lastNode);
            } else {
                headAndTailNodes.put(sentinelForFHead, fHead);
            }
            parts.add(headAndTailNodes);
            i = 1;
        }

        int len = parts.size();
        Map<ListNode, ListNode> firstPart = parts.get(0);
        ListNode res = firstPart.keySet().iterator().next();
        ListNode last = firstPart.values().iterator().next();
        for (int j = 1; j < len; j += 1) {
            last.next = parts.get(j).keySet().iterator().next();
            last = parts.get(j).values().iterator().next();
        }
        return res;
    }

    public Map<ListNode, ListNode> reverse(ListNode head) {
        Map<ListNode, ListNode> headAndTailNodes = new HashMap<>();
        ListNode reverseHead = head;
        ListNode lastNode = head;
        ListNode sentinel = reverseHead;
        while (head != null) {
            ListNode curHead = reverseHead;
            reverseHead = head;
            head = head.next;
            reverseHead.next = curHead;
        }
        if (sentinel != null) {
            sentinel.next = null;
        }
        headAndTailNodes.put(reverseHead, lastNode);
        return headAndTailNodes;
    }
}
