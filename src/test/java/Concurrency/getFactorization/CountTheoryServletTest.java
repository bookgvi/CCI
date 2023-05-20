package Concurrency.getFactorization;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class CountTheoryServletTest {

    @Test
    public void doGet() {
        CountTheoryServlet f = new CountTheoryServlet();
        IntStream.rangeClosed(1, 15).parallel().forEach(i -> {
            int n = ThreadLocalRandom.current().nextInt(22);
            System.out.printf("factorize %d:\t%s\n", n, Arrays.toString(f.doGetFactorize(n))); //Arrays.toString(f.doGetFactorize(num)));
        });

        System.out.println(f.getCounter());
        System.out.println(f.getCacheNumbers());
    }
}