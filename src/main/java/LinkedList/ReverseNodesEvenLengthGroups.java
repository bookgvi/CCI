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
     *
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
