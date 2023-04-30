package LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedListIITest extends AbstractAssertForListNode {

    @Test
    public void deleteDuplicates_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1,1,2,2,3,3,4,5,6,6});
        ListNode ans = ListNode.getInstance().from(new int[]{4,5});
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode res = r.deleteDuplicates(head);
        assertEquals(ans, res);
    }

    @Test
    public void deleteDuplicates_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,2,3,3,4,5,5,6});
        ListNode ans = ListNode.getInstance().from(new int[]{1,4,6});
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode res = r.deleteDuplicates(head);
        assertEquals(ans, res);
    }

    @Test
    public void deleteDuplicates_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,2,3,3});
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode res = r.deleteDuplicates(head);
        assertEquals(ans, res);
    }

    @Test
    public void deleteDuplicates_test4() {
        ListNode head = ListNode.getInstance().from(new int[]{1,1,2,3,3});
        ListNode ans = ListNode.getInstance().from(new int[]{2});
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode res = r.deleteDuplicates(head);
        assertEquals(ans, res);
    }

    @Test
    public void deleteDuplicates_test5() {
        ListNode head = ListNode.getInstance().from(new int[]{1,1,2,2,3});
        ListNode ans = ListNode.getInstance().from(new int[]{3});
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode res = r.deleteDuplicates(head);
        assertEquals(ans, res);
    }

    @Test
    public void deleteDuplicates_test6() {
        ListNode head = ListNode.getInstance().from(new int[]{1,1,2,2,3,3});
        ListNode ans = null;
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode res = r.deleteDuplicates(head);
        assertEquals(ans, res);
    }


    @Test
    public void deleteDuplicates_test7() {
        ListNode head = ListNode.getInstance().from(new int[]{1});
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode res = r.deleteDuplicates(head);
        assertEquals(ans, res);
    }

}