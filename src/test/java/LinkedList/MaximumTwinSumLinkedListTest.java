package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumTwinSumLinkedListTest {

    @Test
    public void pairSum_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{5,4,2,1});
        int ans = 6;
        MaximumTwinSumLinkedList m = new MaximumTwinSumLinkedList();
        Assert.assertEquals(ans, m.pairSum(head));
    }

    @Test
    public void pairSum_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{47,22,81,46,94,95,90,22,55,91,6,83,49,65,10,32,41,26,83,99,14,85,42,99,89,69,30,92,32,74,9,81,5,9});
        int ans = 182;
        MaximumTwinSumLinkedList m = new MaximumTwinSumLinkedList();
        Assert.assertEquals(ans, m.pairSum(head));
    }
}