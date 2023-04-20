package LinkedList;

import org.junit.Assert;
import org.junit.Test;


public class PalindromeLinkedListTest {
    public void isEqual() {
    }

    //    @Test
    public void from_test() {
        int[] nums = new int[]{1, 2, 3, 5, 5};
        ListNode head = new PalindromeLinkedList().from(nums);
    }

    @Test
    public void isPalindrome_test1() {
        int[] nums = new int[]{1, 2, 3, 5, 5, 3, 2, 1};
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode head = p.from(nums);
        Assert.assertTrue(p.isPalindrome(head));
    }


    @Test
    public void isPalindrome_test1_1() {
        int[] nums = new int[]{1};
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode head = p.from(nums);
        Assert.assertTrue(p.isPalindrome(head));
    }

    @Test
    public void isPalindrome_test2() {
        int[] nums = new int[]{1, 2};
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode head = p.from(nums);
        Assert.assertFalse(p.isPalindrome(head));
    }

    @Test
    public void isPalindrome_test3() {
        int[] nums = new int[]{1, 2, 3, 5, 6, 5, 3, 2, 1};
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode head = p.from(nums);
        Assert.assertTrue(p.isPalindrome(head));
    }

    @Test
    public void isPalindrome_test4() {
        int[] nums = new int[]{1, 1};
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode head = p.from(nums);
        Assert.assertTrue(p.isPalindrome(head));
    }

    @Test
    public void isPalindrome_test5() {
        int[] nums = new int[]{1, 3, 1};
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode head = p.from(nums);
        Assert.assertTrue(p.isPalindrome(head));
    }


    @Test
    public void isPalindrome_test6() {
        int[] nums = new int[]{1, 2, 3, 5, 6, 6, 5, 3, 2, 1};
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode head = p.from(nums);
        Assert.assertTrue(p.isPalindrome(head));
    }

    @Test
    public void isPalindrome_test7() {
        int[] nums = new int[]{1, 2, 3, 5, 6, 7, 6, 5, 3, 2, 1};
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode head = p.from(nums);
        Assert.assertTrue(p.isPalindrome(head));
    }


}