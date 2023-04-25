package LinkedList;

/**
 * <a href="https://leetcode.com/problems/split-linked-list-in-parts/">...</a>
 * <p>
 * Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
 * <p>
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
 * This may lead to some parts being null.
 * <p>
 * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have
 * a size greater than or equal to parts occurring later.
 * <p>
 * Return an array of the k parts.
 */
public class SplitLinkedListParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode sentinelHead = head;
        int len = 0;
        while (head != null) {
            head = head.next;
            len += 1;
        }

        int count = len / k, sentinelCount = count, i = 0;
        boolean isKGTCount = false;
        int extraDigit = len % k;
        if (count == 0) {
            count = 1;
            extraDigit -= 1;
            sentinelCount = 1;
            isKGTCount = true;
        }
        ListNode[] res = new ListNode[k];
        head = sentinelHead;
        res[i++] = head;
        ListNode prev = new ListNode(Integer.MIN_VALUE, head);
        while (head != null) {
            if (count <= 0) {
                if (extraDigit > 0) {
                    if (!isKGTCount) {
                        head = head.next;
                        prev = prev.next;
                    }
                    extraDigit -= 1;
                }
                prev.next = null;
                res[i++] = head;
                prev = new ListNode(Integer.MIN_VALUE, head);
                count = sentinelCount;
            }
            if (head != null) {
                head = head.next;
                prev = prev.next;
                count -= 1;
            }
        }
        return res;
    }
}
