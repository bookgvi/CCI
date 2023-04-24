package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConcatTwoArraysToOneAloneWithNaturalOrderingTest {

    @Test
    public void processedConcatTwoArraysTest() {
        int[] arr1 = new int[]{1, 4, 7, 20};
        int[] arr2 = new int[]{3, 4, 5, 6};
        int[] res = new int[]{1, 3, 4, 4, 5, 6, 7, 20};
        ConcatTwoArraysToOneAloneWithNaturalOrdering c = new ConcatTwoArraysToOneAloneWithNaturalOrdering();
        Assert.assertArrayEquals(Arrays.toString(arr1) + " + " + Arrays.toString(arr2), res, c.processed(arr1, arr2));
    }

    @Test
    public void merge_test1() {
        int[] arr1 = new int[]{1, 20};
        int[] arr2 = new int[]{3, 4, 5, 6};
        int[] ans = new int[]{1, 3, 4, 5, 6, 20};
        Set<Integer> s1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        Set<Integer> ansSet = Arrays.stream(ans).boxed().collect(Collectors.toSet());

        ConcatTwoArraysToOneAloneWithNaturalOrdering c = new ConcatTwoArraysToOneAloneWithNaturalOrdering();
        Set<Integer> res = c.merge(s1, s2);
        Assert.assertEquals(ansSet, res);
    }

    @Test
    public void merge_test2() {
        int[] arr1 = new int[]{1, 20};
        int[] arr2 = new int[]{3, 4, 5, 6};
        int[] ans = new int[]{1, 3, 4, 5, 6, 20};
        Set<Integer> s1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        List<Integer> s2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        Set<Integer> ansSet = Arrays.stream(ans).boxed().collect(Collectors.toSet());

        ConcatTwoArraysToOneAloneWithNaturalOrdering c = new ConcatTwoArraysToOneAloneWithNaturalOrdering();
        Set<Integer> res = c.merge(s1, s2);
        Assert.assertEquals(ansSet, res);
    }
}