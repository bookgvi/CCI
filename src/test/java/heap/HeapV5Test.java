package heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class HeapV5Test {

    @Test
    public void testAdd() {
        HeapV5<Integer> heap = new HeapV5<>();
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
        HeapV5<String> heap = new HeapV5<>(Comparator.reverseOrder(), 5);
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
        HeapV5<Integer> heap = new HeapV5<>();
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
        HeapV5<Integer> heap = new HeapV5<>(Comparator.naturalOrder(), 3);
        Assert.assertEquals(3, heap.getHeapSize());
        heap.offer(10);
        heap.offer(20);
        heap.offer(30);

        heap.offer(40); // Trigger grow() method
        Assert.assertEquals(4, heap.getHeapSize());

        heap.offer(50); // Trigger grow() method
        Assert.assertEquals(6, heap.getHeapSize());

        Assert.assertEquals(10, (int) heap.poll());
        Assert.assertEquals(20, (int) heap.poll());
        Assert.assertEquals(30, (int) heap.poll());
        Assert.assertEquals(40, (int) heap.poll());
        Assert.assertEquals(50, (int) heap.poll());
        Assert.assertNull(heap.poll());
    }

}