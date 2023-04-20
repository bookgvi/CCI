package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class SwappingNodesLinkedListTest {

    private void assertEquals(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            Assert.assertEquals(l1.val, l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        Assert.assertNull(l1);
        Assert.assertNull(l2);
    }
    @Test
    public void swapNodes_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5});
        int k = 2;
        ListNode ans = ListNode.getInstance().from(new int[]{1,4,3,2,5});
        SwappingNodesLinkedList s = new SwappingNodesLinkedList();
        ListNode res = s.swapNodes(head, k);
        assertEquals(ans, res);
    }
}