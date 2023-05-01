package LinkedList;

import org.junit.Test;

public class MergeInBetweenLinkedListsTest extends AbstractAssertForListNode {

    @Test
    public void mergeInBetween_test1() {
        ListNode list1 = ListNode.getInstance().from(new int[]{0,1,2,3,4,5});
        ListNode list2 = ListNode.getInstance().from(new int[]{1000000,1000001,1000002});
        int a = 3, b = 4;
        ListNode ans = ListNode.getInstance().from(new int[]{0,1,2,1000000,1000001,1000002,5});
        MergeInBetweenLinkedLists m = new MergeInBetweenLinkedLists();
        ListNode res = m.mergeInBetween(list1, a, b, list2);
        assertEquals(ans, res);
    }

    @Test
    public void mergeInBetween_test2() {
        ListNode list1 = ListNode.getInstance().from(new int[]{0,1,2,3,4,5,6});
        ListNode list2 = ListNode.getInstance().from(new int[]{1000000,1000001});
        int a = 2, b = 5;
        ListNode ans = ListNode.getInstance().from(new int[]{0,1,1000000,1000001,6});
        MergeInBetweenLinkedLists m = new MergeInBetweenLinkedLists();
        ListNode res = m.mergeInBetween(list1, a, b, list2);
        assertEquals(ans, res);
    }

    @Test
    public void mergeInBetween_test3() {
        ListNode list1 = ListNode.getInstance().from(new int[]{0,1,2,3,4,5});
        ListNode list2 = ListNode.getInstance().from(new int[]{1000000,1000001,1000002});
        int a = 4, b = 4;
        ListNode ans = ListNode.getInstance().from(new int[]{0,1,2,3,1000000,1000001,1000002,5});
        MergeInBetweenLinkedLists m = new MergeInBetweenLinkedLists();
        ListNode res = m.mergeInBetween(list1, a, b, list2);
        assertEquals(ans, res);
    }
}