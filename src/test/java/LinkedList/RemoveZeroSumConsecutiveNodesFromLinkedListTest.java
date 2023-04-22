package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class RemoveZeroSumConsecutiveNodesFromLinkedListTest {

    private void assertEquals(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            Assert.assertEquals(l1.val, l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        Assert.assertNull(l1);
        Assert.assertNull(l2);
    }

    @Test
    public void removeZeroSumSublists_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,-3,3,1});
        ListNode ans = ListNode.getInstance().from(new int[]{3,1});
        RemoveZeroSumConsecutiveNodesFromLinkedList r = new RemoveZeroSumConsecutiveNodesFromLinkedList();
        ListNode res = r.removeZeroSumSublists(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeZeroSumSublists_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,-3,4});
        ListNode ans = ListNode.getInstance().from(new int[]{1,2,4});
        RemoveZeroSumConsecutiveNodesFromLinkedList r = new RemoveZeroSumConsecutiveNodesFromLinkedList();
        ListNode res = r.removeZeroSumSublists(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeZeroSumSublists_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,-3,-2});
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        RemoveZeroSumConsecutiveNodesFromLinkedList r = new RemoveZeroSumConsecutiveNodesFromLinkedList();
        ListNode res = r.removeZeroSumSublists(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeZeroSumSublists_test4() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,-3});
        ListNode ans = null;
        RemoveZeroSumConsecutiveNodesFromLinkedList r = new RemoveZeroSumConsecutiveNodesFromLinkedList();
        ListNode res = r.removeZeroSumSublists(head);
        assertEquals(ans, res);
    }
}