package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersIITest {

    private void assertEquals(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            Assert.assertEquals(l1.val, l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        Assert.assertNull(l1);
        Assert.assertNull(l2);
    }

    @Test
    public void addTwoNumbers_test1() {
        ListNode l1 = ListNode.getInstance().from(new int[]{1,2,3,4});
        ListNode l2 = ListNode.getInstance().from(new int[]{1,2,3,4});
        ListNode ans = ListNode.getInstance().from(new int[]{2,4,6,8});
        AddTwoNumbersII a = new AddTwoNumbersII();
        ListNode res = a.addTwoNumbers(l1, l2);
        assertEquals(ans, res);
    }

    @Test
    public void addTwoNumbers_test2() {
        ListNode l1 = ListNode.getInstance().from(new int[]{5});
        ListNode l2 = ListNode.getInstance().from(new int[]{5});
        ListNode ans = ListNode.getInstance().from(new int[]{1,0});
        AddTwoNumbersII a = new AddTwoNumbersII();
        ListNode res = a.addTwoNumbers(l1, l2);
    }
}