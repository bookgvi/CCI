package LinkedList;

/**
 * <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/description/">...</a>
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, node);
        while (node.next != null) {
            node.val = node.next.val;
            node = node.next;
            sentinel = sentinel.next;
        }
        sentinel.next = null;
    }
}
