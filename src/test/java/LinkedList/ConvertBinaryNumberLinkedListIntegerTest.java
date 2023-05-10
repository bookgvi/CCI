package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertBinaryNumberLinkedListIntegerTest {

    @Test
    public void getDecimalValue_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1,0,1});
        int ans = 5;
        ConvertBinaryNumberLinkedListInteger c = new ConvertBinaryNumberLinkedListInteger();
        int res = c.getDecimalValue(head);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void getDecimalValue_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1,0,1,0});
        int ans = 10;
        ConvertBinaryNumberLinkedListInteger c = new ConvertBinaryNumberLinkedListInteger();
        int res = c.getDecimalValue(head);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void getDecimalValue_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{0,0,0,1,0,1,0});
        int ans = 10;
        ConvertBinaryNumberLinkedListInteger c = new ConvertBinaryNumberLinkedListInteger();
        int res = c.getDecimalValue(head);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void getDecimalValue_test4() {
        ListNode head = ListNode.getInstance().from(new int[]{0,0,0,1,1,1});
        int ans = 7;
        ConvertBinaryNumberLinkedListInteger c = new ConvertBinaryNumberLinkedListInteger();
        int res = c.getDecimalValue(head);
        Assert.assertEquals(ans, res);
    }
}