package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListIITest {

    private void assertSame(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            Assert.assertEquals(l1.val, l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        Assert.assertNull(l1);
        Assert.assertNull(l2);
    }

    @Test
    public void reverseBetween_test1() {
        int[] nums = new int[] {1,2,3,4,5};
        int left = 2, right = 4;
        ListNode ans = ListNode.getInstance().from(new int[] {1,4,3,2,5});
        ListNode head = ListNode.getInstance().from(nums);
        ReverseLinkedListII lt = new ReverseLinkedListII();
        ListNode res = lt.reverseBetween(head, left, right);
        assertSame(ans, res);
    }

    @Test
    public void reverseBetween_test2() {
        int[] nums = new int[] {1,2,3,4,5};
        int left = 1, right = 2;
        ListNode ans = ListNode.getInstance().from(new int[]{2,1,3,4,5});
        ListNode head = ListNode.getInstance().from(nums);
        ReverseLinkedListII lt = new ReverseLinkedListII();
        ListNode res = lt.reverseBetween(head, left, right);
        assertSame(ans, res);
    }

    @Test
    public void reverseBetween_test3() {
        int[] nums = new int[] {1,2,3,4,5};
        int left = 2, right = 3;
        ListNode ans = ListNode.getInstance().from(new int[]{1,3,2,4,5});
        ListNode head = ListNode.getInstance().from(nums);
        ReverseLinkedListII lt = new ReverseLinkedListII();
        ListNode res = lt.reverseBetween(head, left, right);
        assertSame(ans, res);
    }

    @Test
    public void reverseBetween_test4() {
        int[] nums = new int[] {1,2,3,4,5};
        int left = 1, right = 4;
        ListNode ans = ListNode.getInstance().from(new int[]{4,3,2,1,5});
        ListNode head = ListNode.getInstance().from(nums);
        ReverseLinkedListII lt = new ReverseLinkedListII();
        ListNode res = lt.reverseBetween(head, left, right);
        assertSame(ans, res);
    }

    @Test
    public void reverseBetween_test5() {
        int[] nums = new int[] {1};
        int left = 1, right = 1;
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        ListNode head = ListNode.getInstance().from(nums);
        ReverseLinkedListII lt = new ReverseLinkedListII();
        ListNode res = lt.reverseBetween(head, left, right);
        assertSame(ans, res);
    }

    @Test
    public void reverseBetween_test6() {
        int[] nums = new int[] {3, 5};
        int left = 1, right = 1;
        ListNode ans = ListNode.getInstance().from(new int[]{3,5});
        ListNode head = ListNode.getInstance().from(nums);
        ReverseLinkedListII lt = new ReverseLinkedListII();
        ListNode res = lt.reverseBetween(head, left, right);
        assertSame(ans, res);
    }

    @Test
    public void reverseBetween_test7() {
        int[] nums = new int[] {1,2,3,4,5};
        int left = 3, right = 4;
        ListNode ans = ListNode.getInstance().from(new int[]{1,2,4,3,5});
        ListNode head = ListNode.getInstance().from(nums);
        ReverseLinkedListII lt = new ReverseLinkedListII();
        ListNode res = lt.reverseBetween(head, left, right);
        assertSame(ans, res);
    }

    @Test
    public void reverseBetween_test8() {
        int[] nums = new int[] {3, 5};
        int left = 1, right = 2;
        ListNode ans = ListNode.getInstance().from(new int[]{5,3});
        ListNode head = ListNode.getInstance().from(nums);
        ReverseLinkedListII lt = new ReverseLinkedListII();
        ListNode res = lt.reverseBetween(head, left, right);
        assertSame(ans, res);
    }

}