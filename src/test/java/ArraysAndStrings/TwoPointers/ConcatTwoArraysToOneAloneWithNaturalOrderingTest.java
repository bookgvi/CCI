package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ConcatTwoArraysToOneAloneWithNaturalOrderingTest {

    @Test
    public void processedConcatTwoArraysTest() {
        int[] arr1 = new int[]{1, 4, 7, 20};
        int[] arr2 = new int[]{3, 4, 5, 6};
        int[] res = new int[]{1, 3, 4, 4, 5, 6, 7, 20};
        ConcatTwoArraysToOneAloneWithNaturalOrdering c = new ConcatTwoArraysToOneAloneWithNaturalOrdering();
        Assert.assertArrayEquals(Arrays.toString(arr1) + " + " + Arrays.toString(arr2), res, c.processed(arr1, arr2));
    }
}