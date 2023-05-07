package LinkedList;

import org.junit.Test;

public class RemoveLinkedListElementsTest extends AbstractAssertForListNode {

    @Test
    public void removeElements_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1, 2, 6, 3, 4, 5, 6});
        int val = 6;
        ListNode ans = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5});
        ListNode res = new RemoveLinkedListElements().removeElements(head, val);
        assertEquals(ans, res);
    }

    @Test
    public void removeElements_test2() {
        ListNode head = null;
        int val = 1;
        ListNode ans = null;
        ListNode res = new RemoveLinkedListElements().removeElements(head, val);
        assertEquals(ans, res);
    }

    @Test
    public void removeElements_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{7,7,7,7});
        int val = 7;
        ListNode ans = null;
        ListNode res = new RemoveLinkedListElements().removeElements(head, val);
        assertEquals(ans, res);
    }

    @Test
    public void removeElements_test4() {
        ListNode head = ListNode.getInstance().from(new int[]{7,7,7,7});
        int val = 1;
        ListNode ans = ListNode.getInstance().from(new int[]{7,7,7,7});
        ListNode res = new RemoveLinkedListElements().removeElements(head, val);
        assertEquals(ans, res);
    }
}