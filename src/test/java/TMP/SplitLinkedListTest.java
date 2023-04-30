package TMP;

import LinkedList.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class SplitLinkedListTest {

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
    public void proceed_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5,6,7,8,9,0});
        int pos = 3;
        ListNode l1 = ListNode.getInstance().from(new int[]{1,2,3});
        ListNode l2 = ListNode.getInstance().from(new int[]{4,5,6,7,8,9,0});
        SplitLinkedList s = new SplitLinkedList();
        ListNode res = s.proceed(head, pos);
        assertEquals(l1, head);
        assertEquals(l2, res);
    }

    @Test
    public void proceed_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5,6,7,8,9,0});
        int pos = 1;
        ListNode l1 = ListNode.getInstance().from(new int[]{1});
        ListNode l2 = ListNode.getInstance().from(new int[]{2,3,4,5,6,7,8,9,0});
        SplitLinkedList s = new SplitLinkedList();
        ListNode res = s.proceed(head, pos);
        assertEquals(l1, head);
        assertEquals(l2, res);
    }

    @Test
    public void proceed_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5,6,7,8,9,0});
        int pos = 9;
        ListNode l1 = ListNode.getInstance().from(new int[]{1,2,3,4,5,6,7,8,9});
        ListNode l2 = ListNode.getInstance().from(new int[]{0});
        SplitLinkedList s = new SplitLinkedList();
        ListNode res = s.proceed(head, pos);
        assertEquals(l1, head);
        assertEquals(l2, res);
    }
}