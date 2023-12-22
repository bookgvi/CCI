package graph.disjointSet;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DSJSetTest {

    @Test
    public void testFind() {
        // Test case 1: Finding the representative of an element in a set with no other elements
        DSJSet set1 = new DSJSet(1);
        Assert.assertEquals(0, set1.find(0));

        // Test case 2: Finding the representative of an element in a set with multiple elements
        DSJSet set2 = new DSJSet(5);
        set2.union(0, 1);
        set2.union(1, 2);
        set2.union(3, 4);
        Assert.assertEquals(0, set2.find(2));

        // Test case 3: Finding the representative of an element that is already the representative itself
        DSJSet set3 = new DSJSet(3);
        set3.union(0, 1);
        set3.union(1, 2);
        Assert.assertEquals(0, set3.find(2));

        // Test case 4: Finding the representative of an element in a set with self-loops
        DSJSet set4 = new DSJSet(4);
        set4.union(0, 0);
        set4.union(1, 1);
        set4.union(2, 2);
        set4.union(3, 3);
        Assert.assertEquals(2, set4.find(2));

        // Test case 5: Finding the representative of an element in a set with a chain of unions
        DSJSet set5 = new DSJSet(6);
        set5.union(0, 1);
        set5.union(1, 2);
        set5.union(2, 3);
        set5.union(3, 4);
        set5.union(4, 5);
        Assert.assertEquals(0, set5.find(5));

        // Test case 6: Finding the representative of an element in a set with a loop
        DSJSet set6 = new DSJSet(4);
        set6.union(0, 1);
        set6.union(1, 2);
        set6.union(2, 3);
        set6.union(3, 0);
        Assert.assertEquals(0, set6.find(2));

        // Test case 7: Finding the representative of an element in a large set
        DSJSet set7 = new DSJSet(1000);
        for (int i = 0; i < 999; i++) {
            set7.union(i, i + 1);
        }
        Assert.assertEquals(0, set7.find(500));
    }

    @Test
    public void testUnion() {
        // Test case 1: Union of two elements in the same set
        DSJSet set1 = new DSJSet(4);
        set1.union(0, 1);
        Assert.assertEquals(0, set1.find(0));
        Assert.assertEquals(0, set1.find(1));

        // Test case 2: Union of two elements in different sets
        DSJSet set2 = new DSJSet(4);
        set2.union(0, 1);
        set2.union(2, 3);
        set2.union(1, 2);
        Assert.assertEquals(0, set2.find(0));
        Assert.assertEquals(0, set2.find(1));
        Assert.assertEquals(0, set2.find(2));
        Assert.assertEquals(0, set2.find(3));
    }


    @Test
    public void testHasCycle() {
        DSJSet set = new DSJSet(6);
        int[][] edgesWithCycle = {{0, 1}, {1, 2}, {2, 0}};
        assertTrue(set.hasCycle(edgesWithCycle));

        set = new DSJSet(6);
        int[][] edgesWithoutCycle = {{0, 1}, {1, 2}, {3, 4}};
        assertFalse(set.hasCycle(edgesWithoutCycle));

        set = new DSJSet(6);
        edgesWithCycle = new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}, {4, 1}};
        assertTrue(set.hasCycle(edgesWithCycle));
    }
}