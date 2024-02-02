package graph.task;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int num = 0;
        int i = 10, k = 1, j = k;
        int tmpLow = low;
        while (low > 0) {
            low /= 10;
            num = (num * i) + j++;
        }
        if (num > high) {
            return res;
        }
        if (num >= tmpLow) {
            res.add(num);
        }
        int n = j - 1;
        while (high >= num) {
            j = ++k;
            num = 0;
            for (int a = 0; a < n; ++a) {
                num = (num * i) + j++;
            }
            if (j > 10) {
                ++n;
                k = 0;
            } else if (num <= high && num >= tmpLow) {
                res.add(num);
            }
        }
        return res;
    }
}
