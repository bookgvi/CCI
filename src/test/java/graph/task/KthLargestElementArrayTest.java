package graph.task;
import org.junit.Test;
import static org.junit.Assert.*;

public class KthLargestElementArrayTest {

    @Test
    public void testFindKthLargest() {
        KthLargestElementArray kthLargest = new KthLargestElementArray();

        int[] nums = {5, 10, 15, 20, 25};
        int k = 3;
        int result = kthLargest.findKthLargest(nums, k);
        assertEquals(15, result);
    }
    @Test
    public void testFindKthLargest2() {
        KthLargestElementArray kthLargest = new KthLargestElementArray();

        int[] nums = {25, 20, 15, 10, 5, 66, 12, 123};
        int k = 3;
        int result = kthLargest.findKthLargest(nums, k);
        assertEquals(25, result);
    }

    @Test
    public void testFindKthLargest3() {
        KthLargestElementArray kthLargest = new KthLargestElementArray();

        int[] nums = {25};
        int k = 1;
        int result = kthLargest.findKthLargest(nums, k);
        assertEquals(25, result);
    }
    @Test
    public void testFindKthLargest4() {
        KthLargestElementArray kthLargest = new KthLargestElementArray();

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int result = kthLargest.findKthLargest(nums, k);
        assertEquals(4, result);
    }

    @Test
    public void testFindKthLargest_EmptyArray() {
        KthLargestElementArray kthLargest = new KthLargestElementArray();

        int[] nums = {};
        int k = 1;
        int result = kthLargest.findKthLargest(nums, k);
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    public void testFindKthLargest_KGreaterThanArraySize() {
        KthLargestElementArray kthLargest = new KthLargestElementArray();

        int[] nums = {5, 10, 15, 20, 25};
        int k = 6;
        int result = kthLargest.findKthLargest(nums, k);
        assertEquals(Integer.MIN_VALUE, result);
    }
}