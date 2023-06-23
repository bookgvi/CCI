package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class InPlaceReversalTest extends AbstractAssertForListNode {

    @Test
    public void proceed_test1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int[] ansNums = new int[]{6, 5, 4, 3, 2, 1};
//        ListNode head = ListNode.getInstance().from(nums);
//        ListNode ans = ListNode.getInstance().from(ansNums);
        InPlaceReversal.ListNode ans = new InPlaceReversal.ListNode().from(ansNums);
        InPlaceReversal i = new InPlaceReversal();
        InPlaceReversal.ListNode res = i.proceed(nums);
//        assertEquals(ans, res);
    }

    @Test
    public void proceed_test2() {
        String str = "1234567890";
        String subStr = "45611178";
        int p1 = 0, p2 = 0, len1 = str.length(), len2 = subStr.length();
        while (p1 < len1 && p2 < len2) {
            char ch1 = str.charAt(p1++);
            char ch2 = subStr.charAt(p2);
            p2 = ch1 == ch2 ? p2 + 1 : 0;
        }
        Assert.assertNotEquals(p2, len2);
    }


    @Test
    public void proceed_test3() {
        String str = "";
        String subStr = "45678";
        int p1 = 0, p2 = 0, len1 = str.length(), len2 = subStr.length();
        while (p1 < len1 && p2 < len2) {
            char ch1 = str.charAt(p1++);
            char ch2 = subStr.charAt(p2);
            p2 = ch1 == ch2 ? p2 + 1 : 0;
        }
        Assert.assertNotEquals(p2, len2);
    }


    @Test
    public void proceed_test4() {
        String str = "9";
        String subStr = "45678";
        int p1 = 0, p2 = 0, len1 = str.length(), len2 = subStr.length();
        while (p1 < len1 && p2 < len2) {
            char ch1 = str.charAt(p1++);
            char ch2 = subStr.charAt(p2);
            p2 = ch1 == ch2 ? p2 + 1 : 0;
        }
        Assert.assertNotEquals(p2, len2);
    }

    @Test
    public void proceed_test5() {
        String str = "9";
        String subStr = "";
        int p1 = 0, p2 = 0, len1 = str.length(), len2 = subStr.length();
        while (p1 < len1 && p2 < len2) {
            char ch1 = str.charAt(p1++);
            char ch2 = subStr.charAt(p2);
            p2 = ch1 == ch2 ? p2 + 1 : 0;
        }
        Assert.assertEquals(0, p2);
        Assert.assertEquals(len2, p2);
    }

    @Test
    public void proceed_test6() {
        String str = "";
        String subStr = "";
        int p1 = 0, p2 = 0, len1 = str.length(), len2 = subStr.length();
        while (p1 < len1 && p2 < len2) {
            char ch1 = str.charAt(p1++);
            char ch2 = subStr.charAt(p2);
            p2 = ch1 == ch2 ? p2 + 1 : 0;
        }
        Assert.assertEquals(0, p2);
        Assert.assertEquals(len2, p2);
    }

//    @Test
//    public void proceed_test2() {
//        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5,6,7});
//        ListNode ans = ListNode.getInstance().from(new int[]{7,6,5,4,3,2,1});
//        InPlaceReversal i = new InPlaceReversal();
//        ListNode res = i.proceed(head);
//        assertEquals(ans, res);
//    }
//
//    @Test
//    public void proceed_test3() {
//        ListNode head = ListNode.getInstance().from(new int[]{1});
//        ListNode ans = ListNode.getInstance().from(new int[]{1});
//        InPlaceReversal i = new InPlaceReversal();
//        ListNode res = i.proceed(head);
//        assertEquals(ans, res);
//    }
}