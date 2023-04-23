package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    private int failVal = -1;
    @Test
    public void get() {
        MyLinkedList m = new MyLinkedList();
        Assert.assertEquals(failVal, m.get(1));
        Assert.assertEquals(failVal, m.get(0));
    }

    @Test
    public void addAtHead() {
        MyLinkedList m = new MyLinkedList();
        int v1 = 100, v2 = 200;
        m.addAtHead(v2);
        m.addAtHead(v1);
        Assert.assertEquals(v1, m.get(0));
        Assert.assertEquals(v2, m.get(1));
        Assert.assertEquals(failVal, m.get(2));
    }

    @Test
    public void addAtTail() {
        MyLinkedList m = new MyLinkedList();
        int v1 = 100, v2 = 200, vLast = 666;
        m.addAtHead(v2);
        m.addAtHead(v1);
        m.addAtTail(vLast);
        Assert.assertEquals(v1, m.get(0));
        Assert.assertEquals(v2, m.get(1));
        Assert.assertEquals(vLast, m.get(2));
        Assert.assertEquals(failVal, m.get(3));

    }

    @Test
    public void addAtIndex_test0() {
        MyLinkedList m = new MyLinkedList();
        int v1 = 100, v2 = 200, vLast = 666, newVal = 300;
        m.addAtHead(v2);
        m.addAtHead(v1);
        m.addAtTail(vLast);
        Assert.assertEquals(v1, m.get(0));
        Assert.assertEquals(v2, m.get(1));
        Assert.assertEquals(vLast, m.get(2));
        Assert.assertEquals(failVal, m.get(3));

        m.addAtIndex(2, newVal);
        Assert.assertEquals(newVal, m.get(2));
        Assert.assertEquals(vLast, m.get(3));
        Assert.assertEquals(failVal, m.get(4));

    }

    @Test
    public void addAtIndex_test1() {
        MyLinkedList m = new MyLinkedList();
        int v1 = 100, v2 = 200, vLast = 666, newVal = 0;
        m.addAtIndex(1, newVal);
        Assert.assertEquals(failVal, m.get(0));
//        Assert.assertEquals(vLast, m.get(3));
//        Assert.assertEquals(failVal, m.get(4));

    }

    @Test
    public void deleteAtIndex() {
        MyLinkedList m = new MyLinkedList();
        int v1 = 100, v2 = 200, vLast = 666, newVal = 300;
        m.addAtHead(v2);
        m.addAtHead(v1);
        m.addAtTail(vLast);
        Assert.assertEquals(v1, m.get(0));
        Assert.assertEquals(v2, m.get(1));
        Assert.assertEquals(vLast, m.get(2));
        Assert.assertEquals(failVal, m.get(3));

        m.deleteAtIndex(2);
        Assert.assertEquals(failVal, m.get(2));
        Assert.assertEquals(failVal, m.get(3));
    }
}