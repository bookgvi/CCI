package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedListTest {
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
    public void solution_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7});
        ListNode ans = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6, 7});
        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
        assertEquals(ans, r.solution(head));
    }

    @Test
    public void solution_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode ans = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6, 7});
        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
        assertEquals(ans, r.solution(head));
    }

    @Test
    public void solution_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{1});
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
        assertEquals(ans, r.solution(head));
    }

    @Test
    public void solution_test4() {
        ListNode head = ListNode.getInstance().from(new int[]{1,1,1,1,1});
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
        assertEquals(ans, r.solution(head));
    }

    @Test
    public void solution_test5() {
        ListNode head = null; //ListNode.getInstance().from(new int[]{1,1,1,1,1});
        ListNode ans = null; //ListNode.getInstance().from(new int[]{1});
        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
        assertEquals(ans, r.solution(head));
    }
}