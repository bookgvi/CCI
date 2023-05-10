package LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class OddEvenLinkedListTest extends AbstractAssertForListNode {

    @Test
    public void oddEvenList_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5});
        ListNode ans = ListNode.getInstance().from(new int[]{1,3,5,2,4});
        OddEvenLinkedList o = new OddEvenLinkedList();
        ListNode res = o.oddEvenList(head);
        assertEquals(ans, res);
    }

    @Test
    public void oddEvenList_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{2,1,3,5,6,4,7});
        ListNode ans = ListNode.getInstance().from(new int[]{2,3,6,7,1,5,4});
        OddEvenLinkedList o = new OddEvenLinkedList();
        ListNode res = o.oddEvenList(head);
        assertEquals(ans, res);
    }

    @Test
    public void oddEvenList_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{2,1});
        ListNode ans = ListNode.getInstance().from(new int[]{2,1});
        OddEvenLinkedList o = new OddEvenLinkedList();
        ListNode res = o.oddEvenList(head);
        assertEquals(ans, res);
    }

    @Test
    public void oddEvenList_test4() {
        ListNode head = ListNode.getInstance().from(new int[]{2});
        ListNode ans = ListNode.getInstance().from(new int[]{2});
        OddEvenLinkedList o = new OddEvenLinkedList();
        ListNode res = o.oddEvenList(head);
        assertEquals(ans, res);
    }

    @Test
    public void oddEvenList_test5() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5,6,7,8});
        ListNode ans = ListNode.getInstance().from(new int[]{1,3,5,7,2,4,6,8});
        OddEvenLinkedList o = new OddEvenLinkedList();
        ListNode res = o.oddEvenList(head);
        assertEquals(ans, res);
    }
}