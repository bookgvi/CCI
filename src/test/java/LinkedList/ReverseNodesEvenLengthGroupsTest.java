package LinkedList;

import org.junit.Test;

public class ReverseNodesEvenLengthGroupsTest extends AbstractAssertForListNode {

    @Test
    public void reverseEvenLengthGroups_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{5, 2, 6, 3, 9, 1, 7, 3, 8, 4});
        ListNode ans = ListNode.getInstance().from(new int[]{5,6,2,3,9,1,4,8,3,7});
        ReverseNodesEvenLengthGroups r = new ReverseNodesEvenLengthGroups();
        ListNode res = r.reverseEvenLengthGroups(head);
        assertEquals(ans, res);
    }


    @Test
    public void reverseEvenLengthGroups_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1,1,0,6,5});
        ListNode ans = ListNode.getInstance().from(new int[]{1,0,1,5,6});
        ReverseNodesEvenLengthGroups r = new ReverseNodesEvenLengthGroups();
        ListNode res = r.reverseEvenLengthGroups(head);
        assertEquals(ans, res);
    }
}