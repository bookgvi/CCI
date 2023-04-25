package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

public class SplitLinkedListPartsTest {
    private void assertEquals(ListNode[] collection1, ListNode[] collection2) {
        Iterator<ListNode> it1 = Arrays.stream(collection1).iterator();
        Iterator<ListNode> it2 = Arrays.stream(collection2).iterator();
        int len1 = 0, len2 = 0;
        while (it1.hasNext() && it2.hasNext()) {
            ListNode l1 = it1.next();
            ListNode l2 = it2.next();
            len1 += 1;
            len2 += 1;
            while (l1 != null && l2 != null) {
                Assert.assertEquals(l1.val, l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }
            Assert.assertNull(l1);
            Assert.assertNull(l2);
        }
        Assert.assertEquals(len1, len2);
    }

    @Test
    public void splitListToParts_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{1, 2, 3});
        int k = 5;
        ListNode[] ans = new ListNode[]{
                ListNode.getInstance().from(new int[]{1}),
                ListNode.getInstance().from(new int[]{2}),
                ListNode.getInstance().from(new int[]{3})
        };
        SplitLinkedListParts s = new SplitLinkedListParts();
        ListNode[] res = s.splitListToParts(head, k);
        assertEquals(ans, res);
    }

    @Test
    public void splitListToParts_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int k = 3;
        ListNode[] ans = new ListNode[]{
                ListNode.getInstance().from(new int[]{1, 2, 3, 4}),
                ListNode.getInstance().from(new int[]{5, 6, 7}),
                ListNode.getInstance().from(new int[]{8, 9, 10})
        };
        SplitLinkedListParts s = new SplitLinkedListParts();
        ListNode[] res = s.splitListToParts(head, k);
        assertEquals(ans, res);
    }

    @Test
    public void splitListToParts_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int k = 2;
        ListNode[] ans = new ListNode[]{
                ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5}),
                ListNode.getInstance().from(new int[]{6, 7, 8, 9, 10})
        };
        SplitLinkedListParts s = new SplitLinkedListParts();
        ListNode[] res = s.splitListToParts(head, k);
        assertEquals(ans, res);
    }

    @Test
    public void splitListToParts_test4() {
        ListNode head = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int k = 15;
        ListNode[] ans = new ListNode[]{
                ListNode.getInstance().from(new int[]{1}),
                ListNode.getInstance().from(new int[]{2}),
                ListNode.getInstance().from(new int[]{3}),
                ListNode.getInstance().from(new int[]{4}),
                ListNode.getInstance().from(new int[]{5}),
                ListNode.getInstance().from(new int[]{6}),
                ListNode.getInstance().from(new int[]{7}),
                ListNode.getInstance().from(new int[]{8}),
                ListNode.getInstance().from(new int[]{9}),
                ListNode.getInstance().from(new int[]{10}),
                null,
                null,
                null,
                null,
                null
        };
        SplitLinkedListParts s = new SplitLinkedListParts();
        ListNode[] res = s.splitListToParts(head, k);
        assertEquals(ans, res);
    }

    @Test
    public void splitListToParts_test5() {
        ListNode head = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int k = 1;
        ListNode[] ans = new ListNode[]{
                ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
        };
        SplitLinkedListParts s = new SplitLinkedListParts();
        ListNode[] res = s.splitListToParts(head, k);
        assertEquals(ans, res);
    }

    @Test
    public void splitListToParts_test6() {
        ListNode head = ListNode.getInstance().from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int k = 50;
        ListNode[] ans = new ListNode[50];
        for (int i = 1; i <= 10; i += 1) {
            ans[i - 1] = ListNode.getInstance().from(new int[]{i});
        }
        SplitLinkedListParts s = new SplitLinkedListParts();
        ListNode[] res = s.splitListToParts(head, k);
        assertEquals(ans, res);
    }
}