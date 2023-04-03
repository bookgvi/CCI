package ArraysAndStrings.TwoPointers;

import org.junit.Test;

import java.util.List;

public class HashSetTPTest {

    @Test
    public void convert_test1() {
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 2, 3, 4, 4, 4, 46, 5, 5, 5, 5, 5};
        HashSetTP hs = new HashSetTP();
        List<Integer> set = hs.convert(arr);
    }

    @Test
    public void convert_test2() {
        int[] arr1 = new int[]{1, 1, 1, 1, 1, 1, 2, 3, 4, 4, 4, 46, 5, 5, 5, 5, 5};
        int[] arr2 = new int[]{1, 1, 2, 1, 1, 1, 2, 3, 4, 4, 4, 46, 5, 5, 5, 5, 5};
        int[] arr3 = new int[]{1, 1, 1, 1, 22, 22, 2, 3, 4, 4, 46, 46, 5, 5, 5, 5, 5};
        HashSetTP hs = new HashSetTP();
        List<Integer> set = hs.convert(arr1, arr2, arr3);
    }
}