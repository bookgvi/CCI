package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindDifferenceTwoArraysTest {

    @Test
    public void findDifference_test1() {
        int[] nums1 = new int[]{1,2,3,3};
        int[] nums2 = new int[]{1,1,2,2};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        ans.add(l1);
        ans.add(l2);
        l1.add(3);

        FindDifferenceTwoArrays f = new FindDifferenceTwoArrays();
        List<List<Integer>> resList = f.findDifference(nums1, nums2);
        Assert.assertEquals(ans, resList);
    }

    @Test
    public void findDifference_test2() {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{2,4,6};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        ans.add(l1);
        ans.add(l2);
        l1.add(1);
        l1.add(3);
        l2.add(4);
        l2.add(6);

        FindDifferenceTwoArrays f = new FindDifferenceTwoArrays();
        List<List<Integer>> resList = f.findDifference(nums1, nums2);
        Assert.assertEquals(ans, resList);
    }
}