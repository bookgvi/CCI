package TMP;

import java.util.Arrays;

public class Factorize {
    public int[] proceed(int num) {
        int[] res = new int[num];
        int index = 0;
        for (int i = 2; i * i <= num; i += 1) {
            while (num % i == 0) {
                res[index++] = i;
                num /= i;
            }
        }
        if (num > 1) {
            res[index++] = num;
        }
        return Arrays.copyOf(res, index);
    }

    public int[] getPrimes(int num) {
        int[] ans = new int[num];
        int index = 0;
        for (int i = 2; i * i <= num; i += 1) {
            if (num % i == 0) {
                while (num % i == 0) {
                    ans[index++] = i;
                    num /= i;
                }
            }
        }
        if (num > 1) {
            ans[index++] = num;
        }
        return Arrays.copyOf(ans, index);
    }

    public int[] primes(int n) {
        int[] factorize = new int[n];
        int index = 0;
        for (int i = 2; i * i <= n; i += 1) {
            while (n % i == 0) {
                n /= i;
                factorize[index++] = i;
            }
        }
        return Arrays.copyOf(factorize, index);
    }
}
