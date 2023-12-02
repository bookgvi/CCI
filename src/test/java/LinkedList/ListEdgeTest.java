package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class ListEdgeTest {

    @Test
    public void from_test1() {
        int[] nums = new int[] {1,2,3,4,5};
        int i = 0, len = nums.length;
        ListNode l = ListNode.getInstance();
        ListNode head = l.from(nums);
        Assert.assertEquals(nums[0], head.getVal());

        ListNode next = head.getNext();
        while (next != null) {
            i += 1;
            Assert.assertEquals(nums[i], next.getVal());
            next = next.getNext();
        }
        Assert.assertEquals(len, i + 1);
    }

    @Test
    public void from_test2() {
        String s = "hello world!";
        int i = 0, len = s.length();
        ListNode l = ListNode.getInstance();
        ListNode head = l.from(s);
        Assert.assertEquals(s.charAt(0), (char) head.getVal());

        ListNode next = head.getNext();
        while (next != null) {
            i += 1;
            Assert.assertEquals(s.charAt(i), next.getVal());
            next = next.getNext();
        }
        Assert.assertEquals(len, i + 1);
    }

    @Test
    public void getMiddle_test1() {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        ListNode l = ListNode.getInstance().from(nums);
        ListNode secondHalf = l.divide();
    }

    @Test
    public void reverse_test1() {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        ListNode l = ListNode.getInstance().from(nums);
        ListNode reverseLL = l.reverse();
    }

    @Test
    public void reverseSubList_test1() {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        ListNode l = ListNode.getInstance().from(nums);
        ListNode start = ListNode.getInstance();
        ListNode end = ListNode.getInstance();
        start.setVal(2);
    }

    @Test
    public void sort_test1() {
        int[] nums = new int[] {3,4,7,2,6,9,78,12,90};
        ListNode l = ListNode.getInstance().from(nums);
        ListNode res = l.sort(l);
    }
}