package ArraysAndStrings.TwoPointers;

import java.util.*;

public class ConcatTwoArraysToOneAloneWithNaturalOrdering {
    public int[] processed(int[] arr1, int[] arr2) {
        arr1 = arr1 == null ? new int[]{} : arr1;
        arr2 = arr2 == null ? new int[]{} : arr2;

        int len1 = arr1.length, len2 = arr2.length, len = len1 + len2;
        int[] resArr = new int[len];
        int p1 = 0, p2 = 0, i = 0;
        while (p1 < len1 && p2 < len2) {
            int elt = 0;
            if (arr1[p1] < arr2[p2]) {
                elt = arr1[p1++];
            } else {
                elt = arr2[p2++];
            }
            resArr[i++] = elt;
        }
        while(p1 < len1) {
            resArr[i++] = arr1[p1++];
        }
        while(p2 < len2) {
            resArr[i++] = arr2[p2++];
        }
        return resArr;
    }

    public <T> Set<T> merge(Collection<T> firstCollection, Collection<T> secondCollection) {
        Set<T> res = new HashSet<>();
        firstCollection = firstCollection == null ? new HashSet<>() : firstCollection;
        secondCollection = secondCollection == null ? new HashSet<>() : secondCollection;

        Iterator<T> it1 = firstCollection.iterator();
        Iterator<T> it2 = secondCollection.iterator();
        while(it1.hasNext() && it2.hasNext()) {
            res.add(it1.next());
            res.add(it2.next());
        }
        while(it1.hasNext()) {
            res.add(it1.next());
        }
        while(it2.hasNext()) {
            res.add(it2.next());
        }
        return res;
    }

}
