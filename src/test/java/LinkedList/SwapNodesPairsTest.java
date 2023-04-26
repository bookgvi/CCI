package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class SwapNodesPairsTest {

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
    public void swapPairs_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6});
        ListNode ans = ListNode.getInstance().from(new int[]{2, 1, 4, 3, 6, 5});
        SwapNodesPairs s = new SwapNodesPairs();
        ListNode res = s.swapPairs(head);
        assertEquals(ans, res);
    }

    @Test
    public void swapPairs_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1});
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        SwapNodesPairs s = new SwapNodesPairs();
        ListNode res = s.swapPairs(head);
        assertEquals(ans, res);
    }

    @Test
    public void swapPairs_test3() {
        ListNode head = null;//ListNode.getInstance().from(new int[]{1});
        ListNode ans = null;//ListNode.getInstance().from(new int[]{1});
        SwapNodesPairs s = new SwapNodesPairs();
        ListNode res = s.swapPairs(head);
        assertEquals(ans, res);
    }
}