package LinkedList;

/**
 * <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/">...</a>
 * You are given the head of a linked list, and an integer k.
 * <p>
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node
 * from the end (the list is 1-indexed).
 */
public class SwappingNodesLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode kNode = head;
        ListNode dummy1 = head;
        int counter = 1;
        while (head != null && counter < k) {
            head = head.next;
            counter += 1;
        }
        while (head != null && head.next != null) {
            head = head.next;
            kNode = kNode.next;
        }
        counter = 1;
        ListNode dummy2 = dummy1;
        while (dummy1 != null && counter < k) {
            dummy1 = dummy1.next;
            counter += 1;
        }
        if (dummy1 != null) {
            int tmp = dummy1.val;
            dummy1.val = kNode.val;
            kNode.val = tmp;
        }
        return dummy2;
    }
}
