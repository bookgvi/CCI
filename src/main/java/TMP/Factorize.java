package TMP;

import java.util.Arrays;

public class Factorize {
    public int[] getPrimes(int num) {
        int[] ans = new int[num];
        int index = 0;
        for (int i = 2; i * i < num; i += 1) {
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
}
