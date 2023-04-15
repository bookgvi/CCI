package TMP;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FactorizeTest {

    @Test
    public void getPrimes_test1() {
        int num = 12;
        Factorize f = new Factorize();
        int[] primes = f.getPrimes(num);
        System.out.println(Arrays.toString(primes));
    }
}