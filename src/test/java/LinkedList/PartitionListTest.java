package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class PartitionListTest {
    private void assertListNodeEquals(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            Assert.assertEquals(l1.val, l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        Assert.assertNull(l1);
        Assert.assertNull(l2);
    }
    @Test
    public void partition_test1() {
        int[] arr = new int[]{1,4,3,2,5,2};
        int x = 3;
        int[] ans = new int[]{1,2,2,4,3,5};
        ListNode head = ListNode.getInstance().from(arr);
        ListNode ansHead = ListNode.getInstance().from(ans);
        PartitionList p = new PartitionList();
        assertListNodeEquals(ansHead, p.partition(head, x));
    }

    @Test
    public void partition_test2() {
        int[] arr = new int[]{2,1};
        int x = 2;
        int[] ans = new int[]{1,2};
        ListNode head = ListNode.getInstance().from(arr);
        ListNode ansHead = ListNode.getInstance().from(ans);
        PartitionList p = new PartitionList();
        assertListNodeEquals(ansHead, p.partition(head, x));
    }

    @Test
    public void partition_test3() {
        int[] arr = new int[]{};
        int x = 0;
        int[] ans = new int[]{};
        ListNode head = ListNode.getInstance().from(arr);
        ListNode ansHead = ListNode.getInstance().from(ans);
        PartitionList p = new PartitionList();
        assertListNodeEquals(ansHead, p.partition(head, x));
    }

    @Test
    public void partition_test4() {
        int[] arr = new int[]{4,3,2,5,2};
        int x = 3;
        int[] ans = new int[]{2,2,4,3,5};
        ListNode head = ListNode.getInstance().from(arr);
        ListNode ansHead = ListNode.getInstance().from(ans);
        PartitionList p = new PartitionList();
        assertListNodeEquals(ansHead, p.partition(head, x));
    }
}