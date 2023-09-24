package Hashing.numberTheory;

public class GCD {
    public int getGCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return getGCD(b % a, a);
    }
}
