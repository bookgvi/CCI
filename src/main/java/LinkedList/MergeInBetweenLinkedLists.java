package LinkedList;

/**
 * <a href="https://leetcode.com/problems/merge-in-between-linked-lists/">...</a>
 * You are given two linked lists: list1 and list2 of sizes n and m respectively.
 * <p>
 * Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 * <p>
 * The blue edges and nodes in the following figure indicate the result:
 * <a href="https://assets.leetcode.com/uploads/2020/11/05/fig1.png">...</a>
 * <p>
 * Build the result list and return its head.
 */
public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode sentinelList1 = list1;
        ListNode sentinelList2 = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        int i = 1, counter = 0;
        while (list1 != null && list1.next != null) {
            if (a == i) {
                ListNode list1PointA = list1;
                ListNode list2PointA = null;
                while (list1.next != null && counter < b - a + 1) {
                    list2PointA = sentinelList2;
                    list1 = list1.next;
                    counter += 1;
                }
                list1PointA.next = list2PointA;
                list2.next = list1.next;
                break;
            }

            list1 = list1.next;
            i += 1;
        }
        return sentinelList1;
    }
}
