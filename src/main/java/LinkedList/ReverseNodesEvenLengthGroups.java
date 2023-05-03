package LinkedList;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-even-length-groups/">...</a>
 * You are given the head of a linked list.
 * <p>
 * The nodes in the linked list are sequentially assigned to non-empty groups whose lengths form the sequence
 * of the natural numbers (1, 2, 3, 4, ...). The length of a group is the number of nodes assigned to it.
 * In other words, the 1st node is assigned to the first group.
 * The 2nd and the 3rd nodes are assigned to the second group.
 * The 4th, 5th, and 6th nodes are assigned to the third group, and so on.
 * Note that the length of the last group may be less than or equal to 1 + the length of the second to last group.
 * <p>
 * Reverse the nodes in each group with an even length, and return the head of the modified linked list.
 */
public class ReverseNodesEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        Pair[] groups = divideIntoGroups(head);
        ListNode sentinelForResult = new ListNode(-1);
        ListNode result = sentinelForResult;
        for (int i = 0, len = groups.length; i < len && groups[i] != null; i += 1) {
            ListNode l = groups[i].getHead();
            if ((groups[i].getLen() & 1) == 0) {
                l = reverse(l);
            }
            sentinelForResult.next = l;
            while (sentinelForResult.next != null) {
                sentinelForResult = sentinelForResult.next;
            }
        }
        return result.next;
    }


    /**
     * @param head
     * @return
     */
    public Pair[] divideIntoGroups(ListNode head) {
        int group = 1, i = 0;
        Pair[] groups = new Pair[((int) 1e5) >> 1];
        while (head != null) {
            int counter = group;
            ListNode prev = new ListNode(-1, head);
            groups[i++] = new Pair(-1, head);
            int len = 0;
            while (head != null && counter > 0) {
                head = head.next;
                prev = prev.next;
                counter -= 1;
                len += 1;
            }
            prev.next = null;
            group += 1;
            groups[i - 1].setLen(len);
        }
        return groups;
    }

    private ListNode reverse(ListNode head) {
        ListNode reverseHead = head;
        ListNode prev = new ListNode(-1, head);
        head = head.next;
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

    public ListNode reverse(ListNode head, int count) {
        ListNode reverseHead = head;
        ListNode prev = new ListNode(-1, reverseHead);
        ListNode next = new ListNode(-1, shift(head, count));
        int i = 1;
        while (head != null && i <= count) {
            ListNode curHead = reverseHead;
            reverseHead = head;
            head = head.next;
            reverseHead.next = curHead;
            prev = prev.next;
            i += 1;
        }
        prev.next = null;
        ListNode sentinelForReverse = reverseHead;
        reverseHead = shift(sentinelForReverse, count - 1);
        if (reverseHead != null) {
            reverseHead.next = next.next;
        }
        return sentinelForReverse;
    }

    public ListNode reverse(ListNode head, int start, int end) {
        ListNode headToReverse = shift(head, start - 1);
        ListNode last = shift(head, end - start);
        ListNode reverseHead = headToReverse;
        ListNode prev = new ListNode(-1, reverseHead);
        int i = 1;
        while (headToReverse != null && i <= end - start + 1) {
            ListNode curHead = reverseHead;
            reverseHead = headToReverse;
            headToReverse = headToReverse.next;
            reverseHead.next = curHead;
            prev = prev.next;
        }
        prev.next = null;
        ListNode sentinelForReverse = reverseHead;
        reverseHead = shift(reverseHead, end - start);
        if (reverseHead != null) {
            reverseHead.next = last;
        }
        if (headToReverse != null) {
            headToReverse.next = sentinelForReverse;
        }
        return head;
    }

    private ListNode shift(ListNode head, int count) {
        int i = 1;
        while (head != null && i <= count) {
            head = head.next;
            i += 1;
        }
        return head;
    }

    private static class Pair {
        private int len;
        private ListNode head;

        public Pair(int len, ListNode head) {
            this.len = len;
            this.head = head;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }

        public ListNode getHead() {
            return head;
        }

        public void setHead(ListNode head) {
            this.head = head;
        }
    }
}
