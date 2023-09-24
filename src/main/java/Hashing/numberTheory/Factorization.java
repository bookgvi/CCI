package Hashing.numberTheory;

import java.util.*;

public class Factorization {
    private int eulerFunc = 0; // функция Эйлера - количество взаимно простых чисел

    public Collection<Integer> getFactorization(int n) {
        List<Integer> f = new ArrayList<>();
        eulerFunc = n;
        if (n == 1) {
            return Collections.singletonList(1);
        }
        for (int i = 2; i * i <= n; i += 1) {
            if (n % i == 0) {
                while (n % i == 0) {
                    f.add(i);
                    n /= i;
                }
                eulerFunc -= eulerFunc / i;
            }
        }
        if (n > 1) {
            f.add(n);
            eulerFunc -= eulerFunc / n;
        }
        return f;
    }

    public int getEulerFunc() {
        return eulerFunc;
    }

    public int getEulerFunc(int n) {
        getFactorization(n);
        return eulerFunc;
    }
}
