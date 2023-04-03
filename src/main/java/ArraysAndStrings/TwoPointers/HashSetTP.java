package ArraysAndStrings.TwoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HashSetTP {
    public List<Integer> convert(int[] arr) {
        int counter = 1, len = arr.length;
        List<Integer> set = new ArrayList<>();
        set.add(arr[0]);
        for (int i = 1; i < len; i += 1) {
            if (arr[i - 1] == arr[i]) {
                counter += 1;
            } else {
                counter = 1;
            }
            if (counter <= 1) {
                set.add(arr[i]);
            }
        }
        return set;
    }

    public List<Integer> convert(List<Integer> arr) {
        List<Integer> set = new ArrayList<>();
        if (arr == null) {
            return set;
        }
        arr = arr.stream().sorted().collect(Collectors.toList());
        set.add(arr.get(0));
        int counter = 1, len = arr.size();
        for (int i = 1; i < len; i += 1) {
            if (Objects.equals(arr.get(i - 1),arr.get(i))) {
                counter += 1;
            } else {
                counter = 1;
            }
            if (counter <= 1) {
                set.add(arr.get(i));
            }
        }
        return set;
    }

    public List<Integer> convert(int[] ... arr) {
        int count = arr.length, i = 0;
        List<Integer> concatList = new ArrayList<>();
        while (i < count) {
            for (int elt : arr[i++]) {
                concatList.add(elt);
            }
        }
        return convert(concatList);
    }
}
