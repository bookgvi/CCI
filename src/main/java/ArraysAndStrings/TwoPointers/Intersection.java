package ArraysAndStrings.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

    public int[] getIntersection(int[] nums1, int[] nums2) {
        if (nums1.length < 1 || nums2.length < 1) {
            return new int[]{};
        }
        int[] numSet1 = getSet(nums1);
        int[] numSet2 = getSet(nums2);
        int p1 = 0, p2 = 0;
        List<Integer> resList = new ArrayList<>();

        while (p1 < numSet1.length && p2 < numSet2.length) {
            if (numSet1[p1] < numSet2[p2]) {
                p1 += 1;
            } else if (numSet1[p1] > numSet2[p2]) {
                p2 += 1;
            } else {
                resList.add(numSet1[p1]);
                p1 += 1;
                p2 += 1;
            }
        }
        return listToArr(resList);
    }

    public int[] getSet(int[] nums) {
        int p = 1, len = nums.length, duplicateCounter = 1;
        if (len < 1) {
            return new int[] {};
        }
        Arrays.sort(nums);
        List<Integer> resList = new ArrayList<>();
        resList.add(nums[0]);
        while (p < len) {
            if (nums[p - 1] == nums[p]) {
                duplicateCounter += 1;
            } else {
                duplicateCounter = 1;
            }
            if (duplicateCounter <= 1) {
                resList.add(nums[p]);
            }
            p += 1;
        }
        return listToArr(resList);
    }

    private int[] listToArr(List<Integer> list) {
        int len = list.size();
        int[] resArr = new int[len];
        for (int i = 0; i < len; i += 1) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }
}
