package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyTwoNumbersTest {

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
    public void solution_test1() {
        ListNode l1 = ListNode.getInstance().from(new int[]{1,2,3,4,5});
        ListNode l2 = ListNode.getInstance().from(new int[]{2});
        ListNode ans = ListNode.getInstance().from(new int[]{2,4,6,9,0});
        MultiplyTwoNumbers m = new MultiplyTwoNumbers();
        ListNode res = m.solution(l1, l2);
        assertEquals(ans, res);
    }

    @Test
    public void solution_test2() {
        ListNode l1 = ListNode.getInstance().from(new int[]{5});
        ListNode l2 = ListNode.getInstance().from(new int[]{5});
        ListNode ans = ListNode.getInstance().from(new int[]{2,5});
        MultiplyTwoNumbers m = new MultiplyTwoNumbers();
        ListNode res = m.solution(l1, l2);
        assertEquals(ans, res);
    }

    @Test
    public void solution_test3() {
        ListNode l1 = ListNode.getInstance().from(new int[]{5});
        ListNode l2 = ListNode.getInstance().from(new int[]{5, 5});
        ListNode ans = ListNode.getInstance().from(new int[]{2,7,5});
        MultiplyTwoNumbers m = new MultiplyTwoNumbers();
        ListNode res = m.solution(l1, l2);
        assertEquals(ans, res);
    }

    @Test
    public void solution_test4() {
        ListNode l1 = ListNode.getInstance().from(new int[]{0});
        ListNode l2 = ListNode.getInstance().from(new int[]{5, 5});
        ListNode ans = ListNode.getInstance().from(new int[]{0});
        MultiplyTwoNumbers m = new MultiplyTwoNumbers();
        ListNode res = m.solution(l1, l2);
        assertEquals(ans, res);
    }

    @Test
    public void solution_test5() {
        ListNode l1 = ListNode.getInstance().from(new int[]{0});
        ListNode l2 = ListNode.getInstance().from(new int[]{5,1,2,3,4,5});
        ListNode ans = ListNode.getInstance().from(new int[]{0});
        MultiplyTwoNumbers m = new MultiplyTwoNumbers();
        ListNode res = m.solution(l1, l2);
        assertEquals(ans, res);
    }

    @Test
    public void solution_test6() {
        ListNode l1 = ListNode.getInstance().from(new int[]{0});
        ListNode l2 = ListNode.getInstance().from(new int[]{0});
        ListNode ans = ListNode.getInstance().from(new int[]{0});
        MultiplyTwoNumbers m = new MultiplyTwoNumbers();
        ListNode res = m.solution(l1, l2);
        assertEquals(ans, res);
    }

    @Test
    public void solution_test7() {
        ListNode l1 = ListNode.getInstance().from(new int[]{9});
        ListNode l2 = ListNode.getInstance().from(new int[]{9});
        ListNode ans = ListNode.getInstance().from(new int[]{8,1});
        MultiplyTwoNumbers m = new MultiplyTwoNumbers();
        ListNode res = m.solution(l1, l2);
        assertEquals(ans, res);
    }

    @Test
    public void solution_test8() {
        ListNode l1 = ListNode.getInstance().from(new int[]{9,9});
        ListNode l2 = ListNode.getInstance().from(new int[]{9,9});
        ListNode ans = ListNode.getInstance().from(new int[]{9,8,0,1});
        MultiplyTwoNumbers m = new MultiplyTwoNumbers();
        ListNode res = m.solution(l1, l2);
        assertEquals(ans, res);
    }

    @Test
    public void solution_test9() {
        ListNode l1 = ListNode.getInstance().from(new int[]{9,9,9,9,9});
        ListNode l2 = ListNode.getInstance().from(new int[]{9,9,9,9,9});
        ListNode ans = ListNode.getInstance().from(new int[]{9,9,9,9,8,0,0,0,0,1});
        MultiplyTwoNumbers m = new MultiplyTwoNumbers();
        ListNode res = m.solution(l1, l2);
        assertEquals(ans, res);
    }

    @Test
    public void solution_test10() {
        ListNode l1 = ListNode.getInstance().from(new int[]{1,0,2,4});
        ListNode l2 = ListNode.getInstance().from(new int[]{2});
        ListNode ans = ListNode.getInstance().from(new int[]{2,0,4,8});
        MultiplyTwoNumbers m = new MultiplyTwoNumbers();
        ListNode res = m.solution(l1, l2);
        assertEquals(ans, res);
    }
}