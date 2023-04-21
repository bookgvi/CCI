package ArraysAndStrings.TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">...</a>
 * There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number
 * of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
 * <p>
 * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
 * they will have the greatest number of candies among all the kids, or false otherwise.
 * <p>
 * Note that multiple kids can have the greatest number of candies.
 */
public class KidsWithGreatestNumberCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = candies[0];
        for (int elt : candies) {
            max = Math.max(max, elt);
        }
        for (int elt : candies) {
            res.add(elt + extraCandies >= max);
        }
        return res;
    }
}
