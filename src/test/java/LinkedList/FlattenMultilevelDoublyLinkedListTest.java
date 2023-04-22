package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlattenMultilevelDoublyLinkedListTest {

    @Test
    public void flatten() {
        Integer[] nums = new Integer[]{1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12};
        Integer[] ans = new Integer[]{1,2,3,7,8,11,12,9,10,4,5,6};
        FlattenMultilevelDoublyLinkedList f = new FlattenMultilevelDoublyLinkedList();
        Assert.assertArrayEquals(ans, f.flatten(nums));
    }
}