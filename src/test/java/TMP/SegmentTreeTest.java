package TMP;

import org.junit.Test;

import static org.junit.Assert.*;

public class SegmentTreeTest {
    @Test
    public void testQuery() {
        int[] input = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(input);

        // Test querying a range [1, 3]
        assertEquals(8, segmentTree.query(1, 3));

        // Test querying a range [0, 4]
        assertEquals(16, segmentTree.query(0, 4));

        // Add more test cases as needed
    }

    @Test
    public void testChangeValue() {
        int[] input = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(input);

        // Change the value at index 2 to 10
        segmentTree.changeValue(2, 10);

        // Test querying a range [1, 3] after value change
        assertEquals(13, segmentTree.query(1, 3));

        // Test querying a range [0, 4] after value change
        assertEquals(21, segmentTree.query(0, 4));

        // Add more test cases as needed
    }

}