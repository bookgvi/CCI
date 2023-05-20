package TMP;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FactorizeTest {

    @Test
    public void getPrimes_test1() {
        int num = 1728;
        Factorize f = new Factorize();
        int[] primes = f.getPrimes(num);
        System.out.printf("num = %d:\t%s\n",num, Arrays.toString(primes));
        System.out.println();
    }

    @Test
    public void getPrimes_test2() {
        int num = 12;
        int num2 = 13;
        Factorize f = new Factorize();
        int[] primes1 = f.getPrimes(num);
        int[] primes2 = f.getPrimes(num2);
        System.out.printf("num = %d:\t%s\n",num, Arrays.toString(primes1));
        System.out.printf("num = %d:\t%s\n",num2, Arrays.toString(primes2));
        System.out.println();
    }

    @Test
    public void getPrimes_test3() {
        int num = 9;
        int num2 = 10;
        Factorize f = new Factorize();
        int[] primes1 = f.proceed(num);
        int[] primes2 = f.proceed(num2);
        System.out.printf("num = %d:\t%s\n",num, Arrays.toString(primes1));
        System.out.printf("num = %d:\t%s\n",num2, Arrays.toString(primes2));
        System.out.println();
    }


    @Test
    public void getPrimes_test4() {
        System.out.println("Test4:");
        int num = 42;
        int num2 = 55;
        Factorize f = new Factorize();
        int[] primes1 = f.proceed(num);
        int[] primes2 = f.proceed(num2);
        System.out.printf("num = %d:\t%s\n",num, Arrays.toString(primes1));
        System.out.printf("num = %d:\t%s\n",num2, Arrays.toString(primes2));
        GCD gcd = new GCD();
        System.out.printf("GCD(%d, %d) = %d\n", num, num2, gcd.evklid(num, num2));
        System.out.println();
    }

    @Test
    public void getPrimes_test5() {
        int num = 120;
        Factorize f = new Factorize();
        int[] primes = f.getPrimes(num);
        System.out.printf("num = %d:\t%s\n",num, Arrays.toString(primes));
        System.out.println();
    }

    @Test
    public void getPrimes_test6() {
        int num = 27000;
        Factorize f = new Factorize();
        int[] primes = f.getPrimes(num);
        System.out.printf("num = %d:\t%s\n",num, Arrays.toString(primes));
        System.out.println();
    }

    @Test
    public void getPrimes_test7() {
        int num1 = 10;
        int num2 = 14;
        int num3 = 35;
        int num4 = 720;
        Factorize f = new Factorize();
        int[] primes1 = f.getPrimes(num1);
        int[] primes2 = f.getPrimes(num2);
        int[] primes3 = f.getPrimes(num3);
        int[] primes4 = f.getPrimes(num4);
        System.out.printf("num = %d:\t%s\n",num1, Arrays.toString(primes1));
        System.out.printf("num = %d:\t%s\n",num2, Arrays.toString(primes2));
        System.out.printf("num = %d:\t%s\n",num3, Arrays.toString(primes3));
        System.out.printf("num = %d:\t%s\n",num4, Arrays.toString(primes4));
        System.out.println();
    }

}