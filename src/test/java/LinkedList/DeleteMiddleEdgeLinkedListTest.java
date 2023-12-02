package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteMiddleEdgeLinkedListTest {

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
    public void deleteMiddle_test1() {
        ListNode nums = ListNode.getInstance().from(new int[]{1,2,3,4,5,6});
        ListNode ans = ListNode.getInstance().from(new int[]{1,2,3,5,6});
        DeleteMiddleNodeLinkedList d = new DeleteMiddleNodeLinkedList();
        ListNode res = d.deleteMiddle(nums);
        assertEquals(ans, res);
    }

    @Test
    public void deleteMiddle_test2() {
        ListNode nums = ListNode.getInstance().from(new int[]{1,2,3,4,5});
        ListNode ans = ListNode.getInstance().from(new int[]{1,2,4,5});
        DeleteMiddleNodeLinkedList d = new DeleteMiddleNodeLinkedList();
        ListNode res = d.deleteMiddle(nums);
        assertEquals(ans, res);
    }

    @Test
    public void deleteMiddle_test3() {
        ListNode nums = ListNode.getInstance().from(new int[]{1,2,3,4,5,6,7,8});
        ListNode ans = ListNode.getInstance().from(new int[]{1,2,3,4,6,7,8});
        DeleteMiddleNodeLinkedList d = new DeleteMiddleNodeLinkedList();
        ListNode res = d.deleteMiddle(nums);
        assertEquals(ans, res);
    }

    @Test
    public void deleteMiddle_test4() {
        ListNode nums = ListNode.getInstance().from(new int[]{1,2,3,4,5,6,7,8,9});
        ListNode ans = ListNode.getInstance().from(new int[]{1,2,3,4,6,7,8,9});
        DeleteMiddleNodeLinkedList d = new DeleteMiddleNodeLinkedList();
        ListNode res = d.deleteMiddle(nums);
        assertEquals(ans, res);
    }

    @Test
    public void deleteMiddle_test5() {
        ListNode nums = ListNode.getInstance().from(new int[]{1});
        ListNode ans = null;
        DeleteMiddleNodeLinkedList d = new DeleteMiddleNodeLinkedList();
        ListNode res = d.deleteMiddle(nums);
        assertEquals(ans, res);
    }

    @Test
    public void deleteMiddle_test6() {
        ListNode nums = ListNode.getInstance().from(new int[]{1, 2});
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        DeleteMiddleNodeLinkedList d = new DeleteMiddleNodeLinkedList();
        ListNode res = d.deleteMiddle(nums);
        assertEquals(ans, res);
    }
}