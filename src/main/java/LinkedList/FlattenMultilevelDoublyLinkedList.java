package LinkedList;

import java.util.Arrays;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/">...</a>
 * <p>
 * You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer,
 * and an additional child pointer. This child pointer may or may not point to a separate doubly linked list,
 * also containing these special nodes. These child lists may have one or more children of their own, and so on,
 * to produce a multilevel data structure as shown in the example below.
 * <p>
 * Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level,
 * doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr
 * and before curr.next in the flattened list.
 * <p>
 * Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 */
public class FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        Integer[] nums = nodeToArr(head);
        int p1 = -1, len = nums.length, counter = 0;
        Object o = null;
        for (int i = 0; i < len; i += 1) {
            if (!Objects.equals(nums[i], o)) {
                p1 -= 1;
            } else {
                nums[++p1] = nums[i];
                counter += 1;
            }
        }
        Integer[] res = Arrays.copyOf(nums, counter);
        return null;
    }

    public Integer[] flatten(Integer[] nums) {
        int p1 = -1, len = nums.length, p2 = len - 1;
        Integer[] other = new Integer[len];
        Object o = null;
        for (int i = 0; i < len; i += 1) {
            if (Objects.equals(nums[i], o)) {
                other[p2--] = nums[p1--];
            } else {
                nums[++p1] = nums[i];
            }
        }
        Integer[] arr1 = Arrays.copyOf(nums, p1 + 1);
        Integer[] arr2 = new Integer[len - p2 - 1];
        Integer[] res = new Integer[arr1.length + arr2.length];
        System.arraycopy(other, p2 + 1, arr2, 0, len - p2 - 1);
        System.arraycopy(arr1, 0, res, 0, arr1.length);
        System.arraycopy(arr2, 0, res, arr1.length, arr2.length);
        return res;
    }

    private Integer[] nodeToArr(Node head) {
        Integer[] nums = new Integer[Integer.MAX_VALUE];
        int len = 0;
        while (head != null) {
            nums[len++] = head.val;
            head = (Node) head.next;
        }
        return Arrays.copyOf(nums, len);
    }

    private static class Node extends ListNode {
        public Node(int val, ListNode next) {
            super(val, next);
        }

    }
}
