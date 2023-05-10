package TMP;

import LinkedList.AbstractAssertForListNode;
import LinkedList.ListNode;
import org.junit.Test;

public class ReverseLinkedListTest extends AbstractAssertForListNode {

    @Test
    public void reverse_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5});
        ListNode firstHalfReverse = ListNode.getInstance().from(new int[]{2,1});
        ListNode secondHalf = ListNode.getInstance().from(new int[]{3,4,5});
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode[] res = r.reverseHalf(head);
        assertEquals(firstHalfReverse, res[0]);
        assertEquals(secondHalf, res[1]);
    }

    @Test
    public void reverse_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5, 6});
        ListNode firstHalfReverse = ListNode.getInstance().from(new int[]{3,2,1});
        ListNode secondHalf = ListNode.getInstance().from(new int[]{4,5,6});
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode[] res = r.reverseHalf(head);
        assertEquals(firstHalfReverse, res[0]);
        assertEquals(secondHalf, res[1]);
    }

    @Test
    public void reverse_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2});
        ListNode firstHalfReverse = ListNode.getInstance().from(new int[]{1});
        ListNode secondHalf = ListNode.getInstance().from(new int[]{2});
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode[] res = r.reverseHalf(head);
        assertEquals(firstHalfReverse, res[0]);
        assertEquals(secondHalf, res[1]);
    }

    @Test
    public void reverse_test4() {
        ListNode head = ListNode.getInstance().from(new int[]{1});
        ListNode firstHalfReverse = ListNode.getInstance().from(new int[]{1});
        ListNode secondHalf = ListNode.getInstance().from(new int[]{1});
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode[] res = r.reverseHalf(head);
        assertEquals(firstHalfReverse, res[0]);
        assertEquals(secondHalf, res[1]);
    }

    @Test
    public void reverse_test5() {
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode[] res = r.reverseHalf(null);
        assertEquals(null, res[0]);
        assertEquals(null, res[1]);
    }
}