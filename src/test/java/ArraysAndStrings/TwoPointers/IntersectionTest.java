package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionTest {

    @Test
    public void getIntersection_test1() {
        int[] nums1 = new int[]{1,2,3,4,5,2,2,3,3,4,5,5};
        int[] nums2 = new int[]{1,1,1,1,1,1,6,6,66,6,6,6,};
        Intersection i = new Intersection();
        int[] intersectArr = i.getIntersection(nums1, nums2);
        Assert.assertEquals(1, intersectArr.length);
    }

    @Test
    public void getIntersection_test2() {
        int[] nums1 = new int[]{1,2,3,4,5,2,2,3,3,4,5,5};
        int[] nums2 = new int[]{6,6,66,6,6,6,};
        Intersection i = new Intersection();
        int[] intersectArr = i.getIntersection(nums1, nums2);
        Assert.assertEquals(0, intersectArr.length);
    }
}