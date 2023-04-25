package TMP;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class MergeCollectionsTest {

    @Test
    public void mergeTwoCollections_test1() {
        Set<Integer> l1 = Arrays.stream(new int[]{1,2,3,4,4,5}).boxed().collect(Collectors.toSet());
        Set<Integer> l2 = Arrays.stream(new int[]{6,7,8}).boxed().collect(Collectors.toSet());
        Set<Integer> ans = Arrays.stream(new int[]{1,2,3,4,4,5,6,7,8}).boxed().collect(Collectors.toSet());
        MergeCollections m = new MergeCollections();
        Set<Integer> res = (Set<Integer>) m.mergeTwoCollections(l1, l2);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void mergeTwoCollections_test2() {
        Set<Integer> l1 = Arrays.stream(new int[]{1,2,3,4,4,5}).boxed().collect(Collectors.toSet());
        Set<Integer> l2 = Arrays.stream(new int[]{}).boxed().collect(Collectors.toSet());
        Set<Integer> ans = Arrays.stream(new int[]{1,2,3,4,5}).boxed().collect(Collectors.toSet());
        MergeCollections m = new MergeCollections();
        Set<Integer> res = (Set<Integer>) m.mergeTwoCollections(l1, l2);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void mergeTwoCollections_test3() {
        Set<Integer> l1 = Arrays.stream(new int[]{1,2,3,4,4,5}).boxed().collect(Collectors.toSet());
        Set<Integer> l2 = Arrays.stream(new int[]{1,2,3,4,4,5}).boxed().collect(Collectors.toSet());
        Set<Integer> ans = Arrays.stream(new int[]{1,2,3,4,5}).boxed().collect(Collectors.toSet());
        MergeCollections m = new MergeCollections();
        Set<Integer> res = (Set<Integer>) m.mergeTwoCollections(l1, l2);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void mergeTwoCollections_test4() {
        Set<Integer> l1 = null;
        Set<Integer> l2 = Arrays.stream(new int[]{1,2,3,4,4,5}).boxed().collect(Collectors.toSet());
        Set<Integer> ans = Arrays.stream(new int[]{1,2,3,4,5}).boxed().collect(Collectors.toSet());
        MergeCollections m = new MergeCollections();
        Set<Integer> res = (Set<Integer>) m.mergeTwoCollections(l1, l2);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void mergeTwoCollections_test5() {
        Set<Integer> l2 = null;
        Set<Integer> l1 = Arrays.stream(new int[]{1,2,3,4,4,5}).boxed().collect(Collectors.toSet());
        Set<Integer> ans = Arrays.stream(new int[]{1,2,3,4,5}).boxed().collect(Collectors.toSet());
        MergeCollections m = new MergeCollections();
        Set<Integer> res = (Set<Integer>) MergeCollections.mergeCollections(l1, l2);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void mergeTwoCollections_test6() {
        Set<Integer> l2 = null;
        Set<Integer> l1 = null;
        Set<Integer> ans = Collections.emptySet();
        MergeCollections m = new MergeCollections();
        Set<Integer> res = (Set<Integer>) m.mergeTwoCollections(l1, l2);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void mergeCollections_test1() {
        Set<Integer> l2 = null;
        Set<Integer> l1 = null;
        Set<Integer> l3 = null;
        Set<Integer> ans = Collections.emptySet();
        MergeCollections m = new MergeCollections();
        Set<Integer> res = (Set<Integer>) MergeCollections.mergeCollections(l1, l2, l3);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void mergeCollections_test2() {
        Set<Integer> l1 = null;
        Set<Integer> l2 = null;
        Set<Integer> l3 = null;
        Set<Integer> l4 = Arrays.stream(new int[]{1,2,3,4,5}).boxed().collect(Collectors.toSet());
        Set<Integer> ans = Arrays.stream(new int[]{1,2,3,4,5}).boxed().collect(Collectors.toSet());
        MergeCollections m = new MergeCollections();
        Set<Integer> res = (Set<Integer>) MergeCollections.mergeCollections(l1, l2, l3, l4);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void mergeCollections_test3() {
        Set<Integer> l1 = null;
        Set<Integer> l2 = null;
        Set<Integer> l3 = Arrays.stream(new int[]{1,2,3,4,5}).boxed().collect(Collectors.toSet());
        Set<Integer> l4 = Arrays.stream(new int[]{1,2,3,4,5}).boxed().collect(Collectors.toSet());
        Set<Integer> ans = Arrays.stream(new int[]{1,2,3,4,5}).boxed().collect(Collectors.toSet());
        MergeCollections m = new MergeCollections();
        Set<Integer> res = (Set<Integer>) MergeCollections.mergeCollections(l1, l2, l3, l4);
        Assert.assertEquals(ans, res);
    }

    @Test
    public void mergeCollections_test4() {
        Set<Integer> l1 = null;
        Set<Integer> l2 = Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9,0}).boxed().collect(Collectors.toSet());
        Set<Integer> l3 = Arrays.stream(new int[]{1,2,3,4,5,111}).boxed().collect(Collectors.toSet());
        Set<Integer> l4 = Arrays.stream(new int[]{1,2,3,4,5,11}).boxed().collect(Collectors.toSet());
        Set<Integer> ans = Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9,0,11,111}).boxed().collect(Collectors.toSet());
        MergeCollections m = new MergeCollections();
        Set<Integer> res = (Set<Integer>) MergeCollections.mergeCollections(l1, l2, l3, l4);
        Assert.assertEquals(ans, res);
    }
}