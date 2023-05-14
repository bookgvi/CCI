package TMP;

import LinkedList.AbstractAssertForListNode;
import LinkedList.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortLInkedListTest extends AbstractAssertForListNode {

    @Test
    public void sort_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1,4,3,2,5,7,6,8,0,7,9,99});
        ListNode sort = ListNode.getInstance().from(new int[]{0,1,2,3,4,5,6,7,7,8,9,99});
        MergeSortLInkedList m = new MergeSortLInkedList();
        ListNode res = m.sort(head);
        assertEquals(sort, res);
    }

    @Test
    public void sort_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1});
        ListNode sort = ListNode.getInstance().from(new int[]{1});
        MergeSortLInkedList m = new MergeSortLInkedList();
        ListNode res = m.sort(head);
        assertEquals(sort, res);
    }

    @Test
    public void sort_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{1,-1});
        ListNode sort = ListNode.getInstance().from(new int[]{-1,1});
        MergeSortLInkedList m = new MergeSortLInkedList();
        ListNode res = m.sort(head);
        assertEquals(sort, res);
    }
}