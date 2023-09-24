package Hashing.polynomialHash;

import Hashing.numberTheory.BinPow;
import Hashing.numberTheory.Factorization;
import Hashing.numberTheory.GCD;

import java.util.Objects;

public class PolynomialHash {
    private final int p = (int) 1e5 + 3;
    private final int mod = (int) 1e9 + 7;
    private final int[] pows = pows();

    public int[] prefixHashes(String s) {
        int len = s.length();
        int[] hashes = new int[len];
        if (Objects.equals("", s)) {
            return hashes;
        }
        hashes[0] = (s.charAt(0) - 'a' + 1) * pows[0] % mod;
        for (int i = 1; i < len; i += 1) {
            hashes[i] = hashes[i - 1] + (s.charAt(i) - 'a' + 1) * pows[i] % mod;
        }
        return hashes;
    }

    public int[] getPows() {
        return pows;
    }

    public long getReverseMod(int n) {
        BinPow binPow = new BinPow();
        return binPow.powMod(n, mod - 2, mod);
    }

    private int[] pows() {
        int[] pows = new int[p + 1];
        pows[0] = 1;
        for (int i = 1; i < p; i += 1) {
            pows[i] = pows[i - 1] * p;
        }
        return pows;
    }
}
