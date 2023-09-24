package Hashing.numberTheory;

public class BinPow {
    public long pow(int n, int pow) {
        long res = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                res *= n;
            }
            pow >>= 1;
            n *= n;
        }
        return res;
    }

    public long powMod(int n, int pow, int mod) {
        long res = 1;
        while(pow > 0) {
            if ((pow & 1) == 1) {
                res = res * n % mod;
            }
            n = n * n % mod;
            pow >>= 1;
        }
        return res;
    }
}
