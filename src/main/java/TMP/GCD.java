package TMP;

public class GCD {
    public int evklid(int a, int b) {
        if (a == 0) return b;
        return evklid(b % a, a);
    }
}
