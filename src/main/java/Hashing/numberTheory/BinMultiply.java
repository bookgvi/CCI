package Hashing.numberTheory;

public class BinMultiply {
    public long calculate(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int sign = Integer.signum(b);
        b = (b | ~(1 << 31)) + 1 == 0 ? ~b + 1 : b;
        long res = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                res += a;
            }
            a += a;
            b >>= 1;
        }
        return sign < 0 ? -res : res;
    }

}
