package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    private final List<List<Integer>> subsets = new ArrayList<>();
    private final List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> getSubsets(int[] set) {
        backTrack(set, 0);
        return subsets;
    }

    private void backTrack(int[] set, int index) {
        if (subsets.size() == getSubsetsCount(set) - 1) {
            return;
        }
        for (int i = index, len = set.length; i < len; i += 1) {
            if (isValid(set, i)) {
                place(set[i]);
                backTrack(set, index + 1);
                removePrev();
            }
        }
    }

    private void removePrev() {
        subset.remove(subset.size() - 1);
    }

    private void place(int elt) {
        subset.add(elt);
        subsets.add(new ArrayList<>(subset));
    }

    private boolean isValid(int[] set, int index) {
        if (subset.size() > 0) {
            return set[index] > subset.get(subset.size() - 1);
        }
        return true;
    }

    private int getSubsetsCount(int[] set) {
//        return pow(2, set.length);
        return 1 << set.length;
    }

    private int pow(int i, int n) {
        int res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res *= i;
            i *= i;
            n >>= 1;
        }
        return res;
    }
}
