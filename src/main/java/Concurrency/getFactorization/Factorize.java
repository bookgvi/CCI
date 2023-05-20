package Concurrency.getFactorization;

import java.util.Arrays;

public class Factorize {
    static Integer[] proceed(int n) {
        if (n < 2) {
            return new Integer[]{n};
        }
        Integer[] fact = new Integer[n];
        int index = 0;
        for (int i = 2; i * i <= n; i += 1) {
            while (n % i == 0) {
                fact[index++] = i;
                n /= i;
            }
        }
        if (n > 1) {
            fact[index++] = n;
        }
        return Arrays.copyOf(fact, index);
    }
}
