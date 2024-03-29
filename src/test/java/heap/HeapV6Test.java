package heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class HeapV6Test {

    @Test
    public void testAdd() {
        HeapV6<Integer> heap = new HeapV6<>();
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1);

        Assert.assertEquals(1, (int) heap.poll());
        Assert.assertEquals(3, (int) heap.poll());
        Assert.assertEquals(5, (int) heap.poll());
        Assert.assertEquals(7, (int) heap.poll());
        Assert.assertNull(heap.poll());
    }

    @Test
    public void testOffer() {
        HeapV6<String> heap = new HeapV6<>(Comparator.reverseOrder());
        heap.offer("apple");
        heap.offer("banana");
        heap.offer("cherry");
        heap.offer("durian");

        Assert.assertEquals("durian", heap.poll());
        Assert.assertEquals("cherry", heap.poll());
        Assert.assertEquals("banana", heap.poll());
        Assert.assertEquals("apple", heap.poll());
        Assert.assertNull(heap.poll());
    }

    @Test
    public void testPoll() {
        HeapV6<Integer> heap = new HeapV6<>();
        heap.offer(10);
        heap.offer(20);
        heap.offer(30);
        heap.offer(40);

        Assert.assertEquals(10, (int) heap.poll());
        Assert.assertEquals(20, (int) heap.poll());
        Assert.assertEquals(30, (int) heap.poll());
        Assert.assertEquals(40, (int) heap.poll());
        Assert.assertNull(heap.poll());
    }

    @Test
    public void testGrow() {
        HeapV6<Integer> heap = new HeapV6<>(Comparator.naturalOrder());
        heap.offer(10);
        heap.offer(20);
        heap.offer(30);
        Assert.assertEquals(3, heap.size());

        heap.offer(40); // Trigger grow() method
        Assert.assertEquals(4, heap.size());

        heap.offer(50); // Trigger grow() method
        Assert.assertEquals(5, heap.size());
        Assert.assertEquals(16, heap.getHeap().length);

        for (int i = 0; i <= 11; i += 1) {
            heap.offer(50); // Trigger grow() method
        }
        Assert.assertEquals(17, heap.size());
        Assert.assertEquals(24, heap.getHeap().length);

        Assert.assertEquals(10, (int) heap.poll());
        Assert.assertEquals(20, (int) heap.poll());
        Assert.assertEquals(30, (int) heap.poll());
        Assert.assertEquals(40, (int) heap.poll());
        for (int i = 0; i <= 12; i += 1) {
            Assert.assertEquals(50, (int) heap.poll());
        }
        Assert.assertNull(heap.poll());
    }

}