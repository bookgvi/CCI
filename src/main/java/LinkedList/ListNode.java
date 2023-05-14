package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    private ListNode() {
        this(Integer.MIN_VALUE, null);
    }
    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode getInstance() {
        return new ListNode();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode divide() {
        ListNode head = this;
        ListNode secondHalf = head;
        ListNode fast = head;
        ListNode sentinel = getInstance();
        sentinel.setNext(head);
        while (fast != null && fast.getNext() != null) {
            sentinel = sentinel.getNext();
            secondHalf = secondHalf.getNext();
            fast = fast.getNext().getNext();
        }
        sentinel.setNext(null);
        return secondHalf;
    }

    public ListNode reverse(ListNode head) {
        ListNode reverse = null;
        ListNode h = head;
        while (h != null) {
            ListNode newHead = h;
            h = h.next;
            newHead.next = reverse;
            reverse = newHead;
        }
        return reverse;
    }

    public ListNode reverse() {
        ListNode sentinel = getInstance();
        ListNode ll = this;
        while (ll != null) {
            ListNode cur = sentinel.getNext();
            ListNode next = ll;
            sentinel.setNext(next);
            ll = ll.getNext();
            sentinel.getNext().setNext(cur);
        }
        return sentinel.getNext();
    }

    public ListNode sort(ListNode ln) {
        if (ln == null || ln.next == null) {
            return ln;
        }
        ListNode half = half(ln);
        return merge(sort(ln), sort(half));
    }

    private ListNode half(ListNode l) {
        ListNode slow = l.next;
        if (l.next != null) {
            ListNode fast = l.next.next;
            ListNode half = l;
            while (slow != null && fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                half = half.next;
            }
            half.next = null;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode mergeList = new ListNode(Integer.MIN_VALUE, null);
        ListNode dummy = mergeList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                mergeList.next = l1;
                l1 = l1.next;
            } else {
                mergeList.next = l2;
                l2 = l2.next;
            }
            mergeList = mergeList.next;
        }
        if (l1 != null) {
            mergeList.next = l1;
        } else if (l2 != null) {
            mergeList.next = l2;
        }
        return dummy.next;
    }

    public ListNode from(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) < 1) {
            return ListNode.getInstance();
        }
        ListNode head = getInstance();
        ListNode next = getInstance();
        head.setVal(nums[0]);
        if (len > 1) {
            head.setNext(next);
        }
        for (int i = 1; i < len; i += 1) {
            ListNode cur = next;
            cur.setVal(nums[i]);
            if (i < len - 1) {
                next = getInstance();
                cur.setNext(next);
            }
        }
        return head;
    }

    public ListNode from(String s) {
        int len;
        if (s == null || (len = s.length()) < 1) {
            return ListNode.getInstance();
        }
        ListNode head = getInstance();
        ListNode next = getInstance();
        char[] chars = s.toCharArray();
        head.setVal(chars[0]);
        if (len > 1) {
            head.setNext(next);
        }
        for (int i = 1; i < len; i += 1) {
            ListNode cur = next;
            cur.setVal(chars[i]);
            if (i < len - 1) {
                next = getInstance();
                cur.setNext(next);
            }
        }
        return head;
    }

    public ListNode from(int n, boolean isReverse) {
        ListNode res = null;
        while (n % 10 != 0) {
            ListNode l = new ListNode(n % 10);
            l.next = res;
            res = l;
            n /= 10;
        }
        return isReverse ? reverse(res) : res;
    }
}
