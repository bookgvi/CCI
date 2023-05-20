package Concurrency.getFactorization;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class CountTheoryServletTest {

    @Test
    public void doGet_test_threadSafe() {
        System.out.println("\n--------------------------- Test1 (synchronize) ------------------------------------------");
        int bound = 222222;
        CountTheoryServlet f = new CountTheoryServlet();
        IntStream.rangeClosed(1, bound).parallel().forEach(i -> {
            int n = ThreadLocalRandom.current().nextInt(bound);
            Integer[] factorizeArr = f.doGetFactorize(n);
//            System.out.printf("factorize %d:\t%s\n", n, Arrays.toString(factorizeArr));
        });

//        System.out.println();
        IntStream.rangeClosed(1, 15).forEach(i -> {
            int n = ThreadLocalRandom.current().nextInt(bound);
            System.out.printf("factorize %d:\t%s\n", n, Arrays.toString(f.doGetFactorize(n)));
        });

        System.out.printf("Cache uses: %d\n", f.getCacheUse());
//        System.out.println(f.getCacheNumbers());
        System.out.println("--------------------------- End of Test1 (synchronize) -------------------------------------\n");
    }

    @Test
    public void doGet_test_immutable() {
        System.out.println("\n--------------------------- Test2 (immutable) ------------------------------------------");
        CountTheoryServlet f = new CountTheoryServlet();
        IntStream.rangeClosed(1, 15).parallel().forEach(i -> {
            int n = ThreadLocalRandom.current().nextInt(5);
            System.out.printf("factorize %d:\t%s\n", n, Arrays.toString(f.doGetFactorize2(n)));
        });
        System.out.println("--------------------------- End of Test2 (immutable) -------------------------------------\n");
    }

    @Test
    public void doGet_test_immutable_3() {
        System.out.println("\n--------------------------- Test3 (immutable) ------------------------------------------");
        CountTheoryServlet f = new CountTheoryServlet();
        IntStream.rangeClosed(1, 15).parallel().forEach(i -> {
            int n = ThreadLocalRandom.current().nextInt(15);
            System.out.printf("factorize %d:\t%s\n", n, Arrays.toString(f.doGetFactorize3(n)));
        });
        System.out.println("--------------------------- End of Test3 (immutable) -------------------------------------\n");
    }
}