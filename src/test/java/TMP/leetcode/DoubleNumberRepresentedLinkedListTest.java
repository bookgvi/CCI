package TMP.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleNumberRepresentedLinkedListTest {

    @Test
    public void test1() {
        DoubleNumberRepresentedLinkedList d = new DoubleNumberRepresentedLinkedList();
        DoubleNumberRepresentedLinkedList.ListNode listNode = new DoubleNumberRepresentedLinkedList.ListNode(1);
        listNode.next = new DoubleNumberRepresentedLinkedList.ListNode(2);
        listNode.next.next = new DoubleNumberRepresentedLinkedList.ListNode(3);
        listNode.next.next.next = new DoubleNumberRepresentedLinkedList.ListNode(4);
        listNode.next.next.next.next = new DoubleNumberRepresentedLinkedList.ListNode(5);

        DoubleNumberRepresentedLinkedList.ListNode res = d.doubleIt(listNode);
    }
    @Test
    public void test2() {
        DoubleNumberRepresentedLinkedList d = new DoubleNumberRepresentedLinkedList();
        DoubleNumberRepresentedLinkedList.ListNode listNode = new DoubleNumberRepresentedLinkedList.ListNode(9);
        listNode.next = new DoubleNumberRepresentedLinkedList.ListNode(9);
        listNode.next.next = new DoubleNumberRepresentedLinkedList.ListNode(9);
        listNode.next.next.next = new DoubleNumberRepresentedLinkedList.ListNode(9);
        listNode.next.next.next.next = new DoubleNumberRepresentedLinkedList.ListNode(9);

        DoubleNumberRepresentedLinkedList.ListNode res = d.doubleIt(listNode);
    }
}