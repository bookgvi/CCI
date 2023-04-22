package LinkedList;

public class MultiplyTwoNumbers {
    public ListNode solution(ListNode l1, ListNode l2) {
        AddTwoNumbersII a = new AddTwoNumbersII();
        ListNode reverseL1 = reverseList(l1);
        ListNode sentinelForReverseL1 = reverseL1;
        ListNode reverseL2 = reverseList(l2);
        int loop = 0;
        int extraDigit = 0;
        ListNode reverseRes = new ListNode(Integer.MIN_VALUE, null);
        ListNode prevReverseRes = new ListNode(Integer.MIN_VALUE, reverseRes);
        ListNode sentinel = reverseRes;
        ListNode res = new ListNode(0, null);
        while (reverseL2 != null) {
            while (reverseL1 != null) {
                int mul = reverseL1.val * reverseL2.val + extraDigit;
                int digit = mul % 10;
                extraDigit = mul / 10;

                reverseRes.val = digit;
                reverseRes.next = new ListNode(digit, null);
                reverseRes = reverseRes.next;
                prevReverseRes = prevReverseRes.next;

                reverseL1 = reverseL1.next;
            }
            prevReverseRes.next = extraDigit != 0 ? new ListNode(extraDigit, null) : null;
            ListNode add = reverseList(sentinel);
            // add zeros
            for (int i = 0; i < loop; i += 1) {
                sentinel.next = new ListNode(0, null);
                sentinel = sentinel.next;
            }
            // sum of previous multiplications
            res = a.addTwoNumbers(res, add);
            loop += 1;

            reverseRes = new ListNode(Integer.MIN_VALUE, null);
            prevReverseRes = new ListNode(Integer.MIN_VALUE, reverseRes);
            sentinel = reverseRes;

            extraDigit = 0;
            reverseL1 = sentinelForReverseL1;
            reverseL2 = reverseL2.next;
        }
        prevReverseRes.next = null;
        return sanitizeZeros(res);
    }

    private ListNode sanitizeZeros(ListNode res) {
        while (res != null && res.val == 0) {
            res = res.next;
        }
        res = res == null ? new ListNode(0, null) : res;
        return res;
    }

    private ListNode reverseList(ListNode head) {
        ListNode reverseHead = head;
        ListNode prev = new ListNode(Integer.MIN_VALUE, reverseHead);
        while (head != null) {
            ListNode curHead = reverseHead;
            reverseHead = head;
            head = head.next;
            reverseHead.next = curHead;
            prev = prev.next;
        }
        prev.next = null;
        return reverseHead;
    }

}
