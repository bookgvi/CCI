package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ReverseNodesInkGroupTest {
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
    public void reverseKGroup_test1() {
        int k = 2;
        ListNode l1 = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5});
        ListNode ans = ListNode.getInstance().from(new int[]{2,1,4,3,5});
        ReverseNodesInkGroup r = new ReverseNodesInkGroup();
       ListNode res = r.reverseKGroup(l1, k);
        assertEquals(ans, res);
    }

    @Test
    public void reverseKGroup_test2() {
        int k = 3;
        ListNode l1 = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5});
        ListNode ans = ListNode.getInstance().from(new int[]{3,2,1,4,5});
        ReverseNodesInkGroup r = new ReverseNodesInkGroup();
       ListNode res = r.reverseKGroup(l1, k);
        assertEquals(ans, res);
    }

    @Test
    public void reverseKGroup_test3() {
        int k = 1;
        ListNode l1 = ListNode.getInstance().from(new int[]{1});
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        ReverseNodesInkGroup r = new ReverseNodesInkGroup();
       ListNode res = r.reverseKGroup(l1, k);
        assertEquals(ans, res);
    }

    @Test
    public void reverseKGroup_test4() {
        int k = 0;
        ListNode l1 = ListNode.getInstance().from(new int[]{1});
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        ReverseNodesInkGroup r = new ReverseNodesInkGroup();
       ListNode res = r.reverseKGroup(l1, k);
        assertEquals(ans, res);
    }

    @Test
    public void reverseKGroup_test5() {
        int k = 9;
        ListNode l1 = ListNode.getInstance().from(new int[]{1,2,3,4,5,6,7,8,9});
        ListNode ans = ListNode.getInstance().from(new int[]{9,8,7,6,5,4,3,2,1});
        ReverseNodesInkGroup r = new ReverseNodesInkGroup();
       ListNode res = r.reverseKGroup(l1, k);
        assertEquals(ans, res);
    }

    @Test
    public void reverse_test() {
        ListNode l1 = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6});
        ListNode ans = ListNode.getInstance().from(new int[]{6, 5, 4, 3, 2, 1});
        ReverseNodesInkGroup r = new ReverseNodesInkGroup();
        Map<ListNode, ListNode> reverseHeadAndTailMap = r.reverse(l1);
        assertEquals(ans, reverseHeadAndTailMap.keySet().iterator().next());
    }

    @Test
    public void testEmptyList() {
        ListNode head = null;
        Map<ListNode, ListNode> result = new ReverseNodesInkGroup().reverse(head);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleListNode() {
        ListNode head = new ListNode(1);
        Map<ListNode, ListNode> result = new ReverseNodesInkGroup().reverse(head);
        assertEquals(head, result.keySet().iterator().next());
        assertEquals(head, result.values().iterator().next());
    }

}