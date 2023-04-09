package Hashing;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumIndexSumTwoListsTest {

    @Test
    public void findRestaurant_test1() {
        String[] list1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] ansList = new String[]{"Shogun"};

        MinimumIndexSumTwoLists m = new MinimumIndexSumTwoLists();
        Assert.assertArrayEquals(ansList, m.findRestaurant(list1, list2));
    }
}